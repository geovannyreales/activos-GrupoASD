/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Color;
import java.sql.ResultSet;
import db.db;
import java.sql.SQLException;

/**
 *
 * @author adm
 */
public class ColorController {
    
    public static Color getColorById(String id) throws SQLException {
        String sql = "select * from color where colorid = " + id;
        ResultSet rs = db.executeQuey(sql);
        rs.first();
        return new Color(rs.getInt(1), rs.getString(2));
        
    }
}
