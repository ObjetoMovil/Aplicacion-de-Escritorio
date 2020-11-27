/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnz.backend.manejadores;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import gnz.backend.conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeUsuarios {
    
    //Registra un usuario en la base de datos
    public static void registrarUsuario(String usuario, String contrasena) throws SQLException {
        String consulta="INSERT INTO USUARIO VALUES(?,SHA(?))";
        PreparedStatement sentencia= Conexion.getConexion().prepareStatement(consulta);
        sentencia.setString(1, usuario);
        sentencia.setString(2, contrasena);
        sentencia.execute();
    }
    
    //Busca un usuario en la base de datos
        public static boolean buscarUsuario(String idUsuario,String contrasena) throws SQLException{
        String consulta="SELECT * FROM USUARIO WHERE User=? AND Password=SHA(?)";
        PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
        sentencia.setString(1, idUsuario);
        sentencia.setString(2, contrasena);
        ResultSet res = sentencia.executeQuery();
        while(res.next()){
            return true;
        }
        return false;
    }
    
}
