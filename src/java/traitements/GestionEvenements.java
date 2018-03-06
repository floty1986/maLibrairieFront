package traitements;

import accesBDD.evenementDAO;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.Evenement;

public class GestionEvenements implements Serializable {
   private evenementDAO eDAO;

    public GestionEvenements() throws NamingException {
        eDAO = new evenementDAO();
    }    
    
     public List<Evenement> findEvByDate () throws SQLException {
        List<Evenement> le = eDAO.selectEvEnCours();
        return le;
    }
    
}
