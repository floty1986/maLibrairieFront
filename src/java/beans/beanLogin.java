
package beans;

import accesBDD.ClientDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

import obj.Client;

public class beanLogin implements Serializable {
    
    private  ClientDAO cDAO;

    public beanLogin() throws NamingException {
        cDAO= new ClientDAO();
    }
    
    public String nomPrenomClient(String email) {
        try {
            String nomPrenomClient;
            Client c =cDAO.selectLogin(email);
            nomPrenomClient = c.getNom()+" "+c.getPrenom();
            return nomPrenomClient;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(beanLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public boolean check( String email, String password)  {
        try {
            Client c;
            c = cDAO.selectLogin(email);            
            if( email==null) return false;
            if( password==null) return false;
            if( email.trim().isEmpty()) return false;
            if( password.trim().isEmpty()) return false;            
            if( email.equals(c.getEmail()))
                if( password.equals(c.getMotDePasse()))
                    return true;            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(beanLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Client profilClient(String email) {
        try {
            
            Client c =cDAO.selectLogin(email);
            
            return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(beanLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
