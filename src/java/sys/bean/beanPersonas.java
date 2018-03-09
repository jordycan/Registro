/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;

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
import sys.dao.daoPersonas;
import sys.dao.daoPromotores;
import sys.imp.impMunicipios;
import sys.imp.impPersonas;
import sys.imp.impPromotores;
import sys.model.Municipios;
import sys.model.Personas;
import sys.model.Promotores;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Named(value = "beanPersonas")
@ViewScoped

public class beanPersonas implements Serializable{

    /**
     * Creates a new instance of beanPersonas
     */
    private Personas persona;
    private String text;
    private Municipios municipio;
    private List<SelectItem> listarMunicipios;   
     private List<SelectItem> listarPromotores;
     private List<Personas> listarPersonas;
     private List<Personas> filterPersonas;
    private Promotores promotores;
    public beanPersonas() {
        persona = new Personas();
        municipio = new Municipios();
        promotores = new Promotores();
    }

    public Promotores getPromotores() {
        return promotores;
    }

    public void setPromotores(Promotores promotores) {
        this.promotores = promotores;
    }
    
    
    
    public Personas getPersona() {
        return persona;
    }

    public void setPersona(Personas persona) {
        this.persona = persona;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Municipios getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }

    public List<Personas> getListarPersonas() {
        daoPersonas pdao = new impPersonas();
        listarPersonas = pdao.mostrarPersonas();
        return listarPersonas;
    }

    public void setListarPersonas(List<Personas> listarPersonas) {
        this.listarPersonas = listarPersonas;
    }

    public List<Personas> getFilterPersonas() {
          daoPersonas pdao = new impPersonas();
          filterPersonas = pdao.mostrarPersonas();
        return filterPersonas;
    }

    public void setFilterPersonas(List<Personas> filterPersonas) {
        this.filterPersonas = filterPersonas;
    }
    
    

    public List<SelectItem> getListarPromotores() {
          this.listarPromotores = new ArrayList<SelectItem>();
        daoPersonas pdao = new impPersonas();
        List<Promotores> m = pdao.verPromotores(this.persona);
        listarPromotores.clear();
        for (Promotores promotores : m) {
            SelectItem materiaItem = new SelectItem(promotores.getIdPromotor(), promotores.getNombreCompleto());
            this.listarPromotores.add(materiaItem);
        }

        
        return listarPromotores;
    }

    public void setListarPromotores(List<SelectItem> listarPromotores) {
        this.listarPromotores = listarPromotores;
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

    public void setListarMunicipios(List<SelectItem> listarMunicipios) {
        this.listarMunicipios = listarMunicipios;
    }
    
    
    
    
    public void insertarPersona(){
         daoPersonas pdao = new impPersonas();
        boolean inserto=pdao.insertarPersona(persona);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a ingresado satisfactoriamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede insertar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
        persona = new Personas();
    }
    
      public void editarPersona(){
         daoPersonas pdao = new impPersonas();
        boolean inserto=pdao.editarPersona(persona);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a ingresado satisfactoriamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede insertar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
        persona = new Personas();
    }
      
        public void eliminarPersona(){
         daoPersonas pdao = new impPersonas();
        boolean inserto=pdao.eliminarPersona(persona);
        if(inserto){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se a ingresado satisfactoriamente"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "El registro no se puede insertar en este momento. Intente más tarde o contacte a soporte técnico."));
        }
        persona = new Personas();
    }
    
}
