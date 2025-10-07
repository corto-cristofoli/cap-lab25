from typing import Callable, List
from MiniCVisitor import MiniCVisitor
from MiniCParser import MiniCParser
from Lib.LinearCode import CodeStatement, LinearCode
from Lib import RiscV
from Lib.RiscV import Condition
from Lib import Operands
from antlr4.tree.Trees import Trees
from Lib.Errors import MiniCInternalError, MiniCUnsupportedError

"""
CAP, MIF08, three-address code generation + simple alloc
This visitor constructs an object of type "LinearCode".
"""


class MiniCCodeGen3AVisitor(MiniCVisitor):

    _current_function: LinearCode
    # Shortcuts for methods of member objects
    fresh_tmp: Callable[[], Operands.Temporary]
    fresh_label: Callable[[str], RiscV.Label]
    add_statement: Callable[[CodeStatement], None]
    add_instruction_PRINTLN_INT: Callable[[Operands.DataLocation], None]
    add_comment: Callable[[str], None]
    get_label_div_by_zero: Callable[[], RiscV.Label]

    def __init__(self, debug, parser):
        super().__init__()
        self._parser = parser
        self._debug = debug
        self._functions = []
        self._lastlabel = ""

    def get_functions(self) -> List[LinearCode]:
        return self._functions

    def printSymbolTable(self):  # pragma: no cover
        print("--variables to temporaries map--")
        for keys, values in self._symbol_table.items():
            print(keys + '-->' + str(values))

    # handle variable decl

    def visitVarDecl(self, ctx) -> None:
        type_str = ctx.typee().getText()
        vars_l = self.visit(ctx.id_l())
        for name in vars_l:
            if name in self._symbol_table:
                raise MiniCInternalError(
                    f"Variable {name} has already been declared")
            else:
                tmp = self.fresh_tmp()
                self._symbol_table[name] = tmp
                if type_str not in ("int", "bool"):
                    raise MiniCUnsupportedError(f"Unsupported type {type_str}")
                # Initialization to 0 or False, both represented with 0
                self.add_statement(
                    RiscV.li(tmp, Operands.Immediate(0)))

    def visitIdList(self, ctx) -> List[str]:
        t = self.visit(ctx.id_l())
        t.append(ctx.ID().getText())
        return t

    def visitIdListBase(self, ctx) -> List[str]:
        return [ctx.ID().getText()]

    # expressions

    def visitParExpr(self, ctx) -> Operands.Temporary:
        return self.visit(ctx.expr())

    def visitIntAtom(self, ctx) -> Operands.Temporary:
        val = Operands.Immediate(int(ctx.getText()))
        dest_temp = self.fresh_tmp()
        self.add_statement(RiscV.li(dest_temp, val))
        return dest_temp

    def visitFloatAtom(self, ctx) -> Operands.Temporary:
        raise MiniCUnsupportedError("float literal")

    def visitBooleanAtom(self, ctx) -> Operands.Temporary:
        # true is 1 false is 0
        if ctx.getText() == "true":
            val = Operands.Immediate(1)
        elif ctx.getText() == "false":
            val = Operands.Immediate(0)
        else:
            raise MiniCInternalError("boolean literal")
        dest_temp = self.fresh_tmp()
        self.add_statement(RiscV.li(dest_temp, val))
        return dest_temp

    def visitIdAtom(self, ctx) -> Operands.Temporary:
        try:
            # get the temporary associated to id
            return self._symbol_table[ctx.getText()]
        except KeyError:  # pragma: no cover
            raise MiniCInternalError(
                f"Undefined variable {ctx.getText()}, this should have failed to typecheck."
            )

    def visitStringAtom(self, ctx) -> Operands.Temporary:
        raise MiniCUnsupportedError("string atom")

    # now visit expressions

    def visitAtomExpr(self, ctx) -> Operands.Temporary:
        return self.visit(ctx.atom())

    def visitAdditiveExpr(self, ctx) -> Operands.Temporary:
        assert ctx.myop is not None
        tmpl: Operands.Temporary = self.visit(ctx.expr(0))
        tmpr: Operands.Temporary = self.visit(ctx.expr(1))
        dest_temp = self.fresh_tmp()

        if ctx.myop.type == MiniCParser.PLUS:
            self.add_statement(
                    RiscV.add(dest_temp, tmpl, tmpr))
        elif ctx.myop.type == MiniCParser.MINUS:
            self.add_statement(
                    RiscV.sub(dest_temp, tmpl, tmpr))
        else:
            raise MiniCInternalError("add operator")
        return dest_temp

    def visitOrExpr(self, ctx) -> Operands.Temporary:
        tmpl: Operands.Temporary = self.visit(ctx.expr(0))
        tmpr: Operands.Temporary = self.visit(ctx.expr(1))
        dest_temp = self.fresh_tmp()
        self.add_statement(
                RiscV.lor(dest_temp, tmpl, tmpr))
        return dest_temp

    def visitAndExpr(self, ctx) -> Operands.Temporary:
        tmpl: Operands.Temporary = self.visit(ctx.expr(0))
        tmpr: Operands.Temporary = self.visit(ctx.expr(1))
        dest_temp = self.fresh_tmp()
        self.add_statement(
                RiscV.land(dest_temp, tmpl, tmpr))
        return dest_temp

    def visitEqualityExpr(self, ctx) -> Operands.Temporary:
        return self.visitRelationalExpr(ctx)

    def visitRelationalExpr(self, ctx) -> Operands.Temporary:
        assert ctx.myop is not None
        c = Condition(ctx.myop.type)
        if self._debug:
            print("relational expression:")
            print(Trees.toStringTree(ctx, [], self._parser))
            print("Condition:", c)
        # raise NotImplementedError()
        ONE = Operands.Immediate(1)  # NOTE: should be 1
        relation = ctx.myop.type
        dest_temp = self.fresh_tmp()
        tmpl = self.visit(ctx.expr(0))
        tmpr = self.visit(ctx.expr(1))
        if relation == MiniCParser.NEQ:  # x!=y  <=>  x^y
            self.add_statement(
                    RiscV.xor(dest_temp, tmpl, tmpr))
            self.add_statement(  # b&&1=1 if b != 0
                   RiscV.land(dest_temp, dest_temp, ONE))
        elif relation == MiniCParser.EQ:  # x==y <=> (x^y)^1
            self.add_statement(
                    RiscV.xor(dest_temp, tmpl, tmpr))
            self.add_statement(  # b&&1=1 if b != 0
                   RiscV.land(dest_temp, dest_temp, ONE))
            self.add_statement(
                    RiscV.xor(dest_temp, dest_temp, ONE))
        # HACK: I added slt into lib/RiscV
        elif relation == MiniCParser.LTEQ:  # x<=y  <=>  (x>y)^1
            self.add_statement(
                    RiscV.slt(dest_temp, tmpr, tmpl))
            self.add_statement(
                    RiscV.xor(dest_temp, dest_temp, ONE))
        elif relation == MiniCParser.GTEQ:  # x>=y  <=>  (x<y)^1
            self.add_statement(
                    RiscV.slt(dest_temp, tmpl, tmpr))
            self.add_statement(
                    RiscV.xor(dest_temp, dest_temp, ONE))
        elif relation == MiniCParser.LT:
            self.add_statement(
                    RiscV.slt(dest_temp, tmpl, tmpr))
        elif relation == MiniCParser.GT:
            self.add_statement(
                    RiscV.slt(dest_temp, tmpr, tmpl))
        else:
            raise MiniCInternalError("relational expression")
        return dest_temp

    def visitMultiplicativeExpr(self, ctx) -> Operands.Temporary:
        # TODO: verify / and % match C operations
        assert ctx.myop is not None
        div_by_zero_lbl = self.get_label_div_by_zero()
        tmpl: Operands.Temporary = self.visit(ctx.expr(0))
        tmpr: Operands.Temporary = self.visit(ctx.expr(1))
        dest_temp = self.fresh_tmp()
        if ctx.myop.type == MiniCParser.MULT:
            self.add_statement(
                    RiscV.mul(dest_temp, tmpl, tmpr))
        else:
            # We need to handle division by 0
            self.add_statement(
                    RiscV.conditional_jump(div_by_zero_lbl,
                                           tmpr,
                                           Condition('beq'),
                                           Operands.ZERO)
                    )
            if ctx.myop.type == MiniCParser.DIV:
                self.add_statement(
                        RiscV.div(dest_temp, tmpl, tmpr))
            elif ctx.myop.type == MiniCParser.MOD:
                self.add_statement(
                        RiscV.rem(dest_temp, tmpl, tmpr))
            else:
                raise MiniCInternalError("mult operator")
        return dest_temp

    def visitNotExpr(self, ctx) -> Operands.Temporary:
        tmp = self.visit(ctx.expr())
        dest_temp = self.fresh_tmp()
        self.add_statement(
                RiscV.xor(dest_temp, tmp, Operands.Immediate(1)))
        return dest_temp

    def visitUnaryMinusExpr(self, ctx) -> Operands.Temporary:
        raise NotImplementedError("unaryminusexpr")  # TODO

    def visitProgRule(self, ctx) -> None:
        self.visitChildren(ctx)

    def visitFuncDef(self, ctx) -> None:
        funcname = ctx.ID().getText()
        self._current_function = LinearCode(funcname)

        # Our code can deal with multiple functions, and each function is a
        # different LinearCode object. But don't bother the user with
        # self._current_function each time, define a few shortcuts to make the
        # code simpler. This comes here and not in __init__ since we need
        # _current_function to be set, and need to redefine the shortcut when
        # _current_function changes.
        self.fresh_tmp = self._current_function.fdata.fresh_tmp
        self.fresh_label = self._current_function.fdata.fresh_label
        self.add_statement = self._current_function.add_statement
        self.add_statement = self._current_function.add_statement
        self.add_instruction_PRINTLN_INT = self._current_function.add_instruction_PRINTLN_INT
        self.add_comment = self._current_function.add_comment
        self.get_label_div_by_zero = self._current_function.fdata.get_label_div_by_zero

        self._symbol_table = dict()

        self.visit(ctx.vardecl_l())
        self.visit(ctx.block())
        self.add_comment("Return at end of function:")
        # This skeleton doesn't deal properly with functions, and
        # hardcodes a "return 0;" at the end of function. Generate
        # code for this "return 0;".
        self.add_statement(
            RiscV.li(Operands.A0, Operands.Immediate(0)))
        self._functions.append(self._current_function)
        del self._current_function

    def visitAssignStat(self, ctx) -> None:
        if self._debug:
            print("assign statement, rightexpression is:")
            print(Trees.toStringTree(ctx.expr(), [], self._parser))
        expr_temp = self.visit(ctx.expr())
        name = ctx.ID().getText()
        self.add_statement(RiscV.mv(self._symbol_table[name], expr_temp))

    def visitIfStat(self, ctx) -> None:
        ONE = Operands.Immediate(1)
        if self._debug:
            print("if statement")
        end_if_label = self.fresh_label("end_if")
        raise NotImplementedError()
        cond_tmp = self.visit(ctx.expr())
        # else_label = self._current_function.fdata.fresh_label("else")
        self.add_statement( # TODO : on saute si c'est pas le bon label
                RiscV.conditional_jump(end_if_label,
                                       cond_tmp,
                                       Condition('beq'),
                                       ONE)
                )
        # TODO : gérer le cas du else
        self.visit(ctx.stat_block())
        # self._current_function.add_label(else_label)
        # self.visit(ctx.stat_block(1))
        self.add_statement(end_if_label)

    def visitWhileStat(self, ctx) -> None:
        if self._debug:
            print("while statement, condition is:")
            print(Trees.toStringTree(ctx.expr(), [], self._parser))
            print("and block is:")
            print(Trees.toStringTree(ctx.stat_block(), [], self._parser))
        raise NotImplementedError()  # TODO
    # visit statements

    def visitPrintlnintStat(self, ctx) -> None:
        expr_loc = self.visit(ctx.expr())
        if self._debug:
            print("print_int statement, expression is:")
            print(Trees.toStringTree(ctx.expr(), [], self._parser))
        self.add_instruction_PRINTLN_INT(expr_loc)

    def visitPrintlnboolStat(self, ctx) -> None:
        expr_loc = self.visit(ctx.expr())
        self.add_instruction_PRINTLN_INT(expr_loc)

    def visitPrintlnfloatStat(self, ctx) -> None:
        raise MiniCUnsupportedError("Unsupported type float")

    def visitPrintlnstringStat(self, ctx) -> None:
        raise MiniCUnsupportedError("Unsupported type string")

    def visitStatList(self, ctx) -> None:
        for stat in ctx.stat():
            self.add_comment(Trees.toStringTree(stat, [], self._parser))
            self.visit(stat)
