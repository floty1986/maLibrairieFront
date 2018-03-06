package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import obj.Commande;

public class CommandeDAO implements Serializable {

    private MaConnexion mc;

    public CommandeDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Commande> selectCommande(int idClient) throws SQLException {
        List<Commande> lcom = new ArrayList<>();
        String req = "select numCommande, idAdresseFacturation, idAdresseLivraison, idClient, dateCommande, fraisPort, ipClient, nomStatut from Commande where idClient=?";
        Commande co = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setInt(1, idClient);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                co = new Commande();
                co.setIdClient(rs.getInt("idClient"));
                co.setNumCommande(rs.getInt("numCommande"));
                co.setIdAdresseFacturation(rs.getInt("idAdresseFacturation"));
                co.setIdAdresseLivraison(rs.getInt("idAdresseLivraison"));
                co.setDateCommande(rs.getDate("dateCommande"));
                co.setFraisPort(rs.getInt("fraisPort"));
                co.setIpClient(rs.getString("ipClient"));
                co.setStatut(rs.getString("nomStatut"));
                lcom.add(co);

            }
        }

        return lcom;
    }

    public void insertCommande(int numCommande, int idAdresseFacturation,
            int idAdresseLivraison, int idClient, Date dateCommande,
            float fraisPort, String ipClient, String nomStatut) throws SQLException {

        String req = "INSERT INTO Commande(numCommande, idAdresseFacturation, idAdresseLivraison, idClient, dateCommande, fraisPort, ipClient, nomStatut)VALUES (?,?,?,?,?,?,?,?)";

        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setInt(1, numCommande);
            stm.setInt(2, idAdresseFacturation);
            stm.setInt(3, idAdresseLivraison);
            stm.setInt(4, idClient);
            stm.setDate(5, (java.sql.Date) dateCommande);
            stm.setFloat(6, fraisPort);
            stm.setString(7, ipClient);
            stm.setString(8, nomStatut);

            int nb = stm.executeUpdate();
        }

    }

}
