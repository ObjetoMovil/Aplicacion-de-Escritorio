/*
 * Clase para una Estructura Multiple
 */
package gnz.backend.Objetos;

import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author jpmazate
 */
public class EstructuraMultiple implements Estructura{
    
    private List<EstructuraIndividual> lista;
    private JTextArea area;

    public EstructuraMultiple(List<EstructuraIndividual> lista) {
        this.lista = lista;
    }

    public List<EstructuraIndividual> getLista() {
        return lista;
    }

    public void setLista(List<EstructuraIndividual> lista) {
        this.lista = lista;
    }

    @Override
    public void mandarDatos() {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).asignarArea(area);
            lista.get(i).mandarDatos();   
        }
    }

    @Override
    public void asignarArea(JTextArea area) {
        this.area = area;
    }
    
    
    
}
