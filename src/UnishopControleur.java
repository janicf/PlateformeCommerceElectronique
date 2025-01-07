import java.util.Scanner;
import java.util.List;

public class UnishopControleur {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;
    public static Acheteur acheteur;

    public UnishopControleur(){
        new Initialisation();
        pageAccueil();

        while (!exit){
            afficheCas();
            int cas = choixUtil();

            switch (cas) {
                case 1 -> inscription();
                case 2 -> connection();
                default -> System.out.println("Aucune information pour cette action.");
            }
        }
    }

    private static void pageAccueil(){
        System.out.println("Bienvenue sur Unishop et bonne rentrée!");
    }

    private static void afficheCas(){
        System.out.println("1. Inscription");
        System.out.println("2. Connexion");

    }

    protected static int choixUtil(){
        System.out.println("Entrez votre choix");
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
            return -1;
        }
    }

    private static void inscription(){
        System.out.println("1. Acheteur");
        System.out.println("2. Revendeur");
        int cas = choixUtil();

        switch (cas) {
            case 1 -> ControleurAcheteur.inscriptionAcheteur();
            case 2 -> ControleurRevendeur.inscriptionRevendeur();
            default -> System.out.println("Aucune information pour cette action.");
        }

    }

    private static void connection(){
        System.out.println("1. Acheteur");
        System.out.println("2. Revendeur");
        System.out.println("3. Retour Accueil");
        int cas = choixUtil();

        switch (cas) {
            case 1 -> ControleurAcheteur.connectionAcheteur();
            case 2 -> ControleurRevendeur.connectionRevendeur();
            case 3 -> pageAccueil();
            default -> System.out.println("Aucune information pour cette action.");
        }
    }


    public static void afficherCatalogue(){
        List<Produit> produits = Catalogue.getListeProduits();
        
        if (produits.isEmpty()) {
            System.out.println("Le catalogue est vide.");
            return;
        }

        System.out.println("Liste des Produits Disponibles:");
        for (Produit produit : produits) {
            System.out.println("Titre: " + produit.getTitre());
            System.out.println("Description: " + produit.getDescription());
            System.out.println("Prix: $ " + produit.getPrix());
            System.out.println("Catégorie: " + produit.getCategorie());

            System.out.println("---------------------------------------------------");
        }
    }


    private static void passerCommande(){
        ControleurAcheteur.passerCommande();
    }

    private static void ajouterPanier(){

    }


    private static void recommandationProduit(){

    }


    private static void evaluerProduit(){

    }

    public static void afficherProfilAutreAcheteur() {
        System.out.println("Entrez le pseudo de l'acheteur dont vous souhaitez afficher le profil :");
        String pseudoAcheteur = scanner.nextLine();

        Acheteur autreAcheteur = UnishopControleur.rechercherAcheteurParPseudo(pseudoAcheteur);

        if (autreAcheteur != null) {
            System.out.println("Profil de l'acheteur " + autreAcheteur.getPseudo() + " :");
            System.out.println("Nom : " + autreAcheteur.getNom());
            System.out.println("Prénom : " + autreAcheteur.getPrenom());

            System.out.println("1. Suivre cet acheteur");
            System.out.println("2. Retour");

            int choix = UnishopControleur.choixUtil();

            switch (choix) {
                case 1 -> {
                    suivreAcheteur(autreAcheteur);
                    System.out.println("Vous suivez maintenant " + autreAcheteur.getPseudo());
                }
                case 2 -> System.out.println("Opération annulée.");
                default -> System.out.println("Aucune information pour cette action.");
            }
        } else {
            System.out.println("Aucun acheteur trouvé avec le pseudo " + pseudoAcheteur);
        }
    }


    private static void suivreAcheteur(Acheteur autreAcheteur){
        List<Acheteur> listeSuivi = acheteur.getListeSuivi();
        if (!listeSuivi.contains(autreAcheteur)) {
            acheteur.addListSuivi(autreAcheteur);
            System.out.println("Vous suivez maintenant " + autreAcheteur.getPseudo());
        } else {
            System.out.println("Vous suivez déjà " + autreAcheteur.getPseudo());
        }

    }

    public static Acheteur rechercherAcheteurParPseudo(String pseudo) {
        for (Acheteur acheteur : Initialisation.getListeAcheteurs()) {
            if (acheteur.getPseudo().equalsIgnoreCase(pseudo)) {
                return acheteur;
            }
        }
        return null; // Acheteur non trouvé
    }

    public static void trouverRevendeur(){
        System.out.println("Veuillez entrer le nom du revendeur :");
        String nomRecherche = scanner.nextLine();

        // Effectuez la recherche et affichez le résultat
        boolean revendeurTrouve = false;
        for (Revendeur revendeur : Initialisation.getListeRevendeurs()) {
            if (revendeur.getNom().equalsIgnoreCase(nomRecherche)) {
                revendeurTrouve = true;
                System.out.println("Revendeur trouvé : " + revendeur.getNom());
                System.out.println("Voulez-vous afficher le profil du revendeur?");
                System.out.println("1. Oui");
                System.out.println("2. Non");

                int cas = UnishopControleur.choixUtil();

                if (cas == 1) {
                    afficherProfilRevendeur(revendeur);
                } else {
                    System.out.println("Retour Accueil");
                }
                break;  // Quittez la boucle dès que le revendeur est trouvé
            }
        }

        if (!revendeurTrouve) {
            System.out.println("Aucun revendeur trouvé avec le nom : " + nomRecherche);
        }

    }

     public static void afficherProfilRevendeur(Revendeur revendeur){
        int nombresProduit = revendeur.getProduitsRevendeur().size();
        List<Produit> produits = revendeur.getProduitsRevendeur();
        System.out.println("Profil de l'acheteur " + revendeur.getNom() + " :");
        System.out.println("Le revendeur à " + nombresProduit + "en vente");

        if (produits != null) {
            for(Produit produit : produits){
                System.out.println("Titre " + produit.getTitre() + ":");
                System.out.println("Prix " + produit.getPrix() + ":");
            }
        }

    }

    public static void voirPageProduit() {
        System.out.println("Entrez le titre du produit :");
        String titreProduit = scanner.nextLine();

        Produit produit = rechercherProduitParTitre(titreProduit);

        if (produit != null) {
            afficherDetailsProduit(produit);
        } else {
            System.out.println("Produit non trouvé avec le titre : " + titreProduit);
        }
    }

    private static Produit rechercherProduitParTitre(String titre) {
        for (Produit produit : Catalogue.getListeProduits()) {
            if (produit.getTitre().equalsIgnoreCase(titre)) {
                return produit;
            }
        }
        return null;
    }

    private static void afficherDetailsProduit(Produit produit) {
        System.out.println("Titre: " + produit.getTitre());
        System.out.println("Description: " + produit.getDescription());
        System.out.println("Prix: $ " + produit.getPrix());
        System.out.println("Évaluations: ");

        if (!produit.getEvaluation().isEmpty()) {
            for (EvaluerProduit evaluation : produit.getEvaluation()) {
                System.out.println("Note: " + evaluation.getNote());
                System.out.println("Commentaire: " + evaluation.getCommentaire());
            }
        } else {
            System.out.println("Aucune évaluation disponible pour ce produit.");
        }
    }
            

    private static void afficherPoints(){

    }

    private static void notifications(){

    }

    protected static void deconnexion(){
        Initialisation.sauvegarderAcheteursDansFichier();
        Initialisation.sauvegarderRevendeursDansFichier();
        Initialisation.sauvegarderProduitsDansFichier();
        Initialisation.sauvegarderCommandesDansFichier();
        exit = true;
        System.out.println("Déconnexion réussie");
    }
}


