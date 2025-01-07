import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    private static List<Produit> listeProduits;


    public Catalogue() {
        Catalogue.listeProduits = new ArrayList<>();
    }
    
    public static List<Produit> getListeProduits() {
        return listeProduits;
    }

    public static void ajouterProduitCatalogue(Produit produit) {
        listeProduits.add(produit);
    }


     public static void afficherCatalogue() {
        System.out.println("Catalogue :");
        for (Produit produit : listeProduits) {
            System.out.println("Titre: " + produit.getTitre());
            System.out.println("Description: " + produit.getDescription());
            System.out.println("Catégorie: " + produit.getCategorie());
            System.out.println("Date de Mise en Vente: " + produit.getDateMiseVente());
            System.out.println("Quantité Initiale: " + produit.getQuantiteInitiale());
            System.out.println("Prix: " + produit.getPrix());
            System.out.println("Point de Base: " + produit.getPointBase());
            System.out.println("Évaluation: " + produit.getEvaluation());
        }
    }

    public static List<Produit> rechercherProduit(String nomProduit) {
        List<Produit> produitsTrouves = new ArrayList<>();

        for (Produit produit : listeProduits) {
            if (produit.getTitre().toLowerCase().contains(nomProduit.toLowerCase())) {
                produitsTrouves.add(produit);
            }
        }

        return produitsTrouves;
    }
}


