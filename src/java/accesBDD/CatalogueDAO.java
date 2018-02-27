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

public class CatalogueDAO implements Serializable {

    private MaConnexion mc;

    public CatalogueDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Ouvrage> selectAllOuvrages() throws SQLException {
        String req = "SELECT idOuvrage, titre FROM Ouvrage ORDER BY Ouvrage;";
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

    public Ouvrage selectOuvrageById(int idOuvrage) throws SQLException {
        String req = "SELECT idOuvrage, titre FROM Ouvrage where idOuvrage = ? ORDER BY titre;";

        Ouvrage o = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setInt(1, idOuvrage);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                idOuvrage = rs.getInt("idOuvrage");
                String titre = rs.getString("titre");
                o = new Ouvrage(idOuvrage, titre);
            }
        }
        return o;
    }

}
