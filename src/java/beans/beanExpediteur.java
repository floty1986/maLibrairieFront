package beans;

import accesBDD.ExpediteurDAO;
import javax.naming.NamingException;

public class beanExpediteur {
    
    ExpediteurDAO eDAO;
    
    public beanExpediteur() throws NamingException{
        eDAO = new ExpediteurDAO();
    }
    
    
    
}
