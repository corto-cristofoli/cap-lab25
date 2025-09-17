# Generated from Example4.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .Example4Parser import Example4Parser
else:
    from Example4Parser import Example4Parser

# This class defines a complete listener for a parse tree produced by Example4Parser.
class Example4Listener(ParseTreeListener):

    # Enter a parse tree produced by Example4Parser#full_expr.
    def enterFull_expr(self, ctx:Example4Parser.Full_exprContext):
        pass

    # Exit a parse tree produced by Example4Parser#full_expr.
    def exitFull_expr(self, ctx:Example4Parser.Full_exprContext):
        pass


    # Enter a parse tree produced by Example4Parser#expr.
    def enterExpr(self, ctx:Example4Parser.ExprContext):
        pass

    # Exit a parse tree produced by Example4Parser#expr.
    def exitExpr(self, ctx:Example4Parser.ExprContext):
        pass



del Example4Parser