/*
 * Clase Manejadora de Matriz en el Panel Visual
 */
package gnz.backend.Matriz;

import gnz.frontend.ManejadorDePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author jesfrin
 */
public class ManejadorMatriz implements Serializable {

    public final static int LONGITUD_PANEL = 620;
    public final static int ALTITUD_PANEL = 620;
    public static final int LONGITUD_REALCM = 200;

    //Constates para el tamano del Label(en pixeles)
    private static final Double REAJUSTE_ANCHO = 28 * 3.01799;
    private static final Double REAJUSTE_ALTO = 17 * 3.01799;

    public final static int ANCHO_OM = redondear(REAJUSTE_ANCHO);
    public final static int ALTO_OM = redondear(REAJUSTE_ALTO);

    private Celda[][] matriz;
    private int numeroDeCuadros;

    public ManejadorMatriz(int numeroDeCuadros) {
        this.numeroDeCuadros = numeroDeCuadros;
        llenarMatriz();
    }

    private void llenarMatriz() {
        int n = LONGITUD_PANEL / numeroDeCuadros;
        int limiteSuperiorY;
        int limiteSuperiorX;
        this.matriz = new Celda[numeroDeCuadros][numeroDeCuadros];
        for (int x = 0; x < numeroDeCuadros; x++) {
            limiteSuperiorX = n * (x + 1);
            for (int y = 0; y < numeroDeCuadros; y++) {
                limiteSuperiorY = n * (y + 1);
                // System.out.println("Guardando:"+limiteInferior+":"+limiteSuperior);
                this.matriz[x][y] = new Celda(limiteSuperiorX, limiteSuperiorY, false, false, new Point(x, y));
            }
        }
    }

    public void pintarCuadrosDeMatriz(Graphics g) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                Celda celda = matriz[i][j];
                if (celda.estaPintado() || celda.getVelocidadDeAuto() > ManejadorDePanel.VELOCIDAD_SIN_SUPERFICIE) {
                    celda.pintarCelda(celda.getColor(), g, numeroDeCuadros);
                    //System.out.println("Pintada:" + i + "," + j);
                } else {
                    celda.borrarCelda(ManejadorDePanel.COLOR_SIN_SUPERFICIE, g, numeroDeCuadros);
                }
            }
        }
    }

    private int averiguarEquivalenteEnMatriz(int numero) {
        int posEnMatriz;
        int relacion = LONGITUD_PANEL / numeroDeCuadros;
        posEnMatriz = (numero / relacion);
        if (posEnMatriz > (matriz.length - 1)) {
            return -1;
        }
        return posEnMatriz;
    }

    public Celda buscarEnMatriz(int x, int y) {
        int xM = averiguarEquivalenteEnMatriz(x);
        int yM = averiguarEquivalenteEnMatriz(y);
        //System.out.println("X:" + xM + " Y:" + yM);
        if (xM == -1 || yM == -1) {
            return null;
        }
        if (xM == this.matriz.length) {
            xM--;
        }
        if (yM == this.matriz.length) {
            yM--;
        }

        return this.matriz[xM][yM];
    }

    public void pintarPared(int x, int y, Graphics g, Color color) {
        Celda celda = buscarEnMatriz(x, y);
        if (color == ManejadorDePanel.COLOR_SIN_SUPERFICIE) {
            if (celda != null) {
                buscarEnMatriz(x, y).borrarCelda(ManejadorDePanel.COLOR_SIN_SUPERFICIE, g, numeroDeCuadros);
            }
        } else {
            if (celda != null) {
                buscarEnMatriz(x, y).pintarCelda(color, g, numeroDeCuadros);
            }
        }
    }

    public void ocuparDesocuparPosicion(int x, int y) {
        desocuparPosicionDeOM();
        //Se busca la posicion final
        int posFinalAuto_X = x + ANCHO_OM;
        int posFinalAuto_Y = y + ALTO_OM;
        int longitudDeCuadro = ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros;
        //Con la equivalencia se reduce el recorrido
        for (int i = x; i < posFinalAuto_X; i += longitudDeCuadro) {
            int eqx = averiguarEquivalenteEnMatriz(i);
            for (int j = y; j < posFinalAuto_Y; j += longitudDeCuadro) {
                int eqy = averiguarEquivalenteEnMatriz(j);
                //System.out.println("Punto equivalente:(" + eqx + "," + eqy + ")");
                if (eqx != -1 && eqy != -1) {
                    this.matriz[eqx][eqy].setEstaVisitado(true);
                }
            }
        }
        //System.out.println("Inicio:(" + x + "," + y + ") Fin:(" + posFinalAuto_X + "," + posFinalAuto_Y + ")");
    }

    private void desocuparPosicionDeOM() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j].setEstaVisitado(false);
            }
        }
    }

    public boolean verificarSiPosicionEsPared(int x, int y) {
        int posFinalAuto_X = x + ANCHO_OM;
        int posFinalAuto_Y = y + ALTO_OM;
        int longitudDeCuadro = ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros;
        //Con la equivalencia se reduce el recorrido
        for (int i = x; i < posFinalAuto_X; i += longitudDeCuadro) {
            int eqx = averiguarEquivalenteEnMatriz(i);
            for (int j = y; j < posFinalAuto_Y; j += longitudDeCuadro) {
                int eqy = averiguarEquivalenteEnMatriz(j);
                //System.out.println("Punto equivalente para ver si es pared:(" + eqx + "," + eqy + ")");
                if ((eqx > matriz.length - 1) || (eqy > matriz.length - 1)) {
                    return true;
                } else if (eqx == -1 || eqy == -1) {
                    return true;
                }
                if (this.matriz[eqx][eqy].estaPintado()) {
                    //System.out.println("DEVOLVEREMOS TRUE JAJAJAJAJAJAJAJAJA");
                    return true;
                }
            }
        }
        return false;
    }

    private static int redondear(Double n) {
        DecimalFormat df = new DecimalFormat("#");
        return Integer.valueOf(df.format(n));

    }

    public Celda[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Celda[][] matriz) {
        this.matriz = matriz;
    }

    public int getNumeroDeCuadros() {
        return numeroDeCuadros;
    }

    public void setNumeroDeCuadros(int numeroDeCuadros) {
        this.numeroDeCuadros = numeroDeCuadros;
    }

}
