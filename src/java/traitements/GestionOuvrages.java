package traitements;

import accesBDD.OuvrageDAO;
import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import obj.Ouvrage;

public class GestionOuvrages implements Serializable {
    

     private OuvrageDAO oDAO;

    public GestionOuvrages() throws NamingException {
        oDAO = new OuvrageDAO();
    }
    
    public List<String> getCleDefaut(){
        List<String> clefs = new ArrayList<>();
        clefs.add("A-F");
        clefs.add("G-L");
        clefs.add("M-R");
        clefs.add("S-Z");        
        return clefs;
    }
    
    public HashMap<String, List<Ouvrage>> findOuvrages() throws SQLException{
        List<String> clefs = getCleDefaut();
        HashMap<String, List<Ouvrage>> mo = new HashMap<>();
        for(String cle : clefs){
            List<Ouvrage> lo = new ArrayList<>();
            mo.put(cle, lo);
        }
        List<Ouvrage> lOuvrage = oDAO.selectAllOuvrages();
        for(Ouvrage p : lOuvrage){
            String lettre = p.getTitre().toUpperCase().charAt(0)+"";
            for(String cle : clefs){
                String regex = "["+cle+"]";
                if(lettre.matches(regex)){
                    List<Ouvrage> lo = mo.get(cle);
                    lo.add(p);
                }
            }
        }        
        return mo;
    }
    
    
    
}
