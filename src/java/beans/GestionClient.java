package beans;

import accesBDD.ClientDAO;
import java.io.Serializable;
import javax.naming.NamingException;


public class GestionClient implements Serializable {
 
    private ClientDAO cDAO;
    
    public GestionClient() throws NamingException {
        cDAO = new ClientDAO();
        
    }
    

    
    
	
    

}