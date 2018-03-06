package beans;

import accesBDD.ClientDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import javax.naming.NamingException;

public class beanClient implements Serializable {

    private ClientDAO cDAO;
    
    public beanClient() throws NamingException  {
        cDAO = new ClientDAO();
    }
    
    public void insertClient(String nom, String prenom, String genre, String dateNaissance, String email, String telephone, String motDePasse) throws SQLException, ParseException{
        
            cDAO.insertClient(nom, prenom, genre, dateNaissance, email, telephone, motDePasse);
        
    }
  
}
