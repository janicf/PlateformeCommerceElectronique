import java.util.ArrayList;
import java.util.List;


public class Acheteur extends Utilisateur {

    private String prenom;
    private String pseudo;
    private int suiveur;
    private MetriquesAcheteur metriquesAcheteur ;
    private List<NotificationAcheteur> notifications;
    private int pointsFidelite;
    private static List<Commande> listeCommandes;
    private PanierAchat panierAchat;
    private List<Acheteur> listeSuivi;

    public Acheteur() {
        setNom("");
        setPrenom("");
        setPseudo("");
        setCourriel("");
        setTelephone("");
        setAdresse("");
        setMotDePasse("");
        setSuiveur(0);
        pointsFidelite = 0;
        metriquesAcheteur = new MetriquesAcheteur();
        notifications = new ArrayList<>();
        panierAchat = new PanierAchat();
        listeSuivi = new ArrayList<>();
    }

    public Acheteur(String nom, String prenom, String pseudo, String courriel, String telephone, String adresse,
                    String motDePasse) {
        setNom(nom);
        setPrenom(prenom);
        setPseudo(pseudo);
        setCourriel(courriel);
        setTelephone(telephone);
        setAdresse(adresse);
        setMotDePasse(motDePasse);
        this.setSuiveur(0);
        pointsFidelite = 0;
        metriquesAcheteur = new MetriquesAcheteur();
        notifications = new ArrayList<>();
        panierAchat = new PanierAchat();
        listeSuivi = new ArrayList<>();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getSuiveur() {
        return suiveur;
    }

    public void setSuiveur(int suiveur) {
        this.suiveur = suiveur;
    }

    public void incrementerSuiveur(Acheteur acheteur) {
        acheteur.suiveur++;
    }

    public MetriquesAcheteur getMetriquesAcheteur() {
        return metriquesAcheteur;
    }

    public int getpointsFidelite(){
        return pointsFidelite;
    }

    public void setpointsFidelite(int pointsFidelite){
        this.pointsFidelite = pointsFidelite;
    }

    public static List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public List<NotificationAcheteur> getNotifications() {
        return notifications;
    }

    public List<Acheteur> getListeSuivi() {
        return listeSuivi;
    }
    
    public void addListSuivi(Acheteur acheteur){
        listeSuivi.add(acheteur);
    }

    private boolean connected = false;
    
    public boolean isConnected(){
        return connected;
    }
    public void setConnected(boolean connected){
        this.connected = connected;
    }
    public void connection(){
        connected = true;
    }

    public void likerRevendeur(Revendeur revendeur) {
        revendeur.liker();
        System.out.println("Vous avez liké le revendeur " + revendeur.getNom() + " avec succès.");
    }

    public void likerProduit (Produit produit) {
        produit.likerProduit();
        System.out.println("Vous avez liké le produit: " + produit.getTitre() + ".");
    }
    
}
