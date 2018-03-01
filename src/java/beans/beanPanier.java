package beans;

import accesBDD.PanierDAO;
import obj.LigneCommande;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;

public class beanPanier implements Serializable {

    HashMap<String, LigneCommande> map;
    private PanierDAO pDAO;
    ArrayList<LigneCommande> LC;
    
    public beanPanier() throws NamingException {
        pDAO = new PanierDAO();
    }
    public beanPanier(ArrayList<LigneCommande> LC) {
       this.LC = LC;
    }

    public beanPanier(HashMap<String, LigneCommande> map) {
        this.map = map;
    }
    
    public List<String> getLC(){
        List<String> ligneCmd = new ArrayList();
        ligneCmd.add("Commande en cours");
        return ligneCmd;
    }
    
    public HashMap<String, List<LigneCommande>> findCommande() throws SQLException{
        List<String> clefs = getLC();
        HashMap<String, List<LigneCommande>> mlc = new HashMap<>();
        for(String cle : clefs){
            List<LigneCommande> lp = new ArrayList<>();
            mlc.put(cle, lp);
        }
        List<LigneCommande> lLC = pDAO.selectPanier();
        for(LigneCommande LC : lLC){
//            String lettre = p.getNom().toUpperCase().charAt(0)+"";
            for(String cle : clefs){
//                String regex = "["+cle+"]";
                    List<LigneCommande> lp = mlc.get(cle);
                    lp.add(LC);
            }
        }        
        return mlc;
    }
    
    
    public void add(String ref) {
        if( this.map.containsKey(ref)) {
            LigneCommande i= this.map.get(ref);
//            i.setQty( i.getQty()+1);
            i.changeQteCommandee( +1);
        } else {
            LigneCommande i = new LigneCommande(ref, 1);
            this.map.put(ref, i);
        }
    }
    public void dec( String ref) {
       if( this.map.containsKey( ref)) {
           LigneCommande i = this.map.get(ref);
           i.changeQteCommandee( -1);
           if (i.getQteCommandee()< 1) {
               del(ref);
           }
       } 
    }
    public void del( String ref) {
        this.map.remove(ref);
    }
    public float getTotalHT() {
        return -1;
    } 
    public void clear() {
        this.map.clear();
    }
    public int size() {
        return this.map.size();
    }
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    public Collection<LigneCommande> list() {
        return this.map.values();
    }
    
}
