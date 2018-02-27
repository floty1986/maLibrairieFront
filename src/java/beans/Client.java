package beans;

import java.io.Serializable;
import java.util.Date;

public class Client implements Serializable {
    private int idClient;
    private String nom;
    private String prenom;
    private String genre;
    private Date dateNaissance;
    private String email;
    private String telephone;
    private String motDePasse;
    private String nomStatut;
    
    public Client() {
    }

    public int getIdClient() {
        return idClient;
    }
    
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGenre() {
        return genre;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    
    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNomStatut() {
        return nomStatut;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
    
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }
    
    
    
}
