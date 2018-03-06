package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String req = "select idClient, nom, prenom, genre, dateNaissance, email, telephone, motDePasse from client where email=?";
        Client c = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                c = new Client();
                c.setIdClient(Integer.valueOf(rs.getString("idClient")));
                c.setNom(rs.getString("nom"));
                c.setPrenom(rs.getString("prenom"));
                c.setGenre(rs.getString("genre"));
                c.setDateNaissance(rs.getDate("dateNaissance"));
                c.setEmail(email);
                c.setTelephone(rs.getString("telephone"));
                c.setMotDePasse(rs.getString("motDePasse"));

            }            
        }
        return c;

    }

    ////////////////////////////////////////////

    public void insertClient(String nom, String prenom, String genre, Date dateNaissance, String email, String telephone, String motDePasse) throws SQLException {
        String req = "INSERT INTO Client(nom, prenom, genre, dateNaissance, email, telephone, motDePasse)VALUES (?,?,?,?,?,?,?)";

        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
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

    public void modifierClient(int idClient, String nom, String prenom, String genre, String dateNaissance, String email, String telephone, String motDePasse) throws SQLException, ParseException{
        String req ="UPDATE Client SET nom=?, prenom=?, genre=?, dateNaissance=?, email=?, telephone=?, motDePasse=? where idClient like ?";
        
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            
            stm.setString(1, nom);
            stm.setString(2, prenom);
            stm.setString(3, genre);
            if (dateNaissance == null || "".equals(dateNaissance)) {
                stm.setNull(4, java.sql.Types.DATE);
            } else {
                SimpleDateFormat dateModel = new SimpleDateFormat("dd-MM-yyyy");
                java.util.Date dateFormatDate = dateModel.parse(dateNaissance);
                java.sql.Date sqlDate = new java.sql.Date(dateFormatDate.getTime());                 
                stm.setDate(4, sqlDate);
            }
            stm.setString(5, email);
            stm.setString(6, telephone);
            stm.setString(7, motDePasse);
            stm.setInt(8, idClient);

            int nb = stm.executeUpdate();
            System.out.println("nombre de ligne affectée : "+nb);
            
            
            
        }
    }

                stm.setNull(4, java.sql.Types.DATE);
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date formatDate01 = dateFormat.parse(dateNaissance);
                java.sql.Date sqlDate01 = new java.sql.Date(formatDate01.getTime());
                stm.setDate(4, sqlDate01);
            }
                stm.setString(5, email);
                stm.setString(6, telephone);
                stm.setString(7, motDePasse);

                int nb = stm.executeUpdate();
            }

        }

    }
