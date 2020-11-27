package gnz.analizadores;

import java_cup.runtime.Symbol; 

%% 

%cupsym CommunicationSym 
%class CommunicationLexer
%cup
%public
%unicode
%line
%column
%char
%ignorecase

espacio = \t|\f|" "|\r|\n
numerico =["-"]?[0-9]+ | ["-"]?[0-9]+ "." [0-9]+

%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn, value);
    }

%}

%%

<YYINITIAL>{
    ","                 { return symbol(CommunicationSym.COMMA, yytext()); }
    "("                 { return symbol(CommunicationSym.PARENTHESISO, yytext()); } 
    ")"                 { return symbol(CommunicationSym.PARENTHESISC, yytext()); }
    "MoverA"            { return symbol(CommunicationSym.MOVEA, yytext()); }
    "MoverB"            { return symbol(CommunicationSym.MOVEB, yytext()); }
    "MoverC"            { return symbol(CommunicationSym.MOVEC, yytext()); }
    "MoverD"            { return symbol(CommunicationSym.MOVED, yytext()); }
    "MovRecto"          { return symbol(CommunicationSym.MOVESTRAIGHT, yytext()); }
    "MovDiagonal"       { return symbol(CommunicationSym.MOVEDIAGONAL, yytext()); }
    "MovCurvo"          { return symbol(CommunicationSym.MOVECURVED, yytext()); }
    "adelante"          { return symbol(CommunicationSym.AHEAD, yytext()); }
    "atras"             { return symbol(CommunicationSym.BEHIND, yytext()); }
    "arriba"            { return symbol(CommunicationSym.UP, yytext());}
    "abajo"             { return symbol(CommunicationSym.DOWN, yytext());}
    "grados"            { return symbol(CommunicationSym.DEGREES, yytext());}
    "seg"                { return symbol(CommunicationSym.SEG, yytext()); }
    {espacio}           { /*Ignorar*/}
    {numerico}          { return symbol(CommunicationSym.INTEGER, Integer.parseInt(yytext())); }
    .                   { System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+" Columna:"+(yycolumn+1)); }




}
