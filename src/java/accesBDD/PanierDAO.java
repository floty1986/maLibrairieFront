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
import obj.LigneCommande;

public class PanierDAO implements Serializable {

    private MaConnexion mc;

    public PanierDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<LigneCommande> selectPanier() throws SQLException {
        String req = "select LigneCommande.idLC, LigneCommande.numCommande, LigneCommande.idOuvrage, "
                + "LigneCommande.prix, LigneCommande.qteCommandee, LigneCommande.remise, "
                + "LigneCommande.tvaLC, LigneCommande.titre from LigneCommande join LigneCommande "
                + "on lc.idOuvrage = ouv.idOuvrage";
        List<LigneCommande> lc = new ArrayList<>();
        try (Connection cnt = mc.getConnection();
                Statement stm = cnt.createStatement()) {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
                int idLC = rs.getInt("idLC");
                int numCommande = rs.getInt("numCommande");
                int idOuvrage = rs.getInt("idOuvrage");
                float prix = rs.getFloat("prix");
                int qteCommande = rs.getInt("qteCommandee");
                float remise = rs.getFloat("remise");
                float tvaLC = rs.getFloat("tvaLC");
                String titre = rs.getString("titre");
                LigneCommande lcc = new LigneCommande(idLC, numCommande, idOuvrage, prix, qteCommande, remise, tvaLC, titre);
                lc.add(lcc);
            }
        }
        return lc;
    }

    public LigneCommande selectPanierById(int commande) throws SQLException {
        String req = "select lc.idLC, lc.numCommande, lc.idOuvrage, "
                + "lc.prix, lc.qteCommandee, lc.remise, "
                + "lc.tvaLC ouv.titre from LigneCommande lc join Ouvrage ouv "
                + "on lc.idOuvrage = ouv.idOuvrage where numCommande = ?";
        LigneCommande lc = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req)) {
            stm.setInt(1, commande);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int idLC = rs.getInt("idLC");
                int numCommande = rs.getInt("numCommande");
                int idOuvrage = rs.getInt("idOuvrage");
                float prix = rs.getFloat("prix");
                int qteCommande = rs.getInt("qteCommandee");
                float remise = rs.getFloat("remise");
                float tvaLC = rs.getFloat("tvaLC");
                String titre = rs.getString("titre");
                lc = new LigneCommande(idLC, numCommande, idOuvrage, prix, qteCommande, remise, tvaLC, titre);
            }
        }
        return lc;
    }

}
