package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Adresse;

public class AdresseDAO implements Serializable {

    private MaConnexion mc;

    public AdresseDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    public String idClient() throws SQLException{
        String req02 = "select MAX (idClient) as idClient from Client";
        String idClient =null; 
        try (Connection cnt = mc.getConnection();
                Statement stm = cnt.createStatement();) {
            ResultSet rs = stm.executeQuery(req02);
            if(rs.next()){
                 idClient = rs.getString("idClient");
            }
        
    }
        return idClient;
    }

    public void insertAdresse(String typeAdresse, String numVoie, String typeVoie, String nomVoie, String complement, String codePostal, String ville, String pays, String nom, String prenom, String email, String telephone, String nomStatut) throws SQLException {
        String req = "INSERT INTO Adresse(idClientCreer, idClientUtiliser, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut ) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            

            String idClients = this.idClient();
            int idClient = Integer.valueOf(idClients);
            stm.setInt(1, idClient);
            stm.setInt(2, idClient);
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
            stm.setString(15, nomStatut);

            int nb = stm.executeUpdate();
            System.out.println("nb:"+ nb);
        } catch ( Exception e) {
            System.out.println(nom+" insertClient: "+ e.getMessage());
            
        }
    }

    public List<Adresse> adresseClient(int idClient, String typeAdresse) throws SQLException {
        String req = "SELECT idAdresse, idClientCreer, idClientUtiliser, typeAdresse, numVoie, typeVoie, nomVoie, complement, codePostal, ville, pays, nom, prenom, email, telephone, nomStatut FROM Adresse WHERE idClientCreer=? AND typeAdresse=?";
        List<Adresse> mesAdresses = new ArrayList<>();
        
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setInt(1, idClient);
            stm.setString(2, typeAdresse);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Adresse a = new Adresse(rs.getInt("idAdresse"), rs.getInt("idClientCreer"), rs.getInt("idClientUtiliser"), rs.getString("typeAdresse"), rs.getString("numVoie"), rs.getString("typeVoie"), rs.getString("nomVoie"), rs.getString("complement"), rs.getString("codePostal"), rs.getString("ville"), rs.getString("pays"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("nomStatut"));
                mesAdresses.add(a);

            }
        }
        return mesAdresses;

    }
}


