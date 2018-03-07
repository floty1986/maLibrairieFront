package obj;

import java.sql.Date;
import java.util.Vector;

public class Auteur {
    private int idAuteur;
    private String nom;
    private String prenom;
    private String nationalite;
    private String langue;
    private Date dateNaissance;
    private Date dateDeces;
    private String descriptionAuteur;
    private String imageAuteur;
    private String status;

    public Auteur() {
    }

    public Auteur(int idAuteur, String nom, String prenom, String nationalite, String langue, Date dateNaissance, Date dateDeces, String descriptionAuteur, String imageAuteur, String status) {
        this.idAuteur = idAuteur;
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.langue = langue;
        this.dateNaissance = dateNaissance;
        this.dateDeces = dateDeces;
        this.descriptionAuteur = descriptionAuteur;
        this.imageAuteur = imageAuteur;
        this.status = status;
    }

    public Auteur(String nom, String prenom, String nationalite, String langue, Date dateNaissance, Date dateDeces, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.nationalite = nationalite;
        this.langue = langue;
        this.dateNaissance = dateNaissance;
        this.dateDeces = dateDeces;
        this.status = status;
    }


    public int getIdAuteur() {
        return idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public String getDescriptionAuteur() {
        return descriptionAuteur;
    }

    public void setDescriptionAuteur(String descriptionAuteur) {
        this.descriptionAuteur = descriptionAuteur;
    }

    public String getImageAuteur() {
        return imageAuteur;
    }

    public void setImageAuteur(String imageAuteur) {
        this.imageAuteur = imageAuteur;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Vector<Auteur> getVector() {
        Vector v = new Vector();
        v.add(this.nom);
        v.add(this.prenom);
        v.add(this.nationalite);
        v.add(this.langue);
        v.add(this.dateNaissance);
        v.add(this.dateDeces);
        v.add(this.status);
        return v;
    }
    
}
