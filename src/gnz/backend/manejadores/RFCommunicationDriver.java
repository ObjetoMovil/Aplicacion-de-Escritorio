package gnz.backend.manejadores;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
/**
 *
 * @author helmuth
 */
public class RFCommunicationDriver {
    
    private PanamaHitek_Arduino transceiverA = new PanamaHitek_Arduino();
    
    /**
     * Metodo que agrega al combo box recibido como parametro todos los arduinos 
     * disponibles para conexion.
     * @param availableConnectiosComboBox JComboBox donde se agregaran las conexiones.
     */
    public void fillAvailableConnections(JComboBox availableConnectiosComboBox){
        availableConnectiosComboBox.removeAllItems();
        for(String connection : transceiverA.getSerialPorts()){
            availableConnectiosComboBox.addItem(connection);
        }
    }
    
    /**
     * Metodo encargado de establecer la conexion entre la aplicacion java y el tranceptorA.
     * @param availableConnectionsComboBox JComboBox con las conexiones disponibles.
     * @param statusPanel Panel que indica el estado de la conexion.
     * @param statusLabel Etiqueta que indica el estado de la conexion.
     * @param messagesArea Area de texto donde se imprimiran mensajes.
     */
    public void connect(JComboBox availableConnectionsComboBox, JPanel statusPanel, JLabel statusLabel, JTextArea messagesArea) throws ArduinoException{
        transceiverA.arduinoRXTX(transceiverA.getSerialPorts().get(availableConnectionsComboBox.getSelectedIndex()), 9600, getEventListener(messagesArea));
        statusPanel.setBackground(Color.GREEN);
        statusLabel.setText("Estado: Conectado a " + transceiverA.getSerialPorts().get(availableConnectionsComboBox.getSelectedIndex()));
    }
    
    /**
     * Metodo que crea un listener para obtener e imprimir en el JTextArea que se
     * recibe como parametro los mensajes recibidos por el tranceptorA 
     * @param messagesArea Area de texto donde se mostraran los mensajes.
     * @return EventListener creado
     */
    private SerialPortEventListener getEventListener(JTextArea messagesArea){
        SerialPortEventListener serialPortListener = (SerialPortEvent spe) -> {
            try {
                if(transceiverA.isMessageAvailable()){
                    messagesArea.setText(messagesArea.getText() + "Recibido: " + transceiverA.printMessage() + "\n");
                }
            } catch (SerialPortException ex) {
                System.out.println(ex.getMessage());
            } catch (ArduinoException ex) {
                System.out.println(ex.getMessage());
            }
        };
        return serialPortListener;
    }
    
    /**
     * Metodo encargado de destruir la conexion vigente que existe entre la app y el tranceptorA.
     * @param availableConnectionsComboBox
     * @param statusPanel
     * @param statusLabel
     * @throws ArduinoException 
     */
    public void disconnect(JComboBox availableConnectionsComboBox, JPanel statusPanel, JLabel statusLabel) throws ArduinoException{
        transceiverA.killArduinoConnection();
        statusPanel.setBackground(Color.red);
        statusLabel.setText("Estado: No Conectado");
        fillAvailableConnections(availableConnectionsComboBox);
    }
    
    /**
     * Metodo encargado de enviar datos al tranceptor A.
     * @param data Datos a enviar al tranceptorA.
     */
    public void sendData(String data){
        try {
            transceiverA.sendData(data);
        } catch (ArduinoException | SerialPortException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PanamaHitek_Arduino getTransceiverA() {
        return transceiverA;
    }

}
