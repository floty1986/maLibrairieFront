package obj;

import java.util.Vector;

public class OrganismePaiement {
    private int idOrganismePaiement;
    private String nom;
    private String typeOrganismePaiement;

    public OrganismePaiement() {
    }

    public OrganismePaiement(int idOrganismePaiement, String nom, String typeOrganismePaiement) {
        this.idOrganismePaiement = idOrganismePaiement;
        this.nom = nom;
        this.typeOrganismePaiement = typeOrganismePaiement;
    }

    public OrganismePaiement(int idOrganismePaiement, String nom) {
        this.idOrganismePaiement = idOrganismePaiement;
        this.nom = nom;
    }
    
    

    public int getIdOrganismePaiement() {
        return idOrganismePaiement;
    }

    public void setIdOrganismePaiement(int idOrganismePaiement) {
        this.idOrganismePaiement = idOrganismePaiement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeOrganismePaiement() {
        return typeOrganismePaiement;
    }

    public void setTypeOrganismePaiement(String typeOrganismePaiement) {
        this.typeOrganismePaiement = typeOrganismePaiement;
    }

    @Override
    public String toString() {
        return nom + " - [" + typeOrganismePaiement + "]";
    }
    
    
    public Vector<OrganismePaiement> getVector() {
        Vector v = new Vector();
        v.add(this.idOrganismePaiement);
        v.add(this.nom);

        return v;
    }
    
    public Vector getVectorModif(){
        Vector v = new Vector();
        v.add(this.idOrganismePaiement);
        v.add(this.nom);
        v.add(this.typeOrganismePaiement);
        return v;
    }
}
