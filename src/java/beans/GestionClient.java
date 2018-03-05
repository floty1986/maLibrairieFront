package beans;

import accesBDD.ClientDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Client;


public class GestionClient implements Serializable {
 
    private ClientDAO cDAO;
    
    public GestionClient() throws NamingException {
        cDAO = new ClientDAO();
    }
    
	
    public List<Client> findClient() throws SQLException{
        
            List<Client> lc = new ArrayList<>();       
            List<Client> lClient = cDAO.selectClient();
            for(Client c : lClient){
            c.getNom().toUpperCase();
            c.getPrenom().toUpperCase();
            c.getEmail();
            c.getMotDePasse();
      
       }
        
           
        return lc;
    }

}