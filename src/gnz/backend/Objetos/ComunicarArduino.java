/*
 * Clase de Comunicacion Arduino utilizando la libreria PanamaHitek
 */
package gnz.backend.Objetos;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;

/**
 *
 * @author jpmazate
 */
public class ComunicarArduino {

    public static PanamaHitek_Arduino arduino;
    public static boolean conectado = false;

    public static PanamaHitek_Arduino getInstance() {

        if (arduino == null) {
            arduino = new PanamaHitek_Arduino();
            return arduino;
        } else {
            return arduino;
        }
    }

    public static void conectarArduino(String puerto) {
        try {
            if (!conectado) {
                arduino.arduinoTX(puerto, 9600);
                conectado = true;
            }
        } catch (ArduinoException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void reiniciarArduino(){
        arduino = new PanamaHitek_Arduino();
        conectado = false;
    }

    public static void mandarCadena(String cadena) {
        try {
            arduino.sendData(cadena);
        } catch (ArduinoException ex) {
            ex.printStackTrace();
        } catch (SerialPortException ex) {
            ex.printStackTrace();
        }
    }

    public PanamaHitek_Arduino getArduino() {
        return arduino;
    }

    
    public static boolean isConectado() {
        return conectado;
    }

    
}
