
package beans;

import accesBDD.ClientDAO;
import java.io.Serializable;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;

public class beanLogin implements Serializable {
    
    private ClientDAO cDAO;

    public beanLogin() throws NamingException {
        cDAO= new ClientDAO();
    }
    
    public boolean check( String email, String password) throws SQLException {
        
        if( email==null) return false;
        if( password==null) return false;
        if( email.trim().isEmpty()) return false;
        if( password.trim().isEmpty()) return false;
        
        Client c = cDAO.selectLogin(email);
            if( password.equals(c.getMotDePasse()))
                return true;
        
        return false;
    }
    
}
