/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.noticias.negocio.soap;

import co.edu.intecap.noticias.persistencia.ejbs.CategoriaFacadeLocal;
import co.edu.intecap.noticias.persistencia.entidades.Categoria;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author instructor
 */
@WebService(serviceName = "ServicioCategoriaSoap")
@Stateless()
public class ServicioCategoriaSoap {

    @EJB
    private CategoriaFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "categoria") Categoria categoria) {
        ejbRef.create(categoria);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "categoria") Categoria categoria) {
        ejbRef.edit(categoria);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "categoria") Categoria categoria) {
        ejbRef.remove(categoria);
    }

    @WebMethod(operationName = "find")
    public Categoria find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Categoria> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Categoria> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
