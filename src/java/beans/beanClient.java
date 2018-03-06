
package beans;

import accesBDD.ClientDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.naming.NamingException;

public class beanClient implements Serializable {
    
    private ClientDAO cDAO;
    
    public beanClient() throws NamingException  {
        cDAO = new ClientDAO();
    }
    
    public void insertClient(String nom, String prenom, String genre, Date dateNaissance, String email, String telephone, String motDePasse){
        try {
            cDAO.insertClient(nom, prenom, genre, dateNaissance, email, telephone, motDePasse);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modifierClient(int idClient, String nom, String prenom, String genre, String dateNaissance, String email, String telephone, String motDePasse){
        try {
            cDAO.modifierClient(idClient, nom, prenom, genre, dateNaissance, email, telephone, motDePasse);
        } catch (SQLException | ParseException ex) {
            ex.printStackTrace();
        }
    }
         
}
