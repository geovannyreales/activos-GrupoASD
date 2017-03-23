/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.ActivoController;
import db.db;
import entity.Activo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adm
 */
@Stateless
@Path("activo")
public class ActivoFacadeREST {

    @GET
    @Path("tipo/{value}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findByTipo(@PathParam("value") String value) {
        try {
            if (ActivoController.getActivoByTipo(value).size() != 0) {
                GenericEntity<List<Activo>> entityList = new GenericEntity<List<Activo>>(
                        ActivoController.getActivoByTipo(value)) {
                };
                return Response.ok(entityList).build();
            } else {
                return Response.status(404).entity("no se encontraron datos con el parametro " + value).build();
            }

        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("fechacompra/{value}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findByFechaCompra(@PathParam("value") String value) {
        try {
            if (ActivoController.getActivoByFechaCompra(value).size() != 0) {
                GenericEntity<List<Activo>> entityList = new GenericEntity<List<Activo>>(
                        ActivoController.getActivoByFechaCompra(value)) {
                };
                return Response.ok(entityList).build();
            } else {
                return Response.status(404).entity("no se encontraron datos con el parametro " + value).build();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

    @GET
    @Path("serial/{value}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response findBySerial(@PathParam("value") String value) {
        try {
            Activo a = ActivoController.getActivoBySerial(value);
            if (a != null) {
                return Response.ok().entity(a).build();
            } else {
                return Response.status(404).entity("no se encontraron datos con el parametro " + value).build();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }

    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public Response listActivos() {
        try {
            if (ActivoController.listActivos().size() != 0) {
                GenericEntity<List<Activo>> entityList = new GenericEntity<List<Activo>>(
                        ActivoController.listActivos()) {
                };
                return Response.ok(entityList).build();
            } else {
                return Response.status(404).entity("no se encontraron datos registrado").build();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Activo entity) {
        try {
            if (ActivoController.createActivo(entity)) {
                return Response.ok().entity("Activo creado").build();
            } else {
                return Response.status(400).entity("Activo no creado").build();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("updateSerial/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateSerial(@PathParam("id") Long id, Activo entity) {
        try {
            if (ActivoController.updateActivoSerial(id, entity)) {
                return Response.ok().entity("Serial actulizado").build();
            } else {
                return Response.status(400).entity("Datos no Actualizados").build();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("updateFechadebaja/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateFechadebaja(@PathParam("id") Long id, Activo entity) {
        try {
            if (ActivoController.updateActivoFechadebaja(id, entity)) {
                return Response.ok().entity("Fecha de baja actulizada").build();
            } else {
                return Response.status(400).entity("Datos no Actualizados").build();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getClass().getName()).log(Level.SEVERE, null, e);
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

}
