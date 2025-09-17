grammar ITE;

prog: st0=stmt EOF;

stmt :
    | '(' stmt ')'
	| ifStmt {}
	| id0=ID {print($id0.text)}
	;

ifStmt : 'if' id0=ID 'then' thenstmt=stmt ('else' elsestmt=stmt)? {print($id0.text)};


ID : [a-zA-Z]+;
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

