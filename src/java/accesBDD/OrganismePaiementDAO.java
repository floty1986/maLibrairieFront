
package accesBDD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import obj.OrganismePaiement;


public class OrganismePaiementDAO {
    
    private MaConnexion mc; 
    
    public OrganismePaiementDAO() throws NamingException{
        mc = new MaConnexion();
    }
    
    public List<OrganismePaiement> selectAllOrg() throws SQLException {
        String req = "select idOrganismePaiement, nom, typeOrganismePaiement "
                + "from OrganismePaiement";
        Connection cnt = mc.getConnection();
        Statement stm = cnt.createStatement();
        List<OrganismePaiement> lop = new ArrayList<>();
        try {
            ResultSet rs = stm.executeQuery(req);

            while (rs.next()) {
                int id = rs.getInt("idOrganismePaiement");
                String nom = rs.getString("nom");
                String type = rs.getString("typeOrganismePaiement");
                OrganismePaiement ex = new OrganismePaiement(id, nom, type);
                lop.add(ex);
            }
            rs.close();
        }finally{
            if(cnt != null){
                cnt.close();
            }
        }        
        return lop;
    }
    
    
    
}
