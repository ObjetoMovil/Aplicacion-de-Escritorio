/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnz.backend.manejadores;

import gnz.backend.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeAcciones {
    
    public static List<String> consultarAcciones(int idSesion) throws SQLException{
        List<String> acciones = new ArrayList<>();
        String consulta="SELECT Descripcion FROM ACCION WHERE SESION_Id_Sesion=?";
        PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
        sentencia.setInt(1, idSesion);
        ResultSet rs=sentencia.executeQuery();
        while(rs.next()){
            acciones.add(rs.getString(1));
        }
        return acciones;
    }
    
}
