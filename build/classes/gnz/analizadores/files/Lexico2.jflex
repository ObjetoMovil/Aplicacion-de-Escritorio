/* codigo de usuario */
package com.mo.interprete.lexer;

import java.util.ArrayList;
import java_cup.runtime.Symbol;
import javax.swing.JTextArea;


%% //separador de area


 /* opciones y declaraciones de jflex */

%cupsym Sym2 
%class Lexico2
%cup
%public
%unicode
%line
%column
%char
%ignorecase

%state STRING
%state COMENTARIO_LINEA
%state COMENTARIO_BLOQUE


WhiteSpace = [\r|\n|\r\n] | [ \t\f]
SaltoLinea = [\n]
Numero = [0-9]

Numeros = {Numero}+

moverA = "moverA"
moverB = "moverB"
moverC = "moverC"
moverD = "moverD"

moverAdelante = "moverAdelante"
moverAtras = "moverAtras"
moverDerecha = "moverDerecha"
moverIzquierda = "moverIzquierda"
moverArribaDerecha = "moverArribaDerecha"
moverArribaIzquierda = "moverArribaIzquierda"
moverAbajoDerecha = "moverAbajoDerecha"
moverAbajoIzquierda = "moverAbajoIzquierda"
girarIzquierda = "girarIzquierda"
girarDerecha = "girarDerecha"



ini = "ini"
fin = "fin"

initrayecto = "initrayecto"
fintrayecto = "fintrayecto"

par_abierto = "("
par_cerrado = ")"
coma = ","








%{

	String lexema = "";
	String lexemaError = "";
	String lexemaMandar = "";

	

	public void crearLexemaError(String mandar){
		lexemaError = lexemaError+ mandar;
	}

	private void error(String message) {
	     System.out.println("\nError Lexico en Fila: " + (yyline + 1) + ", columna " + (yycolumn + 1) + " : " + message + "\n");
	}

	public void verificarError(){
		if(!lexemaError.equals("")){
			error(lexemaError);
		}
		lexemaError="";
	}
	private Symbol symbol(int type, String lexeme) {
		String lexema = lexeme;
		this.lexema="";
	        return new Symbol(type, lexema);
	}

	private Symbol symbol(int type) {
        String lexeme = yytext();

        return new Symbol(type, lexeme);
    }

%}



%% /* separador de areas*/

/* reglas lexicas */
<YYINITIAL> {
{WhiteSpace} {verificarError();}
{SaltoLinea} {verificarError();}

{moverA} {verificarError();return symbol(sym2.MOVERA);}
{moverB} {verificarError();return symbol(sym2.MOVERB);}
{moverC} {verificarError();return symbol(sym2.MOVERC);}
{moverD} {verificarError();return symbol(sym2.MOVERD);}


{moverAdelante} {verificarError();return symbol(sym2.MOVERADELANTE);}
{moverAtras} {verificarError();return symbol(sym2.MOVERATRAS);}
{moverDerecha} {verificarError();return symbol(sym2.MOVERDERECHA);}
{moverIzquierda} {verificarError();return symbol(sym2.MOVERIZQUIERDA);}
{moverArribaDerecha} {verificarError();return symbol(sym2.MOVERARRIBADERECHA);}
{moverArribaIzquierda} {verificarError();return symbol(sym2.MOVERARRIBAIZQUIERDA);}
{moverAbajoDerecha} {verificarError();return symbol(sym2.MOVERABAJODERECHA);}
{moverAbajoIzquierda} {verificarError();return symbol(sym2.MOVERABAJOIZQUIERDA);}
{girarIzquierda} {verificarError();return symbol(sym2.GIRARIZQUIERDA);}
{girarDerecha} {verificarError();return symbol(sym2.GIRARDERECHA);}




{ini} {verificarError();return symbol(sym2.INI);}
{fin} {verificarError();return symbol(sym2.FIN);}
{initrayecto} {verificarError();return symbol(sym2.INITRAYECTO);}
{fintrayecto} {verificarError();return symbol(sym2.FINTRAYECTO);}
{Numeros} {verificarError();return symbol(sym2.NUMEROS);}

{par_abierto} {verificarError();return symbol(sym2.PAR_ABIERTO);}
{par_cerrado} {verificarError();return symbol(sym2.PAR_CERRADO);}
{coma} {verificarError();return symbol(sym2.COMA);}
}

[^]                     {crearLexemaError(yytext());}
<<EOF>>                 {return symbol(sym2.EOF);}

/*



*/


