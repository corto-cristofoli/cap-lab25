# Generated from Example2.g4 by ANTLR 4.13.1
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
    from typing import TextIO
else:
    from typing.io import TextIO


def serializedATN():
    return [
        4,0,5,32,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,1,0,1,0,1,
        1,1,1,1,2,4,2,17,8,2,11,2,12,2,18,1,3,4,3,22,8,3,11,3,12,3,23,1,
        4,4,4,27,8,4,11,4,12,4,28,1,4,1,4,0,0,5,1,1,3,2,5,3,7,4,9,5,1,0,
        3,3,0,42,43,45,45,47,47,2,0,65,90,97,122,3,0,9,10,13,13,32,32,34,
        0,1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,1,0,0,0,0,9,1,0,0,0,1,11,
        1,0,0,0,3,13,1,0,0,0,5,16,1,0,0,0,7,21,1,0,0,0,9,26,1,0,0,0,11,12,
        5,59,0,0,12,2,1,0,0,0,13,14,7,0,0,0,14,4,1,0,0,0,15,17,2,48,57,0,
        16,15,1,0,0,0,17,18,1,0,0,0,18,16,1,0,0,0,18,19,1,0,0,0,19,6,1,0,
        0,0,20,22,7,1,0,0,21,20,1,0,0,0,22,23,1,0,0,0,23,21,1,0,0,0,23,24,
        1,0,0,0,24,8,1,0,0,0,25,27,7,2,0,0,26,25,1,0,0,0,27,28,1,0,0,0,28,
        26,1,0,0,0,28,29,1,0,0,0,29,30,1,0,0,0,30,31,6,4,0,0,31,10,1,0,0,
        0,4,0,18,23,28,1,6,0,0
    ]

class Example2Lexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    OP = 2
    INT = 3
    ID = 4
    WS = 5

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "';'" ]

    symbolicNames = [ "<INVALID>",
            "OP", "INT", "ID", "WS" ]

    ruleNames = [ "T__0", "OP", "INT", "ID", "WS" ]

    grammarFileName = "Example2.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.1")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


