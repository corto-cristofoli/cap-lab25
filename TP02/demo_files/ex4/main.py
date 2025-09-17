from antlr4 import InputStream
from antlr4 import CommonTokenStream

# include to use the generated lexer and parser
from Example4Lexer import Example4Lexer
from Example4Parser import Example4Parser

import sys


def main():
    input_stream = InputStream(sys.stdin.read())
    lexer = Example4Lexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = Example4Parser(stream)
    parser.full_expr()  # We want to recognize full_expr in grammar Example2
    print("Finished")


# warns pb if py file is included in others
if __name__ == '__main__':
    main()
