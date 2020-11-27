package com.mo.interprete.lexer;
import java_cup.runtime.Symbol; 
//import objetomovil4.*;
import gnz.backend.objetoMovil.Movimiento;
%% 

%{
    /*Area de declaración de codigo java. 
    *Funciones y variables necesarias
    */
    String nombre;
    public void imprimir(String cadena)
    {
    	System.out.println(cadena);
    }
%}

// Area de directivas
%cupsym Sym3 
%class Lexico3
%cup
%public
%unicode
%line
%column
%char
%ignorecase


// Area de definición de expresiones regulares. Tokens.
espacio = \t|\f|" "|\r|\n
numerico =["-"]?[0-9]+ | ["-"]?[0-9]+ "." [0-9]+
id=[A-Za-z]+["_"0-9A-Za-z]*

%%
// Acciones
","                 {return new Symbol(sym3.com,yyline,yycolumn,yytext());}
"("                 {return new Symbol(sym3.Para,yyline,yycolumn,yytext());}
")"                 {return new Symbol(sym3.Parc,yyline,yycolumn,yytext());}
"Ini"               {return new Symbol(sym3.RIni,yyline,yycolumn,yytext());}
"Fin"               {return new Symbol(sym3.RFin,yyline,yycolumn,yytext());}
"trayecto"          {return new Symbol(sym3.RTra,yyline,yycolumn,yytext());}
"MoverA"            {return new Symbol(sym3.RMovA,yyline,yycolumn,yytext());}
"MoverB"            {return new Symbol(sym3.RMovB,yyline,yycolumn,yytext());}
"MoverC"            {return new Symbol(sym3.RMovC,yyline,yycolumn,yytext());}
"MoverD"            {return new Symbol(sym3.RMovD,yyline,yycolumn,yytext());}
"adelante"          {return new Symbol(sym3.Radelante,yyline,yycolumn,yytext());}
"atras"             {return new Symbol(sym3.Ratras,yyline,yycolumn,yytext());}
"cm"                {return new Symbol(sym3.Rcm,yyline,yycolumn,yytext());}
{espacio}           {/*Ignorar*/}
{numerico}          {return new Symbol(sym3.numerico,yyline,yycolumn,yytext());}


//Recolección de errores
.       {   
        
        System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+" Columna:"+(yycolumn+1));
}