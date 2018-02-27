
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
import obj.Client;


public class ClientDAO implements Serializable{
    private MaConnexion mc;

    public ClientDAO() throws NamingException {
        mc = new MaConnexion();
    }
    
    public Client selectLogin(String email) throws SQLException{
        String req ="select c.motDePasse from c.client where c.email=?";
        Client c = null;
        try(Connection cnt = mc.getConnection();
            PreparedStatement stm = cnt.prepareStatement(req);
            ){
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            rs.next();
            c = new Client();
            c.setMotDePasse(rs.getString("motDePasse"));
            }
        
        return c;
    }
    
    
}


