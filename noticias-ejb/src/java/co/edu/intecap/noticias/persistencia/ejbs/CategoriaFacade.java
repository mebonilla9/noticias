/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.noticias.persistencia.ejbs;

import co.edu.intecap.noticias.persistencia.entidades.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author instructor
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> implements CategoriaFacadeLocal {

    @PersistenceContext(unitName = "noticias-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    public List<Categoria> consultarTodos(){
        return em.createNamedQuery("Categoria.findAll").getResultList();
    }
    
    public Categoria consultarPorId(Long id){
        return (Categoria) em.createNamedQuery("Categoria.findByIdCategoria")
                .setParameter("idCategoria", id)
                .getSingleResult();
    }
    
}
