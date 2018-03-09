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
import sys.dao.daoMunicipios;
import sys.imp.impMunicipios;
import sys.model.Municipios;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value = "beanMunicipios")
@ViewScoped

public class beanMunicipios implements Serializable{

    /**
     * Creates a new instance of beanMunicipios
     */
    
    private Municipios municipios;
    private List<Municipios> verMunicipios;
     private List<SelectItem> listarMunicipios;

    public Municipios getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipios municipios) {
        this.municipios = municipios;
    }

    public List<Municipios> getVerMunicipios() {
        daoMunicipios mdao = new impMunicipios();
        verMunicipios = mdao.mostrarMunicipios();
        return verMunicipios;
    }

    public void setVerMunicipios(List<Municipios> verMunicipios) {
        this.verMunicipios = verMunicipios;
    }
    
    
    
    public beanMunicipios() {
        municipios = new Municipios();
    }
    
    public void prepararNuevoMunicipio(ActionEvent actionEvent) {
        municipios = new Municipios();
    }
    
    public void insertarMunicipio(){
          daoMunicipios mdao = new impMunicipios();
        boolean inserto=mdao.registroMunicipios(municipios);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a ingresado satisfactoriamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede insertar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
    }
    
     public void actualiazrMunicipios(){
          daoMunicipios mdao = new impMunicipios();
        boolean inserto=mdao.actualizarMunicipios(municipios);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a actualizado satisfactoriamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede actualizar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
    }
     
     public void eliminarMunicipios(){
          daoMunicipios mdao = new impMunicipios();
        boolean inserto=mdao.eliminarMunicipios(municipios);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a eliminado satisfactoriamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede eliminar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
    }

    public List<SelectItem> getListarMunicipios() {
         this.listarMunicipios = new ArrayList<SelectItem>();
        daoMunicipios mdao = new impMunicipios();
        List<Municipios> m = mdao.mostrarMunicipios();
        listarMunicipios.clear();
        for (Municipios g : m) {
            SelectItem gradoItem = new SelectItem(g.getIdLocalidad(), g.getMunicipio());
            this.listarMunicipios.add(gradoItem);
        }
        return listarMunicipios;
    }
     
     
    
}
