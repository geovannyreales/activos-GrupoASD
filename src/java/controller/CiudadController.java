/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Ciudad;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adm
 */
public class CiudadController {

    public static Ciudad getCiudadByid(long activoid) throws SQLException {
        Ciudad c = null;
        String sql = "select * from ciudad where ciudadid = " + activoid;
        ResultSet rs = db.db.executeQuey(sql);
        if (rs.first()) {
            c = new Ciudad(rs.getInt(1), rs.getString(2));
        }
        return c;
    }
}
