package traitements;

import accesBDD.OuvrageDAO;
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
    
    public List<List<Integer>> getPagination(int nbOuv) throws SQLException {
        List<List<Integer>> idOPage = new ArrayList<>();
        List<Ouvrage> lo = oDAO.selectAllOuvrages();
        int i = 0;
        int nbOPage = nbOuv;
        while (nbOPage == nbOuv) {
            List<Integer> idPage = new ArrayList<>();
            for (int k=1+nbOuv*i;k<=nbOuv+nbOuv*i;k++) {
                idPage.add(lo.get(k-1).getIdOuvrage());
            }            
            idOPage.add(idPage);
            nbOPage = idPage.size();
            i += 1;
        }
        return idOPage;
    }
    public List<Ouvrage> findOuvrages2() throws SQLException {
        List<Ouvrage> lo = new ArrayList<>();
        lo = oDAO.selectAllOuvrages();
        return lo;
    }
    
    public HashMap<String, List<Ouvrage>> findOuvrages() throws SQLException{
        List<String> clefs = getCleDefaut();
        HashMap<String, List<Ouvrage>> mo = new HashMap<>();
        for(String cle : clefs){
            List<Ouvrage> lo = new ArrayList<>();
            mo.put(cle, lo);
        }
        List<Ouvrage> lOuvrage = oDAO.selectAllOuvrages();
        for(Ouvrage o : lOuvrage){
            String lettre = o.getTitre().toUpperCase().charAt(0)+"";
            for(String cle : clefs){
                String regex = "["+cle+"]";
                if(lettre.matches(regex)){
                    List<Ouvrage> lo = mo.get(cle);
                    lo.add(o);
                }
            }
        }        
        return mo;
    }
    
    public List<Ouvrage> findOuvragebyTitre (String titre) throws SQLException {
        List<Ouvrage> lo = oDAO.selectOuvrageByTitre(titre);
        return lo;
    }
    
    public HashMap<Integer, String> findAuteur () throws SQLException {
        HashMap<Integer, String> ma = new HashMap<>();
        List<Integer> lid = oDAO.selectAllIdOuvrage();
        for (Integer l : lid) {
            String auteur = oDAO.selectAuteur(l);
            ma.put(l, auteur);
        }
        return ma;
    }
    
    
    
}
