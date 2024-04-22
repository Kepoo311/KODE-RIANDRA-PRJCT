/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kode_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author riand
 */
public class koneksi {
    private static Connection mysqlkonek;
    
    public static Connection koneksiDB() throws SQLException {
        if(mysqlkonek == null){
            try{
                String db = "jdbc:mysql://localhost:3306/quiz";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                mysqlkonek =(Connection)DriverManager.getConnection(db, user, password);
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return mysqlkonek;
    }
}
