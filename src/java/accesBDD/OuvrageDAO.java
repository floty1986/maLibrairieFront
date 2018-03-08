package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Ouvrage;

public class OuvrageDAO implements Serializable {

    private MaConnexion mc;

    public OuvrageDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Ouvrage> selectAllOuvrages() throws SQLException {
        String req = "SELECT idOuvrage, titre, prix, qteStockee, imageOuvrage, nomStatut FROM ouvrage  ORDER BY titre";
        Connection cnt = mc.getConnection();
        java.sql.Statement stm = cnt.createStatement();
        List<Ouvrage> lo = new ArrayList<>();

        try (ResultSet rs = stm.executeQuery(req)) {
            while (rs.next()) {
                Ouvrage o = new Ouvrage(rs.getInt("idOuvrage"), rs.getString("titre"), rs.getFloat("prix"), rs.getInt("qteStockee"), rs.getString("imageOuvrage"), rs.getString("nomStatut"));
                lo.add(o);
            }
        }

        if (cnt != null) {
            cnt.close();
        }

        return lo;
    }

    public List<Ouvrage> selectOuvrageByTitre(String titre) throws SQLException {
        String req = "SELECT idOuvrage, titre, prix, qteStockee, imageOuvrage, nomStatut FROM Ouvrage where titre LIKE ? ORDER BY titre";

        
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            String titrePattern = "%" + titre + "%";
            stm.setString(1, titrePattern);
            ResultSet rs = stm.executeQuery();
            List<Ouvrage> lo = new ArrayList<>();
            while (rs.next()) {
                Ouvrage o = new Ouvrage(rs.getInt("idOuvrage"), rs.getString("titre"), rs.getFloat("prix"), rs.getInt("qteStockee"), rs.getString("imageOuvrage"), rs.getString("nomStatut"));
                
                lo.add(o);
            }
            return lo;
        }
    }

    public String selectAuteur(int idOuvrage) throws SQLException {
        String req = "SELECT nom, prenom FROM Auteur a JOIN Bibliographie b on a.idAuteur=b.idAuteur JOIN Ouvrage o ON b.idOuvrage=o.idOuvrage WHERE o.idOuvrage = ?";
        String auteur = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setInt(1, idOuvrage);
            
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                  
            auteur = rs.getString("prenom") + " " + rs.getString("nom");
            
//            return auteur;
            }
        }
        return auteur;
        
    }

    public List<Integer> selectAllIdOuvrage() throws SQLException {
        String req = "SELECT idOuvrage FROM Ouvrage";
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            ResultSet rs = stm.executeQuery();
            List<Integer> lid = new ArrayList<>();
            while (rs.next()) {
                lid.add(rs.getInt("idOuvrage"));
            }
            return lid;
        }
    }
    
    
}
