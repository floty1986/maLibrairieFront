
package obj;

import java.io.Serializable;

public class Adresse implements Serializable {
   
   private int idAdresse;
   private int idClientCreer;
   private int idClientUtiliser;
   private String typeAdresse;
   private String numVoie;
   private String typeVoie;
   private String nomVoie;
   private String complement;
   private String codePostal;
   private String ville;
   private String pays;
   private String nom;
   private String prenom;
   private String email;
   private String telephone;
   private String nomStatut;

    public Adresse() {
    }

    public Adresse(int idAdresse, int idClientCreer, int idClientUtiliser, String typeAdresse, String numVoie, String typeVoie, String nomVoie, String complement, String codePostal, String ville, String pays, String nom, String prenom, String email, String telephone, String nomStatut) {
        this.idAdresse = idAdresse;
        this.idClientCreer = idClientCreer;
        this.idClientUtiliser = idClientUtiliser;
        this.typeAdresse = typeAdresse;
        this.numVoie = numVoie;
        this.typeVoie = typeVoie;
        this.nomVoie = nomVoie;
        this.complement = complement;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.nomStatut = nomStatut;
    }
    
    
   

    @Override
    public String toString() {
        return "Adresse{" + "idAdresse=" + idAdresse + ", idClientCreer=" + idClientCreer + ", idClientUtiliser=" + idClientUtiliser + ", typeAdresse=" + typeAdresse + ", numVoie=" + numVoie + ", typeVoie=" + typeVoie + ", nomVoie=" + nomVoie + ", complement=" + complement + ", codePostal=" + codePostal + ", ville=" + ville + ", pays=" + pays + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone=" + telephone + ", nomStatut=" + nomStatut + '}';
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public int getIdClientCreer() {
        return idClientCreer;
    }

    public void setIdClientCreer(int idClientCreer) {
        this.idClientCreer = idClientCreer;
    }

    public int getIdClientUtiliser() {
        return idClientUtiliser;
    }

    public void setIdClientUtiliser(int idClientUtiliser) {
        this.idClientUtiliser = idClientUtiliser;
    }

    public String getTypeAdresse() {
        return typeAdresse;
    }

    public void setTypeAdresse(String typeAdresse) {
        this.typeAdresse = typeAdresse;
    }

    public String getNumVoie() {
        return numVoie;
    }

    public void setNumVoie(String numVoie) {
        this.numVoie = numVoie;
    }

    public String getTypeVoie() {
        return typeVoie;
    }

    public void setTypeVoie(String typeVoie) {
        this.typeVoie = typeVoie;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNomStatut() {
        return nomStatut;
    }

    public void setNomStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }
}
