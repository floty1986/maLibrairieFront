
package accesBDD;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.LigneCommande;

public class LigneCommandeDAO implements Serializable {
    private MaConnexion mc;

    public LigneCommandeDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    public List<LigneCommande> findLigneCommandeCl(int numCommande) throws SQLException {

        List<LigneCommande> mesLigneC = new ArrayList<>();
        String req = "SELECT idLC, numCommande, idOuvrage, prix, qteCommandee, remise, tvaLC FROM LigneCommande WHERE numCommande =?";
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            stm.setInt(1, numCommande);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                LigneCommande lC = new LigneCommande(rs.getInt("idLc"), rs.getInt("numCommande"), rs.getInt("idOuvrage"), rs.getFloat("prix"), rs.getInt("qteCommandee"), rs.getFloat("remise"), rs.getFloat("tvaLC"));
                mesLigneC.add(lC);
            }

            return mesLigneC;

        }

    }
}


