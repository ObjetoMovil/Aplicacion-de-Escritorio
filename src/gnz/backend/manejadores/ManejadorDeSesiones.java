/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnz.backend.manejadores;

import gnz.backend.conexion.Conexion;
import gnz.frontend.FrameOM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jesfrin
 */
public class ManejadorDeSesiones {

    public static void guardarSesion(String user) throws SQLException {
        String consulta = "INSERT INTO SESION(Fecha,USUARIO_User) VALUES(?,?)";
        PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
        sentencia.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        sentencia.setString(2, user);
        sentencia.execute();
    }

    public static int consultarUltimaSesion() throws SQLException {
        String consulta = "SELECT COUNT(*) FROM SESION";
        PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public static List<Sesion> buscarSesiones() throws SQLException {
        List<Sesion> sesiones = new ArrayList<>();
        String consulta = "SELECT Id_Sesion,Fecha FROM SESION WHERE USUARIO_User=?";
        PreparedStatement sentencia = Conexion.getConexion().prepareStatement(consulta);
        sentencia.setString(1, FrameOM.getIdUsuario());
        ResultSet rs = sentencia.executeQuery();
        while (rs.next()) {
            sesiones.add(new Sesion(rs.getInt(1), rs.getTimestamp(2), FrameOM.getIdUsuario()));
        }
        return sesiones;
    }

}
