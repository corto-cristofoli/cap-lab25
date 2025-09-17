grammar Arit;

// MIF08@Lyon1 and CAP@ENSL, arit evaluator

@header {
# header - mettre les déclarations globales
import sys
idTab = {};

class UnknownIdentifier(Exception):
    pass

class DivByZero(Exception):
    pass

}

prog: expr=add {print("res = "+str($expr.res));} ;

add returns [int res]:
      v0=add '+' v1=times {$res = $v0.res + $v1.res}
    | v0=times {$res = $v0.res}
    ;

times returns [int res]:
      v0=val {$res = $v0.res}
    | v0=times '*' v1=val {$res = $v0.res * $v1.res}
    ;

val returns [int res]:
      ID {$res = 0}
    | v0=INT {$res = int($v0.text)}
    | '(' v0=add ')' {$res = $v0.res}
    ;

COMMENT
 : '//' ~[\r\n]* -> skip
 ;


ID : ('a'..'z'|'A'..'Z')+;
INT: '0'..'9'+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
