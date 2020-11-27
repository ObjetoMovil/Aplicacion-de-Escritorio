/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnz.backend.Objetos;

import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author jpmazate
 */
public class EstructuraPrimaria implements Estructura{
    
    private List<MoverPrimario> lista;
    private JTextArea area;

    public EstructuraPrimaria(List<MoverPrimario> lista) {
        this.lista = lista;
    }

    public List<MoverPrimario> getLista() {
        return lista;
    }

    public void setLista(List<MoverPrimario> lista) {
        this.lista = lista;
    }

    @Override
    public void mandarDatos() {
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).asignarArea(area);
            lista.get(i).mandarCadena();
        }
    }

    @Override
    public void asignarArea(JTextArea area) {
        this.area = area;
    }
    
    
    
}
