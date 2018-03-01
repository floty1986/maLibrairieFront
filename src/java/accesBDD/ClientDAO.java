
package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import obj.Client;


public class ClientDAO implements Serializable{
    private MaConnexion mc;

    public ClientDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    public Client selectLogin(String email) throws SQLException {
        String req = "select motDePasse, nom, email from client where email=?";
        Client c = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setMotDePasse(rs.getString("motDePasse"));
                c.setNom(rs.getString("nom"));
                c.setEmail(email);
            }

        }
        return c;
    }

    
}


