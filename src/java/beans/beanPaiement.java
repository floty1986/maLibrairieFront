package beans;

import accesBDD.OrganismePaiementDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import obj.OrganismePaiement;

public class beanPaiement {

    ArrayList<OrganismePaiement> listeOp;
    private OrganismePaiementDAO OpDAO;

    public beanPaiement() throws NamingException {
        OpDAO = new OrganismePaiementDAO();
    }

    public beanPaiement(ArrayList<OrganismePaiement> listeOp) {
        this.listeOp = listeOp;
    }

//    @Override
//    public String toString() {
//        return "beanExpediteur{" + "listeE=" + listeE + '}';
//    }
    public List<String> getDefaultOrg() {
        List<String> tables = new ArrayList<>();
        tables.add("Nom organisme");
        return tables;
    }

    public HashMap<String, List<OrganismePaiement>> findOrg() throws SQLException {
        List<String> lOrg = getDefaultOrg();
        HashMap<String, List<OrganismePaiement>> me = new HashMap<>();
        for (String tables : lOrg) {
            List<OrganismePaiement> le = new ArrayList<>();
            me.put(tables, le);
        }
        List<OrganismePaiement> lOrganismePaiement = OpDAO.selectAllOrg();
        for (OrganismePaiement ex : lOrganismePaiement) {
//            String lettre = ex.getNom().toUpperCase();
            for (String tables : lOrg) {
                List<OrganismePaiement> lee = me.get(tables);
                lee.add(ex);
            }
        }
        return me;
    }

}
