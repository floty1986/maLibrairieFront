package accesBDD;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.naming.NamingException;
import obj.Evenement;
import obj.Ouvrage;

public class evenementDAO implements Serializable {

    private MaConnexion mc;

    public evenementDAO() throws NamingException {
        mc = new MaConnexion();
    }

    public List<Evenement> selectEvEnCours() throws SQLException {
        String req = "SELECT idEvenement, nom, dateDebut, dateFin, descriptif FROM evenement where dateFin >= ?";
        Evenement e = null;
        try (Connection cnt = mc.getConnection();
                PreparedStatement stm = cnt.prepareStatement(req);) {
            LocalDate dateFin = LocalDate.now();
            System.out.println("date now : "+dateFin);
            stm.setDate(1, Date.valueOf(dateFin));
            ResultSet rs = stm.executeQuery();
            List<Evenement> le = new ArrayList<>();
            while (rs.next()) {
                int idEvenement = rs.getInt("idEvenement");
                String nom = rs.getString("nom");
                Date dateF = rs.getDate("dateFin");
                String desc = rs.getString("descriptif");
                e = new Evenement(idEvenement, nom, dateF, desc);
                le.add(e);
            }
            return le;
        }

    }
}
