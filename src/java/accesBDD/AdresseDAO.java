package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Adresse;

public class AdresseDAO implements Serializable {

    private MaConnexion mc;

    public AdresseDAO(MaConnexion mc) throws NamingException {
        mc = new MaConnexion();
    }

    public void insertAdresse() throws SQLException {
        String req = "INSERT INTO Adresse(idClientCreer, idClientUtiliser, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Adresse ad = null;
        int idClientCreer=0;
        int idClientUtiliser=0;
        String typeAdresse=null;
        String numVoie=null;
        String typeVoie=null;
        String nomVoie=null;
        String complement=null;
        String codePostal=null;
        String ville=null;
        String pays=null;
        String nom=null;
        String prenom=null;
        String email=null;
        String telephone=null;

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
                
                
                
        }
    }

}
