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
        String req = "SELECT idOuvrage, titre FROM ouvrage  ORDER BY titre";
        Connection cnt = mc.getConnection();
        java.sql.Statement stm = cnt.createStatement();
        List<Ouvrage> lo = new ArrayList<>();

        try (ResultSet rs = stm.executeQuery(req)) {
            while (rs.next()) {
                Ouvrage o = new Ouvrage(rs.getInt("idOuvrage"), rs.getString("titre"));
                lo.add(o);
            }
        }

        if (cnt != null) {
            cnt.close();
        }

        return lo;
    }

    public List<Ouvrage> selectOuvrageByTitre(String titre) throws SQLException {
        String req = "SELECT idOuvrage, titre FROM Ouvrage where titre LIKE ? ORDER BY titre";

        Ouvrage o = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            String titrePattern = "%" + titre + "%";
            stm.setString(1, titrePattern);
            ResultSet rs = stm.executeQuery();
            List<Ouvrage> lo = new ArrayList<>();
            while (rs.next()) {
                titre = rs.getString("titre");
                int idOuvrage = rs.getInt("idOuvrage");
                o = new Ouvrage(idOuvrage, titre);
                lo.add(o);
            }
            return lo;
        }
    }

}
