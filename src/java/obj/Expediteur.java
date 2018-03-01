package obj;

public class Expediteur {
    private int idExpediteur;
    private String nom;

    public Expediteur() {
    }

    public Expediteur(int idExpediteur, String nom) {
        this.idExpediteur = idExpediteur;
        this.nom = nom;
    }

    public int getIdExpediteur() {
        return idExpediteur;
    }

    public void setIdExpediteur(int idExpediteur) {
        this.idExpediteur = idExpediteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
    
}
