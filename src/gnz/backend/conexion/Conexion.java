/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnz.backend.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jesfrin
 */
public class Conexion {

    private static Connection conexion = null;

    private String driver;
    private String url;
    private String user;
    private String password;

    private Conexion() {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/LOG_OM";

        user = "root";
        password = "bryan1234";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConexion() {
        if (conexion == null) {
            new Conexion();
        }
        return conexion;
    }
    
    public static void cerrarConexion(){
        if(conexion!=null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
