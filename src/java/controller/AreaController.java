/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Area;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adm
 */
public class AreaController {

    public static Area getAreaByid(long activoid) throws SQLException {
        Area a = null;
        String sql = "select * from area where areaid = " + activoid;
        ResultSet rs = db.db.executeQuey(sql);
        if (rs.first()) {
            a = new Area(rs.getInt(1), rs.getString(2), rs.getString(3), CiudadController.getCiudadByid(rs.getInt(4)));
        }
        return a;
    }
}
