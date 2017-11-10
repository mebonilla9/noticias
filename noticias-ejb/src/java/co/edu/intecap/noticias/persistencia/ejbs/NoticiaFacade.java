/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.noticias.persistencia.ejbs;

import co.edu.intecap.noticias.persistencia.entidades.Noticia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author instructor
 */
@Stateless
public class NoticiaFacade extends AbstractFacade<Noticia> implements NoticiaFacadeLocal {

    @PersistenceContext(unitName = "noticias-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticiaFacade() {
        super(Noticia.class);
    }
    
}
