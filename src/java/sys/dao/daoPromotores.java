/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Municipios;
import sys.model.Promotores;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface daoPromotores {
    
    public boolean insertarPromotores(Promotores promotores);
    
    public List<Municipios> verMunicipios(); 
    
   
    
    public List<Promotores> verPromotoresPorNomre(Promotores promotores);
    
    public boolean editarPromotor(Promotores promotores);
    
    public boolean eliminarPromotor(Promotores promotores);
    
}
