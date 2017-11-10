/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.noticias.negocio.rest;

import co.edu.intecap.noticias.persistencia.ejbs.CategoriaFacadeLocal;
import co.edu.intecap.noticias.persistencia.entidades.Categoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author instructor
 */
@Path("categoria")
public class CategoriaRest {

    CategoriaFacadeLocal categoriaFacade = lookupCategoriaFacadeLocal();

    @Context
    private UriInfo context;
    
    

    /**
     * Creates a new instance of CategoriaRest
     */
    public CategoriaRest() {
    }

    /**
     * Retrieves representation of an instance of co.edu.intecap.noticias.negocio.rest.CategoriaRest
     * @return an instance of co.edu.intecap.noticias.persistencia.entidades.Categoria
     */
    @GET
    @Path("consultar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> getJson() {
        //TODO return proper representation object
        return categoriaFacade.findAll();
    }

    /**
     * PUT method for updating or creating an instance of CategoriaRest
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(Categoria content) {
    }

    private CategoriaFacadeLocal lookupCategoriaFacadeLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (CategoriaFacadeLocal) c.lookup("java:global/noticias/noticias-ejb/CategoriaFacade!co.edu.intecap.noticias.persistencia.ejbs.CategoriaFacadeLocal");
        } catch (NamingException ne) {
            ne.printStackTrace();
            throw new RuntimeException(ne);
        }
    }
}
