import java.util.ArrayList;
import java.util.List;


public class Revendeur extends Utilisateur {
    private static MetriquesRevendeur metriquesRevendeur;
    private List<NotificationRevendeur> notifications;
    private static List<Produit> produitsRevendeur;
    private List<Commande> commandes;
    private int likes;

    public Revendeur() {
        setNom("");
        setCourriel("");
        setTelephone("");
        setAdresse("");
        setMotDePasse("");
        metriquesRevendeur = new MetriquesRevendeur();
        notifications = new ArrayList<>();
        produitsRevendeur = new ArrayList<>();
        this.likes = 0;
    }

    public Revendeur(String nom, String courriel, String telephone, String adresse, String motDePasse) {
        setNom(nom);
        setCourriel(courriel);
        setTelephone(telephone);
        setAdresse(adresse);
        setMotDePasse(motDePasse);
        metriquesRevendeur = new MetriquesRevendeur();
        notifications = new ArrayList<>();
        produitsRevendeur = new ArrayList<>();
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public MetriquesRevendeur getMetriquesRevendeur() {
        return metriquesRevendeur;
    }

    public List<NotificationRevendeur> getNotifications() {
        return notifications;
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

     public int getLikes() {
        return likes;
    }

    public void liker() {
        likes++;
        System.out.println("Nombre total de likes : " + likes);
    }

    public List<Produit> getProduitsRevendeur() {
        return produitsRevendeur;
    }

    public static void ajouterProduitsRevendeurs(Produit produit){
        produitsRevendeur.add(produit);
    }
}
