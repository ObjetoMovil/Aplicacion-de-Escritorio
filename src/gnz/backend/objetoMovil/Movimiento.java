/*
 * Clase para atribuir los movimientos base al OM
 */
package gnz.backend.objetoMovil;

import gnz.backend.Matriz.Run;

/**
 *
 * @author Jonathan
 */
public class Movimiento {
    //Tipo adelante=0, atras=1, arriba=2, abajo=3, diagonal=4
    public int tipo;
    
    //Distancia en centimetros
    public int distancia;
    
    //Angulo de 0 a 360;
    public int angulo;
    
    //Velocidad 1, 2, 3
    public int velocidad;
            
    
    public Movimiento(){
        
    }
    
    //INSTANCIAR MOVIMIENTO
    public Movimiento(String tipo1, String distancia1, String velocidad1, String angulo1){
        int tipo = Integer.parseInt(tipo1); 
        int distancia = Integer.parseInt(distancia1); 
        int velocidad = Integer.parseInt(velocidad1);
        int angulo = Integer.parseInt(angulo1);
        this.velocidad=velocidad;
        this.distancia=distancia;
        this.tipo=tipo;
        
        switch (tipo) {
            case 0:
                this.angulo=0;
                break;
            case 1:
                this.angulo=180;
                break;
            case 2:
                this.angulo=90;
                break;
            case 3:
                this.angulo=270;
                break;
            default:
                if(angulo<0){
                    this.angulo=360+angulo;
                }else{
                    this.angulo=angulo;
                }
                break;
        }
        
    }
    
    //instanciar un movimiento Curvo
    public Movimiento(String tipo, String angulo, String velocidad) {
        this.tipo = Integer.parseInt(tipo);
        this.angulo = Integer.parseInt(angulo)*Run.MULT;
        this.velocidad = Integer.parseInt(velocidad);
    }
    
    public String CadenaBase(){
        //LLANTAS HACIA ADELANTE
        //EJEMPLO DE CADENA DE SALIDA <(a)(100)(3)(1)><(b)(100)(3)(1)><(c)(100)(3)(1)><(c)(100)(3)(1)>
        //MOTOR (a,b,c,d), (Distancia), (velocidad: 1-10), (sentido 0=sin mover, 1=adelante, 2=atras)
        String cadena="";
        if((angulo>=0&&angulo<91)||(angulo>270&&angulo<360)){
            cadena="<(a)("+distancia+")("+(velocidad*3)+")(1)><(b)("+distancia+")("+(velocidad*3)+")(1)><(c)("+distancia+")("+(velocidad*3)+")(1)><(c)("+distancia+")("+(velocidad*3)+")(1)>";
        }
        //LLANTAS HACIA ATRAS
        else{
            cadena="<(a)("+distancia+")("+(velocidad*3)+")(2)><(b)("+distancia+")("+(velocidad*3)+")(2)><(c)("+distancia+")("+(velocidad*3)+")(2)><(c)("+distancia+")("+(velocidad*3)+")(2)>";
        }
            
        return cadena;
    }
    
    public String CadenaGiro(){
        //SI ES ADELANTE O ATRAS NO HAY ANGULO DE GIRO
        String cadena="";
        if(angulo!=180&&angulo!=0){
            
            
        }
        return cadena;
        
    }
    
    
}