package obj;

public class LigneCommande {
    private int idLC;
    private int numCommande;
    private int idOuvrage;
    private float prix;
    private int qteCommandee;
    private float remise;
    private float tvaLC;
    private String titre;

    public LigneCommande() {
    }

    public LigneCommande(int idLC, int numCommande, int idOuvrage, float prix, int qteCommandee, float remise, float tvaLC) {
        this.idLC = idLC;
        this.numCommande = numCommande;
        this.idOuvrage = idOuvrage;
        this.prix = prix;
        this.qteCommandee = qteCommandee;
        this.remise = remise;
        this.tvaLC = tvaLC;
    }

    public LigneCommande(int idLC, int idOuvrage) {
        this.idLC = idLC;
        this.idOuvrage = idOuvrage;
    }

    public LigneCommande(int numCommande) {
        this.numCommande = numCommande;
    }
    
    public LigneCommande(int idLC, int idOuvrage, float prix, int qteCommandee, float remise, float tvaLC) {
        this.idLC = idLC;
        this.idOuvrage = idOuvrage;
        this.prix = prix;
        this.qteCommandee = qteCommandee;
        this.remise = remise;
        this.tvaLC = tvaLC;
    }

    public LigneCommande(String titre, int qteCommandee ) {
        this.titre = titre;
        this.qteCommandee = qteCommandee;
    }

    public LigneCommande(int idLC, int numCommande, int idOuvrage, float prix, int qteCommandee, float remise, float tvaLC, String titre) {
        this.idLC = idLC;
        this.numCommande = numCommande;
        this.idOuvrage = idOuvrage;
        this.prix = prix;
        this.qteCommandee = qteCommandee;
        this.remise = remise;
        this.tvaLC = tvaLC;
        this.titre = titre;
    }
    
    public int getIdLC() {
        return idLC;
    }

    public void setIdLC(int idLC) {
        this.idLC = idLC;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public int getIdOuvrage() {
        return idOuvrage;
    }

    public void setIdOuvrage(int idOuvrage) {
        this.idOuvrage = idOuvrage;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQteCommandee() {
        return qteCommandee;
    }

    public void setQteCommandee(int qteCommandee) {
        this.qteCommandee = qteCommandee;
    }

    public float getRemise() {
        return remise;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public float getTvaLC() {
        return tvaLC;
    }

    public void setTvaLC(float tvaLC) {
        this.tvaLC = tvaLC;
    }

    public void changeQteCommandee( int qteCommandee) {
        this.qteCommandee+= qteCommandee;
    }
    
     public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
    @Override
    public String toString() {
        return "LigneCommande{" + "idLC=" + idLC + ", numCommande=" + numCommande + ", idOuvrage=" + idOuvrage + ", prix=" + prix + ", qteCommandee=" + qteCommandee + ", remise=" + remise + ", tvaLC=" + tvaLC + '}';
    }

   
}