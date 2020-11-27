#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar JFlex/jflex-full-1.8.1.jar Lexico.jflex
java -jar JFlex/jflex-full-1.8.1.jar Lexico2.jflex
java -jar JFlex/jflex-full-1.8.1.jar Lexico3.jflex

echo "STARTING CUP COMPILING"
java -jar Cup/java-cup-11b.jar -parser Parser1 -symbols Sym1 Sintactico.cup
java -jar Cup/java-cup-11b.jar -parser Parser2 -symbols Sym2 Sintactico2.cup
java -jar Cup/java-cup-11b.jar -parser parser3 -symbols Sym3 Sintactico3.cup
