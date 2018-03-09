/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Municipios;
import sys.model.Personas;
import sys.model.Promotores;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface daoPersonas {

    public boolean insertarPersona(Personas persona);
    
    public boolean editarPersona(Personas persona);
    
    public boolean eliminarPersona(Personas persona);
    
    public List<Personas> mostrarPersonas();

    public List<Municipios> mostrarMunicipios();

    public List<Promotores> verPromotores(Personas personas);
}
