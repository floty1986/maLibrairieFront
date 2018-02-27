package obj;


import java.util.Date;



public class Commande {
    private int numCommande;
    private int idAdresseFacturation;
    private int idAdresseLivraison;
    private int idClient;
    private Date dateCommande;
    private float fraisPort;
    private String ipClient;
    private String nomStatut;

    public Commande() {
    }

    public Commande(int numCommande, int idAdresseFacturation, int idAdresseLivraison, int idClient, Date dateCommande, float fraisPort, String ipClient, String nomStatut) {
        this.numCommande = numCommande;
        this.idAdresseFacturation = idAdresseFacturation;
        this.idAdresseLivraison = idAdresseLivraison;
        this.idClient = idClient;
        this.dateCommande = dateCommande;
        this.fraisPort = fraisPort;
        this.ipClient = ipClient;
        this.nomStatut = nomStatut;
    }

    public Commande(int numCommande) {
        this.numCommande = numCommande;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(int numCommande) {
        this.numCommande = numCommande;
    }

    public int getIdAdresseFacturation() {
        return idAdresseFacturation;
    }

    public void setIdAdresseFacturation(int idAdresseFacturation) {
        this.idAdresseFacturation = idAdresseFacturation;
    }

    public int getIdAdresseLivraison() {
        return idAdresseLivraison;
    }

    public void setIdAdresseLivraison(int idAdresseLivraison) {
        this.idAdresseLivraison = idAdresseLivraison;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public float getFraisPort() {
        return fraisPort;
    }

    public void setFraisPort(float fraisPort) {
        this.fraisPort = fraisPort;
    }

    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(String ipClient) {
        this.ipClient = ipClient;
    }

    public String getStatut() {
        return nomStatut;
    }

    public void setStatut(String nomStatut) {
        this.nomStatut = nomStatut;
    }

    @Override
    public String toString() {
        return "Commande{" + "numCommande=" + numCommande + ", idAdresseFacturation=" + idAdresseFacturation + ", idAdresseLivraison=" + idAdresseLivraison + ", idClient=" + idClient + ", dateCommande=" + dateCommande + ", fraisPort=" + fraisPort + ", ipClient=" + ipClient + ", nomStatut=" + nomStatut + '}';
    }
    
    
}