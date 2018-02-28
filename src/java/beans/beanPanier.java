package beans;

import obj.LigneCommande;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import obj.Ouvrage;

public class beanPanier implements Serializable {

    HashMap<String, LigneCommande> map;
    HashMap<String, Ouvrage> mapO;
    
    public beanPanier() {
        this.map= new HashMap();
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
     public void addO(int idOuvrage, String titre) {
        if( this.mapO.containsKey(idOuvrage)) {
            Ouvrage o= this.mapO.get(idOuvrage);
//            i.setQty( i.getQty()+1);
            o.changeQty( +1);
        } else {
            Ouvrage o = new Ouvrage(idOuvrage, titre);
            this.mapO.put(String.valueOf(idOuvrage), o);
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
    public Collection<Ouvrage> listO() {
        return this.mapO.values();
    }
    
}
