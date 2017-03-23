/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class db {

    private static void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
             Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
        }
    }

    private static Connection getConnection() throws SQLException {
        Connection cn = null;
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbactivos", "root", ""); // url, user, pass
        return cn;
    }

    public static void main(String[] args) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static ResultSet executeQuey(String sql) throws SQLException {
        cargarDriver();
        Connection cn = getConnection();
        java.sql.PreparedStatement ps = cn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public static boolean executeUpdate(String sql) throws SQLException {
        cargarDriver();
        Connection cn = getConnection();
        java.sql.PreparedStatement ps = cn.prepareStatement(sql);
        return ps.executeUpdate() > 0;
    }
}
