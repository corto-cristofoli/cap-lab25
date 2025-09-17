# Generated from Example2.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .Example2Parser import Example2Parser
else:
    from Example2Parser import Example2Parser

# This class defines a complete listener for a parse tree produced by Example2Parser.
class Example2Listener(ParseTreeListener):

    # Enter a parse tree produced by Example2Parser#full_expr.
    def enterFull_expr(self, ctx:Example2Parser.Full_exprContext):
        pass

    # Exit a parse tree produced by Example2Parser#full_expr.
    def exitFull_expr(self, ctx:Example2Parser.Full_exprContext):
        pass


    # Enter a parse tree produced by Example2Parser#expr.
    def enterExpr(self, ctx:Example2Parser.ExprContext):
        pass

    # Exit a parse tree produced by Example2Parser#expr.
    def exitExpr(self, ctx:Example2Parser.ExprContext):
        pass



del Example2Parser