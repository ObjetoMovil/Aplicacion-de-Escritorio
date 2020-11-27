/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnz.backend.Objetos;

import javax.swing.JTextArea;

/**
 *
 * @author jpmazate
 */
public class MoverMotor {
    
    private String motor;
    private int distancia;
    private int velocidadMotor;
    private JTextArea area;

    public MoverMotor(String motor, int distancia, int velocidadMotor) {
        this.motor = motor;
        this.distancia = distancia;
        this.velocidadMotor = velocidadMotor;
    }
    
    
    

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getVelocidadMotor() {
        return velocidadMotor;
    }

    public void setVelocidadMotor(int velocidadMotor) {
        this.velocidadMotor = velocidadMotor;
    }
    
    
    public void asignarArea(JTextArea area){
        this.area = area;
    }
    
    
}
