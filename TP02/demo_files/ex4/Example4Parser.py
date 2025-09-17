# Generated from Example4.g4 by ANTLR 4.13.1
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

def serializedATN():
    return [
        4,1,6,21,2,0,7,0,2,1,7,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
        1,1,1,1,1,1,1,1,3,1,19,8,1,1,1,0,0,2,0,2,0,0,20,0,4,1,0,0,0,2,18,
        1,0,0,0,4,5,3,2,1,0,5,6,5,0,0,1,6,1,1,0,0,0,7,8,5,1,0,0,8,9,3,2,
        1,0,9,10,5,2,0,0,10,11,3,2,1,0,11,19,1,0,0,0,12,13,5,3,0,0,13,14,
        3,2,1,0,14,15,5,4,0,0,15,16,3,2,1,0,16,19,1,0,0,0,17,19,1,0,0,0,
        18,7,1,0,0,0,18,12,1,0,0,0,18,17,1,0,0,0,19,3,1,0,0,0,1,18
    ]

class Example4Parser ( Parser ):

    grammarFileName = "Example4.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [ "<INVALID>", "'['", "']'", "'('", "')'" ]

    symbolicNames = [ "<INVALID>", "<INVALID>", "<INVALID>", "<INVALID>", 
                      "<INVALID>", "CHAR", "WS" ]

    RULE_full_expr = 0
    RULE_expr = 1

    ruleNames =  [ "full_expr", "expr" ]

    EOF = Token.EOF
    T__0=1
    T__1=2
    T__2=3
    T__3=4
    CHAR=5
    WS=6

    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.1")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class Full_exprContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def expr(self):
            return self.getTypedRuleContext(Example4Parser.ExprContext,0)


        def EOF(self):
            return self.getToken(Example4Parser.EOF, 0)

        def getRuleIndex(self):
            return Example4Parser.RULE_full_expr

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterFull_expr" ):
                listener.enterFull_expr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitFull_expr" ):
                listener.exitFull_expr(self)




    def full_expr(self):

        localctx = Example4Parser.Full_exprContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_full_expr)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 4
            self.expr()
            self.state = 5
            self.match(Example4Parser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx


    class ExprContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def expr(self, i:int=None):
            if i is None:
                return self.getTypedRuleContexts(Example4Parser.ExprContext)
            else:
                return self.getTypedRuleContext(Example4Parser.ExprContext,i)


        def getRuleIndex(self):
            return Example4Parser.RULE_expr

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterExpr" ):
                listener.enterExpr(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitExpr" ):
                listener.exitExpr(self)




    def expr(self):

        localctx = Example4Parser.ExprContext(self, self._ctx, self.state)
        self.enterRule(localctx, 2, self.RULE_expr)
        try:
            self.state = 18
            self._errHandler.sync(self)
            token = self._input.LA(1)
            if token in [1]:
                self.enterOuterAlt(localctx, 1)
                self.state = 7
                self.match(Example4Parser.T__0)
                self.state = 8
                self.expr()
                self.state = 9
                self.match(Example4Parser.T__1)
                self.state = 10
                self.expr()
                pass
            elif token in [3]:
                self.enterOuterAlt(localctx, 2)
                self.state = 12
                self.match(Example4Parser.T__2)
                self.state = 13
                self.expr()
                self.state = 14
                self.match(Example4Parser.T__3)
                self.state = 15
                self.expr()
                pass
            elif token in [-1, 2, 4]:
                self.enterOuterAlt(localctx, 3)

                pass
            else:
                raise NoViableAltException(self)

        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





