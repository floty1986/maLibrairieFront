package accesBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.Expediteur;

public class ExpediteurDAO {
    
    private MaConnexion mc; 
    
    public ExpediteurDAO() throws NamingException{
        mc = new MaConnexion();
    }
    
    public List<Expediteur> selectAllExpediteur() throws SQLException {
        String req = "select idExpediteur, nom "
                + "from Expediteur";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        List<Expediteur> le = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                int id = rs.getInt("idExpediteur");
                String nom = rs.getString("nom");
               
                Expediteur ex = new Expediteur(id, nom);
                le.add(ex);
            }
            rs.close();
        }finally{
            if(cnt != null){
                cnt.close();
            }
        }        
        return le;
    }
    
    
    
}
