/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.noticias.negocio.managed;

import co.edu.intecap.noticias.persistencia.ejbs.CategoriaFacadeLocal;
import co.edu.intecap.noticias.persistencia.entidades.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.growl.Growl;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.panel.Panel;
import org.primefaces.context.RequestContext;

/**
 *
 * @author instructor
 */
@Named(value = "categoriaBean")
@ViewScoped
public class CategoriaBean implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaFacade;

    /**
     * Atributos de clase que representan los controles en jsf
     */
    private transient Panel pnlFormularioCategoria;
    private transient Panel pnlTablaCategoria;
    private transient CommandButton btnCargar;
    private transient DataTable tblCategoria;

    private transient InputText txtNombreCategoria;
    private transient InputText txtColorCategoria;
    private transient InputText txtIconoCategoria;
    private transient InputText txtColorFuenteCategoria;

    private transient CommandButton btnGuardar;
    private transient Growl glMensajes;

    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {

    }

    @PostConstruct
    public void initComponents() {
        pnlFormularioCategoria = new Panel();
        pnlTablaCategoria = new Panel();
        tblCategoria = new DataTable();
        btnCargar = new CommandButton();

        setTxtNombreCategoria(new InputText());
        //txtNombreCategoria = new InputText();
        txtColorCategoria = new InputText();
        txtIconoCategoria = new InputText();
        txtColorFuenteCategoria = new InputText();

        btnGuardar = new CommandButton();
        glMensajes = new Growl();
        asignarEventos();
    }

    private void asignarEventos() {
        btnCargar.addActionListener(new ActionListener() {
            @Override
            public void processAction(ActionEvent event) throws AbortProcessingException {
                cargarTabla();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void processAction(ActionEvent event) throws AbortProcessingException {
                Categoria gCategoria = new Categoria();
                gCategoria.setNombre(txtNombreCategoria.getValue().toString());
                gCategoria.setColor("#"+txtColorCategoria.getValue().toString());
                gCategoria.setIcono(txtIconoCategoria.getValue().toString());
                gCategoria.setColorFuente("#"+txtColorFuenteCategoria.getValue().toString());
                
                categoriaFacade.create(gCategoria);
                
                txtNombreCategoria.setValue("");
                txtColorCategoria.setValue("");
                txtIconoCategoria.setValue("");
                txtColorFuenteCategoria.setValue("");
                
                RequestContext.getCurrentInstance().update(pnlFormularioCategoria.getClientId());
                
                cargarTabla();
            }
        });
    }

    private void cargarTabla() {
        List<Categoria> listaCategorias = categoriaFacade.findAll();
        tblCategoria.setValue(listaCategorias);
        RequestContext.getCurrentInstance().update(tblCategoria.getClientId());
    }

    /**
     * @return the pnlFormularioCategoria
     */
    public Panel getPnlFormularioCategoria() {
        return pnlFormularioCategoria;
    }

    /**
     * @param pnlFormularioCategoria the pnlFormularioCategoria to set
     */
    public void setPnlFormularioCategoria(Panel pnlFormularioCategoria) {
        this.pnlFormularioCategoria = pnlFormularioCategoria;
    }

    /**
     * @return the pnlTablaCategoria
     */
    public Panel getPnlTablaCategoria() {
        return pnlTablaCategoria;
    }

    /**
     * @param pnlTablaCategoria the pnlTablaCategoria to set
     */
    public void setPnlTablaCategoria(Panel pnlTablaCategoria) {
        this.pnlTablaCategoria = pnlTablaCategoria;
    }

    /**
     * @return the btnCargar
     */
    public CommandButton getBtnCargar() {
        return btnCargar;
    }

    /**
     * @param btnCargar the btnCargar to set
     */
    public void setBtnCargar(CommandButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    /**
     * @return the tblCategoria
     */
    public DataTable getTblCategoria() {
        return tblCategoria;
    }

    /**
     * @param tblCategoria the tblCategoria to set
     */
    public void setTblCategoria(DataTable tblCategoria) {
        this.tblCategoria = tblCategoria;
    }

    /**
     * @return the txtNombreCategoria
     */
    public InputText getTxtNombreCategoria() {
        return txtNombreCategoria;
    }

    /**
     * @param txtNombreCategoria the txtNombreCategoria to set
     */
    public void setTxtNombreCategoria(InputText txtNombreCategoria) {
        this.txtNombreCategoria = txtNombreCategoria;
    }

    /**
     * @return the txtColorCategoria
     */
    public InputText getTxtColorCategoria() {
        return txtColorCategoria;
    }

    /**
     * @param txtColorCategoria the txtColorCategoria to set
     */
    public void setTxtColorCategoria(InputText txtColorCategoria) {
        this.txtColorCategoria = txtColorCategoria;
    }

    /**
     * @return the txtIconoCategoria
     */
    public InputText getTxtIconoCategoria() {
        return txtIconoCategoria;
    }

    /**
     * @param txtIconoCategoria the txtIconoCategoria to set
     */
    public void setTxtIconoCategoria(InputText txtIconoCategoria) {
        this.txtIconoCategoria = txtIconoCategoria;
    }

    /**
     * @return the txtColorFuenteCategoria
     */
    public InputText getTxtColorFuenteCategoria() {
        return txtColorFuenteCategoria;
    }

    /**
     * @param txtColorFuenteCategoria the txtColorFuenteCategoria to set
     */
    public void setTxtColorFuenteCategoria(InputText txtColorFuenteCategoria) {
        this.txtColorFuenteCategoria = txtColorFuenteCategoria;
    }

    /**
     * @return the btnGuardar
     */
    public CommandButton getBtnGuardar() {
        return btnGuardar;
    }

    /**
     * @param btnGuardar the btnGuardar to set
     */
    public void setBtnGuardar(CommandButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    /**
     * @return the glMensajes
     */
    public Growl getGlMensajes() {
        return glMensajes;
    }

    /**
     * @param glMensajes the glMensajes to set
     */
    public void setGlMensajes(Growl glMensajes) {
        this.glMensajes = glMensajes;
    }

}
