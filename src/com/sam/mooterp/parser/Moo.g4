grammar Moo;

program
    : instruction* ;

instruction
    :   forwardInstruction
    |   backwardInstruction
    ;

forwardInstruction
    :   'moO'
    ;

backwardInstruction
    :   'mOo'
    ;

WS : [ \t\n\r]+ -> channel(HIDDEN) ;

