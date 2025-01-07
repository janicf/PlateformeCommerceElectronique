import java.util.ArrayList;
import java.util.List;

public class PanierAchat {
    private static List<Produit> listeProduits;

    public PanierAchat() {
        PanierAchat.listeProduits = new ArrayList<>();
    }

    public static void ajouterAuPanier(Produit produit, int quantite) {
        // Vérifier si le produit est déjà dans le panier
        boolean produitExistant = false;

        for (Produit p : listeProduits) {
            if (p.equals(produit)) {
                p.setQuantiteInitiale(p.getQuantiteInitiale() + quantite);
                produitExistant = true;
                break;
            }
        }

        // Si le produit n'est pas déjà dans le panier, l'ajouter
        if (!produitExistant) {
            listeProduits.add(produit);
        }

        System.out.println("Produit ajouté au panier.");
    }

    public void retirerDuPanier(Produit produit, int quantite) {
        for (Produit p : listeProduits) {
            if (p.equals(produit)) {
                int nouvelleQuantite = p.getQuantiteInitiale() - quantite;

                if (nouvelleQuantite > 0) {
                    p.setQuantiteInitiale(nouvelleQuantite);
                    System.out.println("Quantité du produit mise à jour dans le panier.");
                } else {
                    listeProduits.remove(p);
                    System.out.println("Produit retiré du panier car la quantité est nulle.");
                }

                return;
            }
        }

        System.out.println("Le produit n'est pas dans le panier.");
    }

    public static void viderPanier() {
        listeProduits.clear();
        System.out.println("Panier vidé.");
    }

    public static void afficherPanier() {
        if (listeProduits.isEmpty()) {
            System.out.println("Le panier est vide.");
        } else {
            System.out.println("Contenu du panier :");
            for (Produit p : listeProduits) {
                System.out.println("- " + p.getTitre() + " : " + p.getQuantiteInitiale() + " unité(s)");
            }
        }
    }
    
    //liste les produits dans le panier d'achat
    public static String getListeProduits() {
        StringBuilder dansPanier = new StringBuilder();
        if (listeProduits.isEmpty()){
            dansPanier.append("Le panier est vide");
        }
        else{
            dansPanier.append("Produits dans le panier: \n");
            for (Produit p: listeProduits){
                dansPanier.append("- ").append(p.getTitre()).append(p.getQuantiteInitiale()).append("unité(s)\n");
            }
        }
    return dansPanier.toString();
    }
}
