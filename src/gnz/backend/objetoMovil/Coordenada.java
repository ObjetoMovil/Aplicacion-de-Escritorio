/*
 * Clase para Manejar una coordenada
 */
package gnz.backend.objetoMovil;

import gnz.backend.Matriz.Run;

/**
 *
 * @author Jonathan
 */
public class Coordenada {
    int x;
    int y;
    
    
    public Coordenada(int x, int y){
        this.x=x*Run.MULT;
        this.y=y*Run.MULT;
    }
    
}
