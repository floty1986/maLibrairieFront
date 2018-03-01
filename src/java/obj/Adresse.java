
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
}
