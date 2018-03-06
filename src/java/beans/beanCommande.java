package beans;

import accesBDD.CommandeDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Commande;



public class beanCommande implements Serializable {
 
   ArrayList<Commande> listeCo;
   
   private CommandeDAO coDAO;
    
    public beanCommande() throws NamingException {
        coDAO = new CommandeDAO();
    }
    
    public List<Commande> findCommande(int idClient) throws SQLException{
        List<Commande> lco = coDAO.selectCommande(idClient);
       return lco;
            
    }
}

    

