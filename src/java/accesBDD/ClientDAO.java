package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import obj.Client;

public class ClientDAO implements Serializable {

    private MaConnexion mc;

    public ClientDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public Client selectLogin(String email) throws SQLException {
        String req = "select motDePasse, nom, prenom, email from client where email=?";
        Client c = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setMotDePasse(rs.getString("motDePasse"));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setEmail(email);
            }

        }
        return c;
    }
  ////////////////////////////////////////////
    public void insertClient(String nom, String prenom, String genre, Date dateNaissance, String email, String telephone, String motDePasse ) throws SQLException {
        String req = "INSERT INTO Client(nom, prenom, genre, dateNaissance, email, telephone, motDePasse)VALUES (?,?,?,?,?,?,?)";
        

        
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);
                ){
                    stm.setString(1, nom);
                    stm.setString(2, prenom);
                    stm.setString(3, genre);
                    stm.setDate(4, (java.sql.Date) dateNaissance);
                    stm.setString(5, email);
                    stm.setString(6, telephone);
                    stm.setString(7, motDePasse);
            
                    int nb = stm.executeUpdate();
        }
        
        
        
    }
    
    public List<Client> selectClient() throws SQLException {
        String req = "select nom, prenom, email, motDePasse "
                + "from Client";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        List<Client> lc = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);
            
            while (rs.next()) {
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String email = rs.getString("email");
                String motDePasse = rs.getString("motDePasse");
                Client c = new Client();
                c.setNom(nom);
                c.setPrenom(prenom);
                c.setEmail(email);
                c.setMotDePasse(motDePasse);
                lc.add(c);
            }
            rs.close();
        }finally{
            
                cnt.close();
            
        }        
        return lc;
    }

}
