package beans;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import obj.Ouvrage;

public class beanCatalogue implements Serializable {
    
    ArrayList<Ouvrage> listeO;

    public beanCatalogue(ArrayList<Ouvrage> listeO) {
        this.listeO = listeO;
    }

    @Override
    public String toString() {
        return "beanCatalogue{" + "liste Ouvrages : " + listeO + '}';
    }
  
}
