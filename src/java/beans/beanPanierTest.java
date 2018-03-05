package beans;

import accesBDD.PanierDAO;
import obj.LigneCommande;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import javax.naming.NamingException;

public class beanPanierTest implements Serializable {

    private PanierDAO pDAO;
    
    public beanPanierTest() throws NamingException{
        pDAO = new PanierDAO();
    }
   
    
}
