package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Adresse;

public class AdresseDAO implements Serializable {

    private MaConnexion mc;

    public AdresseDAO() throws NamingException {
        mc = new MaConnexion();
    }

 //String paramNom = request.getParameter( "nom" );
 //String paramPrenom = request.getParameter( "prenom" );
 //String paramGenre = request.getParameter( "" );
 //String paramDateNaissance = request.getParameter( "email" );
 //String paramEmail = request.getParameter( "email" );
 //String paramMotDePasse = request.getParameter( "email" );
 //String paramMotDePasseConf = request.getParameter( "email" );
 
 // int NvxClientEtape1 = statement.executeUpdate( "INSERT INTO Client (email, mot_de_passe, nom, date_inscription) "
 //      + "VALUES ('" + paramEmail + "', MD5('" + paramMotDePasse + "'), '" + paramNom + "', NOW());" );

    public void insertAdresse(int idClientCreer,int idClientUtiliser,String typeAdresse,String numVoie,String typeVoie,String nomVoie,String complement,String codePostal,String ville,String pays,String nom,String prenom, String email,String telephone) throws SQLException {
        String req = "INSERT INTO Adresse(idClientCreer, idClientUtiliser, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
        try (Connection cnt = mc.getConnection();
            PreparedStatement stm = cnt.prepareStatement(req);
            ) {
                      
                stm.setInt(1,idClientCreer );
                stm.setInt(2, idClientUtiliser);
                stm.setString(3, typeAdresse);
                stm.setString(4, numVoie);
                stm.setString(5, typeVoie);
                stm.setString(6, nomVoie);
                stm.setString(7, complement);
                stm.setString(8, codePostal);
                stm.setString(9, ville);
                stm.setString(10, pays);
                stm.setString(11, nom);
                stm.setString(12, prenom);
                stm.setString(13, email);
                stm.setString(14, telephone);
                
                int nb = stm.executeUpdate();
                
        }
    }

}
