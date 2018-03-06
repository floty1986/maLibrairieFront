package obj;

import java.util.Date;
import java.util.Vector;

public class Evenement {
    private int idEvenement;
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private String descriptif;
    private float remise;
    private String imageEvenement;
    private String statut;

    public Evenement() {
    }

    public Evenement(int idEvenement, String nom, Date dateDebut, Date dateFin, String descriptif, float remise, String imageEvenement, String statut) {
        this.idEvenement = idEvenement;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.descriptif = descriptif;
        this.remise = remise;
        this.imageEvenement = imageEvenement;
        this.statut = statut;
    }

    public Evenement(int idEvenement, String nom, Date dateFin, String descriptif) {
        this.idEvenement = idEvenement;
        this.nom = nom;
        this.dateFin = dateFin;
        this.descriptif = descriptif;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public String getImageEvenement() {
        return imageEvenement;
    }

    public void setImageEvenement(String imageEvenement) {
        this.imageEvenement = imageEvenement;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    public Vector<Evenement> getVector() {
        Vector v = new Vector();
        v.add(this.idEvenement);
        v.add(this.nom);
        v.add(this.dateDebut);
        v.add(this.dateFin);
        v.add(this.descriptif);
        v.add(this.remise);
        v.add(this.imageEvenement);
        v.add(this.statut);
        return v;
    }
    
}
