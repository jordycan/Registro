/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import sys.dao.daoPromotores;
import sys.imp.impPromotores;
import sys.model.Municipios;
import sys.model.Promotores;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value = "beanPromotores")
@ViewScoped
public class beanPromotores implements Serializable {

    /**
     * Creates a new instance of beanPromotores
     */
    private Promotores promotores;
    private Municipios municipios;
    private List<SelectItem> listarMunicipios;
    private List<Promotores> listaPromotores;
    
    
    public beanPromotores() {
        promotores = new Promotores();
        municipios = new Municipios();
    }

    public Promotores getPromotores() {
        return promotores;
    }

    public void setPromotores(Promotores promotores) {
        this.promotores = promotores;
    }

    public void prepararNuevoPromotor(ActionEvent actionEvent) {
        promotores = new Promotores();
    }

    public Municipios getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipios municipios) {
        this.municipios = municipios;
    }

    public List<Promotores> getListaPromotores() {
        return listaPromotores;
    }

    public void setListaPromotores(List<Promotores> listaPromotores) {
        this.listaPromotores = listaPromotores;
    }

  
    
    

    public List<SelectItem> getListarMunicipios() {
          this.listarMunicipios = new ArrayList<SelectItem>();
        daoPromotores mdao = new impPromotores();
        List<Municipios> m = mdao.verMunicipios();
        listarMunicipios.clear();
        for (Municipios g : m) {
            SelectItem gradoItem = new SelectItem(g.getIdLocalidad(), g.getMunicipio());
            this.listarMunicipios.add(gradoItem);
        }
        return listarMunicipios;
    }

    public void setListarMunicipios(List<SelectItem> listarMunicipios) {
        this.listarMunicipios = listarMunicipios;
    }
    
    public void verPromotoresNombre(){
        daoPromotores pdao = new impPromotores();
        listaPromotores = pdao.verPromotoresPorNomre(promotores);
    }

    public void insertarPromotor() {
        daoPromotores pdao = new impPromotores();
        boolean inserto = pdao.insertarPromotores(promotores);
        if (inserto) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a ingresado satisfactoriamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede insertar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
    }
    
     public void editarPromotor() {
        daoPromotores pdao = new impPromotores();
        boolean inserto = pdao.editarPromotor(promotores);
        if (inserto) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a editado satisfactoriamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede editar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
    }
     
      public void eliminarPromotor() {
        daoPromotores pdao = new impPromotores();
        boolean inserto = pdao.eliminarPromotor(promotores);
        if (inserto) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a eliminado satisfactoriamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede eliminar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
    }

}
