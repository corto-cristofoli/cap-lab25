# Visitor to *interpret* MiniC files
from math import copysign
from typing import (
  Dict,
  List)
from MiniCVisitor import MiniCVisitor
from MiniCParser import MiniCParser
from Lib.Errors import MiniCRuntimeError, MiniCInternalError, MiniCUnsupportedError

MINIC_VALUE = int | str | bool | float | List['MINIC_VALUE']


class MiniCInterpretVisitor(MiniCVisitor):

    _memory: Dict[str, MINIC_VALUE]

    def __init__(self):
        self._memory = dict()  # store all variable ids and values.
        self.has_main = False

    # visitors for variable declarations

    def visitVarDecl(self, ctx) -> None:
        # Initialise all variables in self._memory
        initial_val = {
                "int": 0,
                "float": 0.0,
                "bool": False,
                "string": ""
                }
        type_str = ctx.typee().getText()
        id_str_l = self.visit(ctx.id_l())
        for id_str in id_str_l:
            self._memory[id_str] = initial_val[type_str]

    def visitIdList(self, ctx) -> List[str]:
        queue = self.visit(ctx.id_l())
        queue.append(ctx.ID().getText())
        return queue

    def visitIdListBase(self, ctx) -> List[str]:
        return [ctx.ID().getText()]

    # visitors for atoms --> value

    def visitParExpr(self, ctx) -> MINIC_VALUE:
        return self.visit(ctx.expr())

    def visitIntAtom(self, ctx) -> int:
        return int(ctx.getText())

    def visitFloatAtom(self, ctx) -> float:
        return float(ctx.getText())

    def visitBooleanAtom(self, ctx) -> bool:
        return ctx.getText() == "true"

    def visitIdAtom(self, ctx) -> MINIC_VALUE:
        # raise NotImplementedError()
        id_str = ctx.getText()
        # if id_str not in self._memory:
        #     raise MiniCRuntimeError("Variable {} not defined".format(id_str))
        return self._memory[id_str]

    def visitStringAtom(self, ctx) -> str:
        return ctx.getText()[1:-1]  # Remove the ""

    # visit expressions

    def visitAtomExpr(self, ctx) -> MINIC_VALUE:
        return self.visit(ctx.atom())

    def visitOrExpr(self, ctx) -> bool:
        lval = self.visit(ctx.expr(0))
        rval = self.visit(ctx.expr(1))
        return lval | rval

    def visitAndExpr(self, ctx) -> bool:
        lval = self.visit(ctx.expr(0))
        rval = self.visit(ctx.expr(1))
        return lval & rval

    def visitEqualityExpr(self, ctx) -> bool:
        assert ctx.myop is not None
        lval = self.visit(ctx.expr(0))
        rval = self.visit(ctx.expr(1))
        # be careful for float equality
        if ctx.myop.type == MiniCParser.EQ:
            return lval == rval
        else:
            return lval != rval

    def visitRelationalExpr(self, ctx) -> bool:
        assert ctx.myop is not None
        lval = self.visit(ctx.expr(0))
        rval = self.visit(ctx.expr(1))
        if ctx.myop.type == MiniCParser.LT:
            return lval < rval
        elif ctx.myop.type == MiniCParser.LTEQ:
            return lval <= rval
        elif ctx.myop.type == MiniCParser.GT:
            return lval > rval
        elif ctx.myop.type == MiniCParser.GTEQ:
            return lval >= rval
        else:
            raise MiniCInternalError(
                f"Unknown comparison operator '{ctx.myop}'"
            )

    def visitAdditiveExpr(self, ctx) -> MINIC_VALUE:
        assert ctx.myop is not None
        lval = self.visit(ctx.expr(0))
        rval = self.visit(ctx.expr(1))
        if ctx.myop.type == MiniCParser.PLUS:
            if any(isinstance(x, str) for x in (lval, rval)):
                return f'{lval}{rval}'
            else:
                return lval + rval
        elif ctx.myop.type == MiniCParser.MINUS:
            return lval - rval
        else:
            raise MiniCInternalError(
                f"Unknown additive operator '{ctx.myop}'")

    def visitMultiplicativeExpr(self, ctx) -> MINIC_VALUE:
        assert ctx.myop is not None
        lval = self.visit(ctx.expr(0))
        rval = self.visit(ctx.expr(1))
        match ctx.myop.type:
            case MiniCParser.MULT:
                return lval * rval
            case MiniCParser.DIV:
                if rval == 0:
                    raise MiniCRuntimeError("Division by 0")
                if isinstance(lval, int):
                    # int division in C different that in Python
                    s, l, r = lval * rval, abs(lval), abs(rval)
                    return int(copysign(l // r, s))
                else:
                    return lval / rval
            case MiniCParser.MOD:
                if rval == 0:
                    raise MiniCRuntimeError("Modulo by 0")
                # modulo in C different that in Python
                # we use the fact that a = (a//b)*b + a%b
                s, l, r = lval * rval, abs(lval), abs(rval)
                div = int(copysign(l // r, s))
                return lval - div * rval
            case _: raise MiniCInternalError(
                    f"Unknown multiplicative operator '{ctx.myop}'")

    def visitNotExpr(self, ctx) -> bool:
        return not self.visit(ctx.expr())

    def visitUnaryMinusExpr(self, ctx) -> MINIC_VALUE:
        return -self.visit(ctx.expr())

    # visit statements

    def visitPrintlnintStat(self, ctx) -> None:
        val = self.visit(ctx.expr())
        assert isinstance(val, int)
        print(val)

    def visitPrintlnfloatStat(self, ctx) -> None:
        val = self.visit(ctx.expr())
        assert isinstance(val, float)
        print(f"{val:.2f}")

    def visitPrintlnboolStat(self, ctx) -> None:
        val = self.visit(ctx.expr())
        assert isinstance(val, bool)
        print('1' if val else '0')

    def visitPrintlnstringStat(self, ctx) -> None:
        val = self.visit(ctx.expr())
        assert isinstance(val, str)
        print(val)

    def visitAssignStat(self, ctx) -> None:
        val = self.visit(ctx.expr())
        Id = ctx.ID().getText()
        if Id not in self._memory:
            raise MiniCRuntimeError("Variable {} not initialised".format(Id))
        self._memory[Id] = val

    def visitIfStat(self, ctx) -> None:
        # raise NotImplementedError()
        b_val = self.visit(ctx.expr())
        if b_val:
            try:
                self.visit(ctx.stat_block())
            except AttributeError:
                self.visit(ctx.stat_block(0))
        else:
            try:
                self.visit(ctx.stat_block(1))
            except AttributeError:
                pass  # if there is no else condition we simply skip

    def visitWhileStat(self, ctx) -> None:
        # raise NotImplementedError()
        b_val = self.visit(ctx.expr())
        while b_val:
            self.visit(ctx.stat_block())
            b_val = self.visit(ctx.expr())

    def visitForStat(self, ctx) -> None:
        if ctx.init_assign is not None:
            self.visit(ctx.init_assign)
        cond: int = self.visit(ctx.cond) if ctx.cond is not None else 1
        while cond:
            self.visit(ctx.body)
            if ctx.loop_assign is not None:
                self.visit(ctx.loop_assign)
            cond: int = self.visit(ctx.cond) if ctx.cond is not None else 1

    # TOPLEVEL
    def visitProgRule(self, ctx) -> None:
        self.visitChildren(ctx)
        if not self.has_main:
            # A program without a main function is compilable (hence
            # it's not a typing error per se), but not executable,
            # hence we consider it a runtime error.
            raise MiniCRuntimeError("No main function in file")

    # Visit a function: ignore if non main!
    def visitFuncDef(self, ctx) -> None:
        funname = ctx.ID().getText()
        if funname == "main":
            self.has_main = True
            self.visit(ctx.vardecl_l())
            self.visit(ctx.block())
        else:
            raise MiniCUnsupportedError(
                "Functions are not supported in evaluation mode")

    def visitFuncCall(self, ctx) -> None:  # pragma: no cover
        raise MiniCUnsupportedError(
            "Functions are not supported in evaluation mode")
