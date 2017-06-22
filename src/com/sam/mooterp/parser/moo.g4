grammar moo;

code: instruction* ;

instruction :   forward
        ;

forward
    :   'moO'
    ;

backward
    :   'mOo'
    ;

WS : [ \t\n\r]+ -> channel(HIDDEN) ;

