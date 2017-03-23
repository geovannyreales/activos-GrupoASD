/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adm
 */
public class PersonaController {

    public static Persona getPersonaById(long activoid) throws SQLException {
        Persona p = null;
        String sql = "select * from persona where personaid = " + activoid;
        ResultSet rs = db.db.executeQuey(sql);
        if (rs.first()) {
            p = new Persona(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }
        return p;
    }
}
