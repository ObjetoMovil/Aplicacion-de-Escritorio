/*
 * Clase Celda, que es usada por la Matriz en el Panel Visual
 */
package gnz.backend.Matriz;

import gnz.frontend.ManejadorDePanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author jesfrin
 */
public class Celda implements Serializable {

    private int limiteSuperiorX, limiteSuperiorY;
    private boolean estaPintado;
    private boolean estaVisitado;
    private int velocidadDeAuto;
    private Point posicionEnMatriz;
    private Color color;

    public Celda(int limiteSuperiorX, int limiteSuperiorY, boolean estaPintado, boolean estaVisitado, Point posicionEnMatriz) {
        this.limiteSuperiorX = limiteSuperiorX;
        this.limiteSuperiorY = limiteSuperiorY;
        this.estaPintado = false;
        this.estaVisitado = estaVisitado;
        this.posicionEnMatriz = posicionEnMatriz;
        this.color=ManejadorDePanel.COLOR_SIN_SUPERFICIE;
        asignarVelocidad();
    }

    public void pintarCelda(Color color, Graphics g, int numeroDeCuadros) {
        if (estaVisitado) {
            //JOptionPane.showMessageDialog(null, "No puede pintar sobre el objeto movil");
        } else {
            /*Descomentar la siguiente linea si todos los colores menos blanco son pared**/
           // this.estaPintado = true;
            this.color = color;
            asignarVelocidad();
            g.setColor(color);
            //System.out.println("ESTA OCUPADO:"+estaVisitado);
            //System.out.println("LimiteSuperiorX:" + limiteSuperiorX);
            //System.out.println("LimiteSuperiorY:" + limiteSuperiorY);
            int comodinX = limiteSuperiorX - (ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros - 1);
            int comodinY = limiteSuperiorY - (ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros - 1);
            for (int x = comodinX; x <= limiteSuperiorX; x++) {
                for (int y = comodinY; y <= limiteSuperiorY; y++) {
                    g.drawLine(x, y, x, y);
                }
            }
        }

    }

    public void borrarCelda(Color color, Graphics g, int numeroDeCuadros) {
        try{
            this.estaPintado = false;
            g.setColor(color);
            this.color=color;
            asignarVelocidad();
            int comodinX = limiteSuperiorX - (ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros - 1);
            int comodinY = limiteSuperiorY - (ManejadorMatriz.LONGITUD_PANEL / numeroDeCuadros - 1);
            for (int x = comodinX; x <= limiteSuperiorX; x++) {
                for (int y = comodinY; y <= limiteSuperiorY; y++) {
                    g.drawLine(x, y, x, y);
                }
            }
        } catch(NullPointerException e){
            //Do nothing
        }
            
    }

    private void asignarVelocidad(){
        if(color==ManejadorDePanel.COLOR_LISO){
            velocidadDeAuto=ManejadorDePanel.VELOCIDAD_LISO;
        }else if(color==ManejadorDePanel.COLOR_PARED){
            velocidadDeAuto=ManejadorDePanel.VELOCIDAD_PARED;
            this.estaPintado=true;
        }else if(color==ManejadorDePanel.COLOR_RUGOSO){
            velocidadDeAuto=ManejadorDePanel.VELOCIDAD_RUGOSO;
        }else if(color==ManejadorDePanel.COLOR_SIN_SUPERFICIE){
            velocidadDeAuto=ManejadorDePanel.VELOCIDAD_SIN_SUPERFICIE;
        }
    }
    
    public int getLimiteInferior() {
        return limiteSuperiorX;
    }

    public void setLimiteInferior(int limiteInferior) {
        this.limiteSuperiorX = limiteInferior;
    }

    public int getLimiteSuperior() {
        return limiteSuperiorY;
    }

    public void setLimiteSuperior(int limiteSuperior) {
        this.limiteSuperiorY = limiteSuperior;
    }

    public boolean estaPintado() {
        return estaPintado;
    }

    public void setEstaPintado(boolean estaPintado) {
        this.estaPintado = estaPintado;
    }

    public boolean estaVisitado() {
        return estaVisitado;
    }

    public void setEstaVisitado(boolean estaVisitado) {
        this.estaVisitado = estaVisitado;
    }

    public Point getPosicionEnMatriz() {
        return posicionEnMatriz;
    }

    public void setPosicionEnMatriz(Point posicionEnMatriz) {
        this.posicionEnMatriz = posicionEnMatriz;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getVelocidadDeAuto() {
        return velocidadDeAuto;
    }

}
