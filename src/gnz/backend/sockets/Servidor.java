package gnz.backend.sockets;

import gnz.frontend.FrameOM;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author jdant
 */
public class Servidor implements Runnable{
    
    private static Servidor conexion;    
    private static FrameOM ui;
    
    private Servidor(){
       
    }
    
    public static Servidor getConexion(FrameOM uie){        
        if(conexion == null){
            conexion = new Servidor();
        }
        ui = uie;
        return conexion;
    }
    
    /**
     *
     */
    @Override
    public void run(){
        try{
        ServerSocket server = new ServerSocket(9090);
        System.out.println("Esperando cliente");
        Socket cli = server.accept();

        String recibido = "", enviado = "";

        OutputStreamWriter outw = new OutputStreamWriter(cli.getOutputStream(), "UTF8");
        InputStreamReader inw = new InputStreamReader(cli.getInputStream(), "UTF8");

        char[] cbuf = new char[512];

        while (true) {
            System.out.println("Esperando mensaje del cliente en python");
            inw.read(cbuf);
            recibido = "";
            for (char c : cbuf) {
                recibido += c;
                if (c == 00) {
                    break;
                }
            }
            System.out.println("Cliente dice: " + recibido);
            System.out.println("Enviar a cliente: >>>" + recibido);
            recibido = "S:" + recibido;
            
            outw.write(recibido.toCharArray());
            outw.flush();

            cbuf = new char[512];

        }
        }catch(Exception e){
            
        }
    }
}
