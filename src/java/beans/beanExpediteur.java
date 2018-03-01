package beans;

import accesBDD.ExpediteurDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import obj.Expediteur;

public class beanExpediteur {
    
    ArrayList<Expediteur> listeE;
    private ExpediteurDAO eDAO;
    
    public beanExpediteur() throws NamingException{
        eDAO = new ExpediteurDAO();
    }

    public beanExpediteur(ArrayList<Expediteur> listeE) {
        this.listeE = listeE;
    }

//    @Override
//    public String toString() {
//        return "beanExpediteur{" + "listeE=" + listeE + '}';
//    }
    
    
    
    public List<String> getDefaultTable(){
        List<String> tables = new ArrayList<>();
        tables.add("Nom expediteur");
        return tables;
    }
    
    public HashMap<String, List<Expediteur>> findExpediteur() throws SQLException{
        List<String> tables = getDefaultTable();
        HashMap<String, List<Expediteur>> me = new HashMap<>();
        for (String table : tables){
            List<Expediteur> le = new ArrayList<>();
            me.put(table, le);
        }
        List<Expediteur> lExpediteur = eDAO.selectAllExpediteur();
        for(Expediteur ex : lExpediteur){
//            String lettre = ex.getNom().toUpperCase();
            for(String table : tables){
                List<Expediteur> lee = me.get(table);
                lee.add(ex);
            }
        }
        return me; 
    }
    
}
