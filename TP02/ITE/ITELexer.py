# Generated from ITE.g4 by ANTLR 4.13.1
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
    from typing import TextIO
else:
    from typing.io import TextIO


def serializedATN():
    return [
        4,0,7,44,6,-1,2,0,7,0,2,1,7,1,2,2,7,2,2,3,7,3,2,4,7,4,2,5,7,5,2,
        6,7,6,1,0,1,0,1,1,1,1,1,2,1,2,1,2,1,3,1,3,1,3,1,3,1,3,1,4,1,4,1,
        4,1,4,1,4,1,5,4,5,34,8,5,11,5,12,5,35,1,6,4,6,39,8,6,11,6,12,6,40,
        1,6,1,6,0,0,7,1,1,3,2,5,3,7,4,9,5,11,6,13,7,1,0,2,2,0,65,90,97,122,
        3,0,9,10,13,13,32,32,45,0,1,1,0,0,0,0,3,1,0,0,0,0,5,1,0,0,0,0,7,
        1,0,0,0,0,9,1,0,0,0,0,11,1,0,0,0,0,13,1,0,0,0,1,15,1,0,0,0,3,17,
        1,0,0,0,5,19,1,0,0,0,7,22,1,0,0,0,9,27,1,0,0,0,11,33,1,0,0,0,13,
        38,1,0,0,0,15,16,5,40,0,0,16,2,1,0,0,0,17,18,5,41,0,0,18,4,1,0,0,
        0,19,20,5,105,0,0,20,21,5,102,0,0,21,6,1,0,0,0,22,23,5,116,0,0,23,
        24,5,104,0,0,24,25,5,101,0,0,25,26,5,110,0,0,26,8,1,0,0,0,27,28,
        5,101,0,0,28,29,5,108,0,0,29,30,5,115,0,0,30,31,5,101,0,0,31,10,
        1,0,0,0,32,34,7,0,0,0,33,32,1,0,0,0,34,35,1,0,0,0,35,33,1,0,0,0,
        35,36,1,0,0,0,36,12,1,0,0,0,37,39,7,1,0,0,38,37,1,0,0,0,39,40,1,
        0,0,0,40,38,1,0,0,0,40,41,1,0,0,0,41,42,1,0,0,0,42,43,6,6,0,0,43,
        14,1,0,0,0,3,0,35,40,1,6,0,0
    ]

class ITELexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    T__0 = 1
    T__1 = 2
    T__2 = 3
    T__3 = 4
    T__4 = 5
    ID = 6
    WS = 7

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ "DEFAULT_MODE" ]

    literalNames = [ "<INVALID>",
            "'('", "')'", "'if'", "'then'", "'else'" ]

    symbolicNames = [ "<INVALID>",
            "ID", "WS" ]

    ruleNames = [ "T__0", "T__1", "T__2", "T__3", "T__4", "ID", "WS" ]

    grammarFileName = "ITE.g4"

    def __init__(self, input=None, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.1")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None


