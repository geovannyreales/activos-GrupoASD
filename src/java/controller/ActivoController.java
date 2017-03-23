/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Activo;
import java.sql.SQLException;
import java.util.List;
import db.db;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author adm
 */
public class ActivoController {

    public static List<Activo> getActivoByTipo(String value) throws SQLException {
        ArrayList<Activo> a = new ArrayList<>();
        String sql = "SELECT * FROM activo WHERE activotipo = '" + value + "'";
        ResultSet rs = db.executeQuey(sql);
        while (rs.next()) {
            a.add(new Activo(rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(5),
                    rs.getDouble(7),
                    rs.getDouble(8),
                    rs.getDouble(9),
                    rs.getDouble(10),
                    rs.getDouble(11),
                    rs.getDate(12),
                    rs.getDate(13),
                    rs.getString(14),
                    controller.ColorController.getColorById(rs.getString(15)),
                    controller.ActivoasignadoController.getActivoasignadosByactivoid(rs.getLong(1))));

        }
        return a;
    }

    public static List<Activo> getActivoByFechaCompra(String value) throws SQLException {
        ArrayList<Activo> a = new ArrayList<>();
        String sql = "SELECT * FROM activo WHERE activofechacompra = '" + value + "'";
        ResultSet rs = db.executeQuey(sql);
        while (rs.next()) {
            a.add(new Activo(rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(5),
                    rs.getDouble(7),
                    rs.getDouble(8),
                    rs.getDouble(9),
                    rs.getDouble(10),
                    rs.getDouble(11),
                    rs.getDate(12),
                    rs.getDate(13),
                    rs.getString(14),
                    controller.ColorController.getColorById(rs.getString(15)),
                    controller.ActivoasignadoController.getActivoasignadosByactivoid(rs.getLong(1))));

        }
        return a;
    }

    public static Activo getActivoBySerial(String value) throws SQLException {
        Activo a = null;
        String sql = "SELECT * FROM activo WHERE activoserial = '" + value + "'";
        ResultSet rs = db.executeQuey(sql);
        if (rs.first()) {
            a = new Activo(rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(5),
                    rs.getDouble(7),
                    rs.getDouble(8),
                    rs.getDouble(9),
                    rs.getDouble(10),
                    rs.getDouble(11),
                    rs.getDate(12),
                    rs.getDate(13),
                    rs.getString(14),
                    controller.ColorController.getColorById(rs.getString(15)),
                    controller.ActivoasignadoController.getActivoasignadosByactivoid(rs.getLong(1)));
        }

        return a;
    }

    public static List<Activo> listActivos() throws SQLException {
        ArrayList<Activo> a = new ArrayList<>();
        String sql = "SELECT * FROM activo";
        ResultSet rs = db.executeQuey(sql);
        while (rs.next()) {
            a.add(new Activo(rs.getLong(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getLong(5),
                    rs.getDouble(7),
                    rs.getDouble(8),
                    rs.getDouble(9),
                    rs.getDouble(10),
                    rs.getDouble(11),
                    rs.getDate(12),
                    rs.getDate(13),
                    rs.getString(14),
                    controller.ColorController.getColorById(rs.getString(15)),
                    controller.ActivoasignadoController.getActivoasignadosByactivoid(rs.getLong(1))));

        }
        return a;
    }

    public static boolean createActivo(Activo a) throws SQLException {
        String sql = "INSERT INTO activo VALUES(0,"
                + "'" + a.getActivonombre() + "',"
                + "'" + a.getActivodescripcion() + "',"
                + "'" + a.getActivotipo() + "',"
                + "'" + a.getActivoserial() + "',"
                + "'" + a.getActivonumerointerno() + "',"
                + "'" + a.getActivopeso() + "',"
                + "'" + a.getActivoalto() + "',"
                + "'" + a.getActivoancho() + "',"
                + "'" + a.getActivolargo() + "',"
                + "'" + a.getActivovalorcompra() + "',"
                + "'" + (a.getActivofechacompra().getYear() + 1900) + "-" + (a.getActivofechacompra().getMonth() + 1) + "-" + a.getActivofechacompra().getDate() + "',"
                + "'" + (a.getActivofechabaja().getYear() + 1900) + "-" + (a.getActivofechabaja().getMonth() + 1) + "-" + a.getActivofechabaja().getDate() + "',"
                + "'" + a.getActivoestado() + "',"
                + "'" + a.getColorid().getColorid() + "')";

        return db.executeUpdate(sql);

    }

    public static boolean updateActivoSerial(long id, Activo a) throws SQLException {
        String sql = "UPDATE activo SET activoserial = '" + a.getActivoserial() + "' WHERE activoid = " + id;
        return db.executeUpdate(sql);
    }

    public static boolean updateActivoFechadebaja(long id, Activo a) throws SQLException {
        String sql = "UPDATE activo SET activofechabaja = '" + (a.getActivofechabaja().getYear() + 1900) + "-" + (a.getActivofechabaja().getMonth() + 1) + "-" + a.getActivofechabaja().getDate() + "' WHERE activofechacompra < '" + (a.getActivofechabaja().getYear() + 1900) + "-" + (a.getActivofechabaja().getMonth() + 1) + "-" + a.getActivofechabaja().getDate() + "' AND activoid = " + id;
        return db.executeUpdate(sql);
    }

}
