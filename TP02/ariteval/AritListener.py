# Generated from Arit.g4 by ANTLR 4.13.1
from antlr4 import *
if "." in __name__:
    from .AritParser import AritParser
else:
    from AritParser import AritParser

# header - mettre les d??clarations globales
import sys
idTab = {};

class UnknownIdentifier(Exception):
    pass

class DivByZero(Exception):
    pass



# This class defines a complete listener for a parse tree produced by AritParser.
class AritListener(ParseTreeListener):

    # Enter a parse tree produced by AritParser#prog.
    def enterProg(self, ctx:AritParser.ProgContext):
        pass

    # Exit a parse tree produced by AritParser#prog.
    def exitProg(self, ctx:AritParser.ProgContext):
        pass



del AritParser