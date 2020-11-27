package gnz.backend.sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jdant
 */
public class Cliente {
    
    private static Socket cliente;
    
    public static void enviarMensaje(String info){
        try {            
            DataOutputStream flujo = new DataOutputStream(cliente.getOutputStream());                                    
            flujo.write(info.getBytes());
            flujo.flush();            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
    }
    
    public static void crearConexion(){
        try{
            cliente=new Socket("127.0.0.1", 8080);            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void cerrarConexion(){
        try {
            cliente.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
