
package beans;

import accesBDD.LigneCommandeDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;

public class beanLigneCommande implements Serializable {
    private LigneCommandeDAO liDAO;
    
    public beanLigneCommande() throws NamingException {
        liDAO = new LigneCommandeDAO();
    }
    
    public List<LigneCommande> findLigneCommandeCl(int numCommande) throws SQLException{
        
        List<LigneCommande> lLC = liDAO.findLigneCommandeCl(numCommande);
       return lLC;
    }
}
