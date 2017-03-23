/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Activoasignado;
import entity.ActivoasignadoPK;
import entity.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adm
 */
public class ActivoasignadoController {
    
    public static Activoasignado getActivoasignadosByactivoid(long activoid) throws SQLException {
        Activoasignado aa = null;
        String sql = "select * from activoasignado where activoid = " + activoid;
        ResultSet rs = db.db.executeQuey(sql);
        if (rs.first()) {
            if (rs.getString(2).equals("persona")) {
                aa = new Activoasignado(new ActivoasignadoPK(rs.getLong(1), rs.getString(2), rs.getInt(3)), rs.getDate(4), PersonaController.getPersonaById(rs.getInt(3)));
            } else {
                aa = new Activoasignado(new ActivoasignadoPK(rs.getLong(1), rs.getString(2), rs.getInt(3)), rs.getDate(4), AreaController.getAreaByid(rs.getInt(3)));
            }
        }
        return aa;
    }
    
}
