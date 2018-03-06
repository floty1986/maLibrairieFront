package obj;

import java.util.Vector;

public class Ouvrage {
    private int idOuvrage;
    private int idSousTheme;
    private String titre;
    private String sousTitre;
    private float prix;
    private String resumeOuvrage;
    private float poids;
    private int nbPages;
    private int qteStockee;
    private String imageOuvrage;
    private String statut;
    private String theme;
    private String sousTheme;
    private int qtePanier;

    public Ouvrage() {
    }

    public Ouvrage(int idOuvrage, String titre) {
        this.idOuvrage = idOuvrage;
        this.titre = titre;
    }

    public Ouvrage(int idOuvrage, int qtePanier) {
        this.idOuvrage = idOuvrage;
        this.qtePanier = qtePanier;
    }

    public Ouvrage(int idOuvrage, String titre, int qtePanier) {
        this.idOuvrage = idOuvrage;
        this.titre = titre;
        this.qtePanier = qtePanier;
    }

    public Ouvrage(int idOuvrage, String titre, String imageOuvrage) {
        this.idOuvrage = idOuvrage;
        this.titre = titre;
        this.imageOuvrage = imageOuvrage;
    }

    public Ouvrage(int idOuvrage, String titre, String imageOuvrage, int qtePanier) {
        this.idOuvrage = idOuvrage;
        this.titre = titre;
        this.imageOuvrage = imageOuvrage;
        this.qtePanier = qtePanier;
    }
    
    
    

    public int getIdOuvrage() {
        return idOuvrage;
    }

    public void setIdOuvrage(int idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public int getIdSousTheme() {
        return idSousTheme;
    }

    public void setIdSousTheme(int idSousTheme) {
        this.idSousTheme = idSousTheme;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getResumeOuvrage() {
        return resumeOuvrage;
    }

    public void setResumeOuvrage(String resumeOuvrage) {
        this.resumeOuvrage = resumeOuvrage;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public int getQteStockee() {
        return qteStockee;
    }

    public void setQteStockee(int qteStockee) {
        this.qteStockee = qteStockee;
    }

    public String getImageOuvrage() {
        return imageOuvrage;
    }

    public void setImageOuvrage(String imageOuvrage) {
        this.imageOuvrage = imageOuvrage;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getSousTheme() {
        return sousTheme;
    }

    public void setSousTheme(String sousTheme) {
        this.sousTheme = sousTheme;
    }

    public int getQtePanier() {
        return qtePanier;
    }

    public void setQtePanier(int qtePanier) {
        this.qtePanier = qtePanier;
    }

    
    
    public Vector<Ouvrage> getVector() {
        Vector v = new Vector();
        v.add(this.idOuvrage);
        v.add(this.titre);
        return v;
    }

   
    @Override
    public String toString() {
        return "[" + idOuvrage + "*" + titre + "*" + qtePanier + "]";
    }
  
    
    public void changeQty( int qty) {
        this.qtePanier+= qty;
    }
}
