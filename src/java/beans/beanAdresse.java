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
    
    public void insertAdresseBA (int idClientCreer,int idClientUtiliser,String typeAdresse,String numVoie,String typeVoie,String nomVoie,String complement,String codePostal,String ville,String pays,String nom,String prenom, String email,String telephone){
        try {
            aDAO.insertAdresse(idClientCreer, idClientUtiliser, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Adresse> adresseClient(int idClient,String typeAdresse) throws SQLException{
        List<Adresse> mesAdresses = aDAO.adresseClient(idClient, typeAdresse);
        return mesAdresses;
    }
    
    
    
    
   

}