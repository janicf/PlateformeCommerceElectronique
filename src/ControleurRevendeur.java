import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControleurRevendeur {
    private static Scanner scanner = new Scanner(System.in);
    public static Revendeur revendeur;
    public static Revendeur revendeurConnecte;

    public static void inscriptionRevendeur(){
        Revendeur revendeur = new Revendeur();
        Livres livre;
        RessourceApprentissage ressource;
        Papeterie papeterie;
        MaterielInformatique materiel;
        EquipementBureau equipement;

        System.out.println("Entrer Nom:");
        String nom = scanner.nextLine();
        revendeur.setNom(nom);

        System.out.println("Entrer adresse:");
        String adresse = scanner.nextLine();
        revendeur.setAdresse(adresse);

        System.out.println("Entrer adresse courriel:");
        String courriel = scanner.nextLine();
        revendeur.setCourriel(courriel);

        System.out.println("Entrer téléphone:");
        String telephone = scanner.nextLine();
        revendeur.setTelephone(telephone);

        System.out.println("Veuillez choisir une catégorie");
        System.out.println("1. Livre ou manuel");
        System.out.println("2. Ressource d'apprentissage");
        System.out.println("3. Article de papeterie");
        System.out.println("4. Matériel informatique");
        System.out.println("5. Équipement de bureau");

        int cas = UnishopControleur.choixUtil();

        switch (cas) {
            case 1 -> {
                livre = new Livres();
                new Livres(livre);
                Catalogue.ajouterProduitCatalogue(livre);
                revendeur.ajouterProduitsRevendeurs(livre);
            }
            case 2 -> {
                ressource = new RessourceApprentissage();
                new RessourceApprentissage(ressource);
                Catalogue.ajouterProduitCatalogue(ressource);
                revendeur.ajouterProduitsRevendeurs(ressource);
            }
            case 3 -> {
                papeterie = new Papeterie();
                Catalogue.ajouterProduitCatalogue(papeterie);
                revendeur.ajouterProduitsRevendeurs(papeterie);
            }
            case 4 -> {
                materiel = new MaterielInformatique();
                Catalogue.ajouterProduitCatalogue(materiel);
                revendeur.ajouterProduitsRevendeurs(materiel);
            }
            case 5 -> {
                equipement = new EquipementBureau();
                Catalogue.ajouterProduitCatalogue(equipement);
                revendeur.ajouterProduitsRevendeurs(equipement);
            }
            default -> System.out.println("Aucune information pour cette action.");
        }

        System.out.println("Inscription réussie");
        revendeurConnecte = revendeur;
        Initialisation.ajouterRevendeur(revendeur);
        accueilRevendeur();
    }

    public static void ajouterPhotoVid(){
        List<String> photosVidProduit= new ArrayList<>();

        boolean ajouterPhotoVid= true;

        while(ajouterPhotoVid){
            System.out.print("Ajouter une photo ou une vidéo (Oui/Non):");
            String reponse= scanner.nextLine();

            if (reponse.equalsIgnoreCase("Oui")){
                System.out.print("chemin de la photo/video:");
                String cheminPhotoVid=scanner.nextLine();
                photosVidProduit.add(cheminPhotoVid);
            }else if (reponse.equalsIgnoreCase("Non")){
                ajouterPhotoVid= false;
            } else {
                System.out.println("Reponse invalide, repondre par 'Oui'' ou 'Non'");
            }
        }
    }

    public static void connectionRevendeur() {
        System.out.println("Veuillez entrer votre courriel:");
        String courriel = scanner.nextLine();

        System.out.println("Veuillez entrer votre mot de passe:");
        String motDePasse = scanner.nextLine();

        revendeurConnecte = authentifierRevendeur (courriel, motDePasse);
        if (revendeurConnecte != null) {
            System.out.println("Connexion réussie!");
            accueilRevendeur();
        }
        else {
            System.out.println("Connexion échouée. Informations invalides.");
        }
    }

    private static Revendeur authentifierRevendeur(String courriel, String motDePasse){
        for (Revendeur revendeur : Initialisation.getListeRevendeurs()){
            if (revendeur.getCourriel().equals(courriel) && revendeur.getMotDePasse().equals(motDePasse)) {
                revendeur.connection();
                return revendeur;
            }
        }
        return null;
    }

    private static void accueilRevendeur(){
        revendeurConnecte.getMetriquesRevendeur().metriquesAccueil();

        System.out.println("1. Afficher Profil");
        System.out.println("2. Offrir un Produit");
        System.out.println("3. Offrir une Promotion");
        System.out.println("4. Voir notifications");
        System.out.println("5. Gérer produits");
        System.out.println("6. Déconnexion");

        int cas = UnishopControleur.choixUtil();

        switch (cas) {
            case 1 -> profilRevendeur();
            case 2 -> offrirProduit();
            case 3 -> offrirPromotion();
            case 4 -> voirNotifications();
            case 5 -> gestionProduits();
            case 6 -> UnishopControleur.deconnexion();
            default -> System.out.println("Aucune information pour cette action.");
        }

    }

    private static void profilRevendeur(){
        System.out.println("1. Gestion commande ");
        System.out.println("2. Afficher métriques");
        System.out.println("3. Gestion remboursement");
        System.out.println("4. Voir évaluations produits");
        System.out.println("5. Modifier profil");
        System.out.println("6. Retour Accueil");
        System.out.println("7. Déconnexion");

        int cas = UnishopControleur.choixUtil();

        switch (cas) {
            case 1 -> gestionCommandeRevendeur();
            case 2 -> metriquesRevendeur();
            case 3 -> gestionRemboursementRevendeur();
            case 4 -> voirEvaluationsProduits();
            case 5 -> modifierProfilRevendeur();
            case 6 -> accueilRevendeur();
            case 7 -> UnishopControleur.deconnexion();
            default -> System.out.println("Aucune information pour cette action.");
        }
    }

    private static void modifierProfilRevendeur(){
        System.out.println("Que souhaitez-vous modifier ?");
        System.out.println("1. Nom");
        System.out.println("2. Adresse");
        System.out.println("3. Courriel");
        System.out.println("4. Téléphone");

        int choix = UnishopControleur.choixUtil();

        switch (choix) {
            case 1 -> {
                System.out.println("Nouveau Nom :");
                String nouveauNom = scanner.nextLine();
                revendeurConnecte.setNom(nouveauNom);
            }
            case 2 -> {
                System.out.println("Nouvelle Adresse :");
                String nouvelleAdresse = scanner.nextLine();
                revendeurConnecte.setAdresse(nouvelleAdresse);
            }
            case 3 -> {
                System.out.println("Nouveau Courriel :");
                String nouveauCourriel = scanner.nextLine();
                revendeurConnecte.setCourriel(nouveauCourriel);
            }
            case 4 -> {
                System.out.println("Nouveau Téléphone :");
                String nouveauTelephone = scanner.nextLine();
                revendeurConnecte.setTelephone(nouveauTelephone);
            }
            default -> System.out.println("Aucune information pour cette action.");
        }

        System.out.println("Profil mis à jour avec succès.");
    }


    private static void metriquesRevendeur(){
        revendeurConnecte.getMetriquesRevendeur().metriquesProfil();
    }

    private static void gestionCommandeRevendeur(){
        System.out.println("1.Effectuer un remboursement");
        System.out.println("2.Envoyer un produit de remplacement");
        System.out.println("3.Retour à l'accueil");

        int choix =UnishopControleur.choixUtil();
        switch (choix) {
            case 1:
                gestionRemboursementRevendeur();
                break;
            case 2:
                envoyerProduitRemplacement();
                break;
            case 3:
                accueilRevendeur();
                break;
            default:
                System.out.println("Entrer un choix.");
        }

    }

    private static void gestionRemboursementRevendeur(){
        System.out.println("Liste des commandes récentes : ");
        List<Commande> commandes = revendeurConnecte.getCommandes();

        for(Commande commande : commandes){
            System.out.println(commande.getNumeroCommande());
        }

        System.out.print("Numéro de commande pour le remboursement : ");
        int numeroCommande = scanner.nextInt();
        scanner.nextLine();

        Commande commande = trouverCommandeParNumero(numeroCommande);

        if (commande != null && !commande.isRembourser()) {
            // implementer la logic de remboursement
            faireRemboursement(commande);
        } else if (commande == null) {
            System.out.println("Numéro de commande incorrecte. Veuillez vérifier le numéro de commande.");
        } else {
            System.out.println("La commande a déjà été remboursée.");
        }

    }

    private static void faireRemboursement(Commande commande) {
        // logic de remboursement, changer le status de la commande
        commande.setRemboursement(true);

        System.out.println("Remboursement effectué avec succès " + commande.getNumeroCommande());
    }

    public static void voirEvaluationsProduits(){
        List<Produit> produits = revendeurConnecte.getProduitsRevendeur();

        try {
            for (Produit produit : produits){
                System.out.println("Nom du produit :" + produit.getTitre());
                List<EvaluerProduit> evaluations = produit.getEvaluation();

                for (EvaluerProduit evaluation : evaluations){
                    System.out.println(evaluation.toString());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("La liste de produit est vide");
        }
    }

    private static void offrirProduit(){
        Livres livre;
        RessourceApprentissage ressource;
        Papeterie papeterie;
        MaterielInformatique materiel;
        EquipementBureau equipement;

        System.out.println("Veuillez choisir une catégorie");
        System.out.println("1. Livre ou manuel");
        System.out.println("2. Ressource d'apprentissage");
        System.out.println("3. Article de papeterie");
        System.out.println("4. Matériel informatique");
        System.out.println("5. Équipement de bureau");

        int cas = UnishopControleur.choixUtil();

        switch (cas) {
            case 1 -> {
                livre = new Livres();
                Catalogue.ajouterProduitCatalogue(livre);
                revendeurConnecte.ajouterProduitsRevendeurs(livre);
            }
            case 2 -> {
                ressource = new RessourceApprentissage();
                Catalogue.ajouterProduitCatalogue(ressource);
                revendeurConnecte.ajouterProduitsRevendeurs(ressource);
            }
            case 3 -> {
                papeterie = new Papeterie();
                Catalogue.ajouterProduitCatalogue(papeterie);
                revendeurConnecte.ajouterProduitsRevendeurs(papeterie);
            }
            case 4 -> {
                materiel = new MaterielInformatique();
                Catalogue.ajouterProduitCatalogue(materiel);
                revendeurConnecte.ajouterProduitsRevendeurs(materiel);
            }
            case 5 -> {
                equipement = new EquipementBureau();
                Catalogue.ajouterProduitCatalogue(equipement);
                revendeurConnecte.ajouterProduitsRevendeurs(equipement);
            }
            default -> System.out.println("Aucune information pour cette action.");
        }

        System.out.println("Votre produit à été ajouté!");
        System.out.println("Retour à l'accueil");
        accueilRevendeur();
    }

     public static void gestionProduits(){
        List<Produit> produits = revendeurConnecte.getProduitsRevendeur();

        if (!produits.isEmpty()) {
            afficherProduitRevendeur(produits);

            System.out.print("Veuillez entrer le numéro du produit que vous souhaitez gérer : ");
            int numeroProduit = scanner.nextInt();

            if (numeroProduit >= 1 && numeroProduit <= produits.size()) {
                Produit produitChoisi = produits.get(numeroProduit - 1);
                System.out.println("Vous avez choisi le produit : " + produitChoisi.getTitre());

                System.out.println("Menu de gestion des produits :");
                System.out.println("1. Changer le prix d'un produit");
                System.out.println("2. Changer la quantité d'un produit");
                System.out.println("3. Supprimer un produit");
                System.out.println("4. Quitter le menu");

                System.out.print("Veuillez choisir une option : ");
                int cas = UnishopControleur.choixUtil();

                switch (cas) {
                    case 1:
                        System.out.println("Entrez le nouveau prix");
                        float prix = scanner.nextFloat();
                        produitChoisi.setPrix(prix);
                        break;
                    case 2:
                        System.out.println("Entrez la nouvelle quantité");
                        int quantite = scanner.nextInt();
                        produitChoisi.setQuantiteInitiale(quantite);
                        break;
                    case 3:
                        produits.remove(produitChoisi);
                        Catalogue.getListeProduits().remove(produitChoisi);
                        break;
                    case 4:
                        System.out.println("Menu quitté.");
                        break;
                    default:
                        System.out.println("Option invalide.");
                        break;
                }

            } else {
                System.out.println("Numéro de produit invalide.");
            }
        }
    }

    public static void afficherProduitRevendeur(List<Produit> produits){
        System.out.println("Liste des produits disponibles :");
        for (int i = 0; i < produits.size(); i++) {
            Produit produit = produits.get(i);
            System.out.println((i + 1) + ". " + produit.getTitre());
        }
    }

    public void resoudreProblemeAcheteur(int numProb, String solution) {
        GestionProblemes gestionProblemes = new GestionProblemes();
        gestionProblemes.resoudreProbleme(numProb, solution);
    }

    public void confirmerReceptionRetour(Commande retourCommande) {
        if (retourCommande != null && retourCommande.isRetourRecu()) {
            System.out.println("Retour de la commande" + retourCommande.getNumeroCommande() + "a deja été confirmé.");
        } else if (retourCommande != null) {
            retourCommande.setRetourRecu(true);
            System.out.println("Retour de la commande" + retourCommande.getNumeroCommande() + "a été confirmé. L'etat du retour est maintenant 'livré'.");
        } else {
            System.out.println("Commande de retour introuvable. Veuillez verifier le numero de la commande.");
        }
    }

    private static void offrirPromotion(){

    }

    public void envoyerNotification(String message){
        NotificationRevendeur notification = new NotificationRevendeur (revendeur, message);
        revendeur.getNotifications().add(notification);
        notification.envoyerNotification();
    }

    public static void voirNotifications(){
        List<NotificationRevendeur> notifications = revendeurConnecte.getNotifications();
        for(NotificationRevendeur notification: notifications){
            System.out.println(notification.getMessage());
        }
    }

    public void nouvelleCommande (Produit produit, int numeroCommande){
        String message= "Nouvelle commande pour le produit " + produit.getTitre() + ". Numéro de commande : " + numeroCommande;
        envoyerNotification(message);
    }

    public void evaluationProduit (Produit produit, EvaluerProduit evaluation){
        String message= "Nouvelle évaluation pour le produit " + produit.getTitre() + ". Note : " + evaluation.getNote() + "/5. Commentaire : " + evaluation.getCommentaire();
        envoyerNotification(message);
    }

    public void signalerProbleme (Acheteur acheteur, Produit produit){
        String message= "L'acheteur' " + acheteur.getPseudo() + " a signalé un problème avec le produit " + produit.getTitre();
        envoyerNotification(message);
    }

    public static void modifierEtatCommandeRevendeur() {
        System.out.println("Veuillez entrer le numéro de la commande que vous souhaitez modifier : ");
        int numeroCommande = UnishopControleur.choixUtil();

        // Rechercher la commande par son numéro
        Commande commande = trouverCommandeParNumero(numeroCommande);

        if (commande != null) {
            System.out.println("État actuel de la commande : " + commande.getEtat());
            System.out.println("Veuillez entrer le nouvel état de la commande : ");
            String nouvelEtat = scanner.nextLine();

            // Modifier l'état de la commande
            commande.setEtat(nouvelEtat);

            System.out.println("État de la commande modifié avec succès.");
        } else {
            System.out.println("Aucune commande trouvée avec le numéro : " + numeroCommande);
        }
    }

    
    private static Commande trouverCommandeParNumero(int numeroCommande) {
        // Vous devez implémenter la logique pour rechercher la commande par son numéro
        // dans la liste des commandes du revendeur connecté (revendeurConnecte)
        List<Commande> commandes = revendeurConnecte.getCommandes();
        for (Commande commande : commandes) {
            if (commande.getNumeroCommande() == numeroCommande) {
                return commande;
            }
        }
        return null; // Commande non trouvée
    }

    private static void envoyerProduitRemplacement() {
        System.out.println("Liste des commandes avec problèmes : ");
        List<Commande> commandes = revendeurConnecte.getCommandes();

        // Afficher les commandes ayant des problèmes
        for (Commande commande : commandes) {
            if (commande.getProbleme() != null) {
                System.out.println("Commande N°" + commande.getNumeroCommande());
                System.out.println("Problème signalé: " + commande.getProbleme().getDescription());
            }
        }

        // Sélectionner la commande pour envoyer un produit de remplacement
        System.out.print("Numéro de la commande pour envoyer un produit de remplacement : ");
        int numeroCommande = scanner.nextInt();
        scanner.nextLine();

        Commande commande = trouverCommandeParNumero(numeroCommande);

        if (commande != null && commande.getProbleme() != null) {
            // Logique pour expédier le produit de remplacement
            System.out.println("Expédition du produit de remplacement pour la commande N°" + commande.getNumeroCommande());
            commande.setProbleme(null); // Marquer le problème comme résolu
        } else {
            System.out.println("Commande non trouvée ou sans problème signalé.");
        }
    }  

}


