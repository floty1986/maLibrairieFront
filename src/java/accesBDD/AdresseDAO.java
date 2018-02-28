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

    public void InsertAdresse() throws SQLException {
        String req = "INSERT INTO Adresse(typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        Adresse ad = null;

        try (Connection cnt = mc.getConnection();
            PreparedStatement stm = cnt.prepareStatement(req);
            ) {

        }
    }

}
