/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Municipios;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface daoMunicipios {
    
    public boolean actualizarMunicipios(Municipios municipios);
    
    public boolean registroMunicipios(Municipios municipios);    
    
    public boolean eliminarMunicipios(Municipios municipios);
   
    public List<Municipios> mostrarMunicipios();
    
}
