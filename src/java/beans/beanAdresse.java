package beans;

import accesBDD.AdresseDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import obj.Adresse;


public class beanAdresse implements Serializable {

    private AdresseDAO aDAO;

    public beanAdresse() throws NamingException  {
        aDAO = new AdresseDAO();
    }
    
    public void insertAdresse (String typeAdresse,String numVoie,String typeVoie,String nomVoie,String complement,String codePostal,String ville,String pays,String nom,String prenom, String email,String telephone, String nomStatut) throws SQLException{
        
            aDAO.insertAdresse( typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut);
        
    }
    
    public void ajouterAdresse (int idClient, String typeAdresse,String numVoie,String typeVoie,String nomVoie,String complement,String codePostal,String ville,String pays,String nom,String prenom, String email,String telephone, String nomStatut) throws SQLException{
        
            aDAO.ajouterAdresse(idClient, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut);
        
    }
    
    public List<Adresse> adresseClient(int idClient,String typeAdresse) throws SQLException{
        List<Adresse> mesAdresses = aDAO.adresseClient(idClient, typeAdresse);
        return mesAdresses;
    }
    
    public void supAdresse(int idAdresse) throws SQLException{
        aDAO.supAdresse(idAdresse);
    }
    
    
   

}
