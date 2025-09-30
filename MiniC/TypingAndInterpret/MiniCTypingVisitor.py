# Visitor to *typecheck* MiniC files
from typing import List, NoReturn
from MiniCVisitor import MiniCVisitor
from MiniCParser import MiniCParser
from Lib.Errors import MiniCInternalError, MiniCTypeError

from enum import Enum


class BaseType(Enum):
    Float, Integer, Boolean, String = range(4)


# Basic Type Checking for MiniC programs.
class MiniCTypingVisitor(MiniCVisitor):

    def __init__(self):
        self._memorytypes = dict()  # id -> types
        # For now, we don't have real functions ...
        self._current_function = "main"

    def _raise(self, ctx, for_what, *types):
        raise MiniCTypeError(
            f"In function {self._current_function}:"
            f" Line {ctx.start.line} col {ctx.start.column}:"
            f" invalid type for {for_what}:"
            f" {' and '.join(t.name.lower() for t in types)}")

    def _assertSameType(self, ctx, for_what, *types):
        if not all(types[0] == t for t in types):
            raise MiniCTypeError(
                f"In function {self._current_function}:"
                f" Line {ctx.start.line}"
                f" col {ctx.start.column}:"
                f" type mismatch for {for_what}:"
                f" {' and '.join(t.name.lower() for t in types)}")

    def _raiseNonType(self, ctx, message) -> NoReturn:
        raise MiniCTypeError(
            f"In function {self._current_function}:"
            f" Line {ctx.start.line}"
            f" col {ctx.start.column}: {message}")

    # type declaration

    def visitVarDecl(self, ctx) -> None:
        my_type = self.visit(ctx.typee())
        id_str_l = self.visit(ctx.id_l())
        for id_str in id_str_l:
            if id_str in self._memorytypes:
                self._raiseNonType(ctx, f"Variable {id_str} already declared")
            self._memorytypes[id_str] = my_type

    def visitBasicType(self, ctx):
        assert ctx.mytype is not None
        if ctx.mytype.type == MiniCParser.INTTYPE:
            return BaseType.Integer
        elif ctx.mytype.type == MiniCParser.FLOATTYPE:
            return BaseType.Float
        elif ctx.mytype.type == MiniCParser.BOOLTYPE:
            return BaseType.Boolean
        elif ctx.mytype.type == MiniCParser.STRINGTYPE:
            return BaseType.String
        else:
            self._raise(ctx, 'variable declaration', ctx.mytupe.type)

    def visitIdList(self, ctx) -> List[str]:
        queue = self.visit(ctx.id_l())
        queue.append(ctx.ID().getText())
        return queue

    def visitIdListBase(self, ctx) -> List[str]:
        return [ctx.ID().getText()]

    # typing visitors for expressions, statements !

    # visitors for atoms --> type
    def visitParExpr(self, ctx):
        return self.visit(ctx.expr())

    def visitIntAtom(self, ctx):
        return BaseType.Integer

    def visitFloatAtom(self, ctx):
        return BaseType.Float

    def visitBooleanAtom(self, ctx):
        return BaseType.Boolean

    def visitIdAtom(self, ctx):
        try:
            return self._memorytypes[ctx.getText()]
        except KeyError:
            self._raiseNonType(ctx,
                               f"Undefined variable {ctx.getText()}")

    def visitStringAtom(self, ctx):
        return BaseType.String

    # now visit expr

    def visitAtomExpr(self, ctx):
        return self.visit(ctx.atom())

    def visitOrExpr(self, ctx):
        type1 = self.visit(ctx.expr(0))
        if type1 != BaseType.Boolean:
            self._raise(ctx, "or operator", type1)
        type2 = self.visit(ctx.expr(1))
        if type2 != BaseType.Boolean:
            self._raise(ctx, "or operator", type2)
        return BaseType.Boolean

    def visitAndExpr(self, ctx):
        type1 = self.visit(ctx.expr(0))
        if type1 != BaseType.Boolean:
            self._raise(ctx, "and operator", type1)
        type2 = self.visit(ctx.expr(1))
        if type2 != BaseType.Boolean:
            self._raise(ctx, "and operator", type2)
        return BaseType.Boolean

    def visitEqualityExpr(self, ctx):
        assert ctx.myop is not None
        type1 = self.visit(ctx.expr(0))
        type2 = self.visit(ctx.expr(1))
        eq_dic = {MiniCParser.EQ: "==", MiniCParser.NEQ: "!="}
        eq_str = eq_dic[ctx.myop.type]
        if type1 != type2:
            self._assertSameType(ctx, f"{eq_str} comparator", type1, type2)
        return BaseType.Boolean

    def visitRelationalExpr(self, ctx):
        assert ctx.myop is not None
        type1 = self.visit(ctx.expr(0))
        type2 = self.visit(ctx.expr(1))
        if type1 != type2:
            self._assertSameType(ctx, "relational operands", type1, type2)
        if type1 != BaseType.Integer and type1 != BaseType.Float:
            self._raise(ctx, "relational operands", type1)
        return BaseType.Boolean

    def visitAdditiveExpr(self, ctx):
        assert ctx.myop is not None
        type1 = self.visit(ctx.expr(0))
        type2 = self.visit(ctx.expr(1))
        if type1 != BaseType.Integer and type1 != BaseType.Float:
            if type1 == BaseType.String and ctx.myop.type == MiniCParser.PLUS:
                return BaseType.String  # string concatenation
            self._raise(ctx, "additive operands", type1, type2)
        if type1 != type2:
            self._assertSameType(ctx, "additive operands", type1, type2)
        return type1

    def visitMultiplicativeExpr(self, ctx):
        assert ctx.myop is not None
        type1 = self.visit(ctx.expr(0))
        type2 = self.visit(ctx.expr(1))
        if type1 != type2:
            self._raise(ctx, "multiplicative operands", type1, type2)
        if type1 != BaseType.Integer and type1 != BaseType.Float:
            self._raise(ctx, "multiplicative operands", type1)
        if type1 == BaseType.Float and ctx.myop.type == MiniCParser.MOD:
            self._raise(ctx, "multiplicative operands", type1)
        return type1

    def visitNotExpr(self, ctx):
        my_type = self.visit(ctx.expr())
        if my_type != BaseType.Boolean:
            self._raise(ctx, "not operator", my_type)
        return BaseType.Boolean

    def visitUnaryMinusExpr(self, ctx):
        my_type = self.visit(ctx.expr())
        if my_type != BaseType.Integer and my_type != BaseType.Float:
            self._raise(ctx, "minus operator", my_type)
        return my_type

    # visit statements

    def visitPrintlnintStat(self, ctx):
        etype = self.visit(ctx.expr())
        if etype != BaseType.Integer:
            self._raise(ctx, 'println_int statement', etype)

    def visitPrintlnfloatStat(self, ctx):
        etype = self.visit(ctx.expr())
        if etype != BaseType.Float:
            self._raise(ctx, 'println_float statement', etype)

    def visitPrintlnboolStat(self, ctx):
        etype = self.visit(ctx.expr())
        if etype != BaseType.Boolean:
            self._raise(ctx, 'println_bool statement', etype)

    def visitPrintlnstringStat(self, ctx):
        etype = self.visit(ctx.expr())
        if etype != BaseType.String:
            self._raise(ctx, 'println_string statement', etype)

    def visitAssignStat(self, ctx):
        id_str = ctx.ID().getText()
        try:
            mytype = self._memorytypes[id_str]
        except KeyError:
            self._raiseNonType(ctx, f"Undefined variable {id_str}")
        assigntype = self.visit(ctx.expr())
        if mytype != assigntype:
            self._assertSameType(ctx, id_str, mytype, assigntype)

    def visitWhileStat(self, ctx):
        condition_type = self.visit(ctx.expr())
        if condition_type != BaseType.Boolean:
            self._raise(ctx, 'while condition', condition_type)
        self.visit(ctx.stat_block())

    def visitForStat(self, ctx):
        self.visit(ctx.assignment())
        bound_type = self.visit(ctx.expr(0))
        if bound_type not in {BaseType.Integer, BaseType.Float}:
            self._raise(ctx, 'for bound', bound_type)
        stride_type = self.visit(ctx.expr(1))
        if stride_type != BaseType.Integer:
            self._raise(ctx, 'for stride', stride_type)
        self.visit(ctx.stat_block())

    def visitIfStat(self, ctx):
        condition_type = self.visit(ctx.expr())
        if condition_type != BaseType.Boolean:
            self._raise(ctx, 'if condition', condition_type)
        self.visit(ctx.stat_block(0))
        if ctx.else_block is not None:
            self.visit(ctx.stat_block(1))

