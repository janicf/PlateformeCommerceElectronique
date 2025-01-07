import java.util.List;
import java.util.Scanner;

public class ControleurAcheteur {
    private static Scanner scanner = new Scanner(System.in);
    public static Acheteur acheteur;
    public static Acheteur acheteurConnecte;

    public static void inscriptionAcheteur() {
        Acheteur acheteur = new Acheteur();

        System.out.println("Entrer Nom");
        String nom = scanner.nextLine();
        acheteur.setNom(nom);

        System.out.println("Entrer Prénom");
        String prenom = scanner.nextLine();
        acheteur.setPrenom(prenom);

        System.out.println("Entrer pseudo");
        String pseudo = scanner.nextLine();
        acheteur.setPseudo(pseudo);

        System.out.println("Entrer courriel");
        String courriel = scanner.nextLine();
        acheteur.setCourriel(courriel);

        System.out.println("Entrer telephone");
        String telephone = scanner.nextLine();
        acheteur.setTelephone(telephone);

        System.out.println("Entrer adresse");
        String adresse = scanner.nextLine();
        acheteur.setAdresse(adresse);

        System.out.println("Entrer mot de passe");
        String motDePasse = scanner.nextLine();
        acheteur.setMotDePasse(motDePasse);

        System.out.println("Inscription réussie");
        acheteurConnecte = acheteur;
        Initialisation.ajouterAcheteur(acheteur);
        accueilAcheteur();
    }

    public static void connectionAcheteur() {
        System.out.println("Veuillez entrer votre pseudo");
        String pseudo = scanner.nextLine();

        System.out.println("Veuillez entrer votre mot de passe:");
        String motDePasse = scanner.nextLine();

        acheteurConnecte = authentifierAcheteur(pseudo, motDePasse);
        if (acheteurConnecte != null) {
            System.out.println("Connexion réussie!");
            accueilAcheteur();
        } else {
            System.out.println("Connexion échouée. Informations invalides.");
        }
    }

    private static Acheteur authentifierAcheteur(String pseudo, String motDePasse) {
        for (Acheteur acheteur : Initialisation.getListeAcheteurs()) {
            if (acheteur.getPseudo().equals(pseudo) && acheteur.getMotDePasse().equals(motDePasse)) {
                acheteur.connection();
                return acheteur;
            }
        }
        return null;
    }

    public static void accueilAcheteur() {
        acheteurConnecte.getMetriquesAcheteur().metriquesAccueil();

        System.out.println("1. Recherche Produit");
        System.out.println("2. Afficher Catalogue");
        System.out.println("3. Afficher Profil");
        System.out.println("4. Afficher Panier");
        System.out.println("5. Trouver revendeur");
        System.out.println("6. Liker revendeur");
        System.out.println("7. Liker un produit");
        System.out.println("8. Trouver acheteur");
        System.out.println("9. Déconnexion");

        int cas = UnishopControleur.choixUtil();

        switch (cas) {
            case 1 -> rechercheProduit();
            case 2 -> Catalogue.afficherCatalogue();
            case 3 -> profilAcheteur();
            case 4 -> PanierAchat.afficherPanier();
            case 5 -> UnishopControleur.trouverRevendeur();
            case 6 -> likerRevendeur();
            case 7 -> likerProduit();
            case 8 -> UnishopControleur.afficherProfilAutreAcheteur();
            case 9 -> UnishopControleur.deconnexion();
            default -> System.out.println("Aucune information pour cette action.");
        }

        if (cas != 6) {
            accueilAcheteur();
        }
    }

    private static void profilAcheteur() {
        System.out.println("Bienvenue sur votre profil");

        System.out.println("1. Signaler problème");
        System.out.println("2. Échange/retour");
        System.out.println("3. Afficher métriques");
        System.out.println("4. Suivre état commande");
        System.out.println("5. Voir notifications");
        System.out.println("6. Historique commande");
        System.out.println("7. Modifier profil");
        System.out.println("8. Gérer suiveur");
        System.out.println("9. Voir mes points de fidélité ");
        System.out.println("10. Retour Accueil");
        System.out.println("11. Déconnexion");

        int cas = UnishopControleur.choixUtil();

        switch (cas) {
            case 1 -> signalerProbleme();
            case 2 -> echangeProduit();
            case 3 -> metriquesAcheteur();
            case 4 -> suivreEtatCommande();
            case 5 -> voirNotification();
            case 6 -> commandePasse();
            case 7 -> modifierProfilAcheteur();
            case 8 -> gestionSuiveur();
            case 9 -> voirPointsFidelite();
            case 10 -> accueilAcheteur();
            case 11 -> UnishopControleur.deconnexion();
            default -> System.out.println("Aucune information pour cette action.");
        }
    }

    private static void modifierProfilAcheteur() {
        System.out.println("Que souhaitez-vous modifier ?");
        System.out.println("1. Nom");
        System.out.println("2. Prénom");
        System.out.println("3. Pseudo");
        System.out.println("4. Courriel");
        System.out.println("5. Téléphone");
        System.out.println("6. Adresse");
        System.out.println("7. Mot de passe");

        int choix = UnishopControleur.choixUtil();

        switch (choix) {
            case 1 -> {
                System.out.println("Nouveau Nom :");
                String nouveauNom = scanner.nextLine();
                acheteurConnecte.setNom(nouveauNom);
            }
            case 2 -> {
                System.out.println("Nouveau Prénom :");
                String nouveauPrenom = scanner.nextLine();
                acheteurConnecte.setPrenom(nouveauPrenom);
            }
            case 3 -> {
                System.out.println("Nouveau Pseudo :");
                String nouveauPseudo = scanner.nextLine();
                acheteurConnecte.setPseudo(nouveauPseudo);
            }
            case 4 -> {
                System.out.println("Nouveau Courriel :");
                String nouveauCourriel = scanner.nextLine();
                acheteurConnecte.setCourriel(nouveauCourriel);
            }
            case 5 -> {
                System.out.println("Nouveau Téléphone :");
                String nouveauTelephone = scanner.nextLine();
                acheteurConnecte.setTelephone(nouveauTelephone);
            }
            case 6 -> {
                System.out.println("Nouvelle Adresse :");
                String nouvelleAdresse = scanner.nextLine();
                acheteurConnecte.setAdresse(nouvelleAdresse);
            }
            case 7 -> {
                System.out.println("Nouveau Mot de passe :");
                String nouveauMotDePasse = scanner.nextLine();
                acheteurConnecte.setMotDePasse(nouveauMotDePasse);
            }
            default -> System.out.println("Aucune information pour cette action.");
        }

        System.out.println("Profil mis à jour avec succès.");

    }

    private static void metriquesAcheteur() {
        acheteurConnecte.getMetriquesAcheteur().metriquesProfil();
    }

    public static void signalerProbleme() {
        System.out.println("Veuillez entrée le numéro de la commande");
        int numCommande = scanner.nextInt();
        System.out.println("Veuillez indiqué le problème");
        String description = scanner.nextLine();
        List<Commande> listeCommandes = acheteurConnecte.getListeCommandes();

        if (listeCommandes != null) {
            Commande commande = rechercherCommandeParNumero(numCommande, listeCommandes);
            if (commande != null) {
                Probleme probleme = new Probleme(numCommande, description);
                commande.setProbleme(probleme);
                System.out.println("Problème signalé avec succès pour la commande " + numCommande);
            }
        }
    }

    public static Commande rechercherCommandeParNumero(int numeroCommande, List<Commande> listeCommandes) {
        for (Commande commande : listeCommandes) {
            if (commande.getNumeroCommande() == numeroCommande) {
                return commande;
            }
        }
        return null; // Aucune commande trouvée avec le numéro spécifié
    }

    private static void echangeProduit() {

    }

    private static void suivreEtatCommande() {
        List<Commande> listeCommandes = acheteurConnecte.getListeCommandes();

        if (listeCommandes != null && !listeCommandes.isEmpty()) {
            System.out.println("État des commandes pour l'acheteur " + acheteurConnecte.getPseudo() + ":");
            for (Commande commande : listeCommandes) {
                System.out.println("Commande n°" + commande.getNumeroCommande() + ": " + commande.getEtat());
            }
        } else {
            System.out.println("Aucune commande pour l'acheteur " + acheteurConnecte.getPseudo());
        }
    }

    private static void commandePasse() {

    }

    public static void passerCommande() {
        if (PanierAchat.getListeProduits().isEmpty()) {
            System.out.println("Le panier est vide. Ajoutez des produits avant de passer une commande.");
            return;
        }

        System.out.println("Panier :");
        PanierAchat.afficherPanier();

        System.out.println("Passer la commande? (Oui/Non)");
        String reponse = scanner.nextLine();

        if (reponse.equalsIgnoreCase("Oui")) {
            Commande nouvelleCommande = creerNouvelleCommande(); //commande creee avec produit dans panier

            // Adresse de livraison
            System.out.println("Entrez l'adresse de livraison :");
            String adresseLivraison = scanner.nextLine();
            nouvelleCommande.setAdresseLivraison(adresseLivraison);

            // Info de paiement
            ajouterInfoPaiement(nouvelleCommande);

            // Ajouter la commande à la liste des commandes de l'acheteur
            Acheteur.getListeCommandes().add(nouvelleCommande);

            // Vider le panier
            PanierAchat.viderPanier();

            System.out.println("Commande passée avec succès. Numéro de commande : " + nouvelleCommande.getNumeroCommande());
        } else {
            System.out.println("Informations invalides.");
        }
    }

    private static void ajouterInfoPaiement(Commande commande) {
        System.out.println("Choisissez le mode de paiement :");
        System.out.println("1. Carte de crédit");
        System.out.println("2. PayPal");
        System.out.println("3. Carte cadeau");

        int choixPaiement = choixUtil(scanner);

        switch (choixPaiement) {
            case 1:
                //les détails de paiement par carte de crédit
                System.out.println("Entrez les détails de la carte de crédit:");
                System.out.print("Numéro de carte : ");
                String numeroCarte = scanner.nextLine();
                System.out.print("Date d'expiration (MM/AA) : ");
                String dateExpiration = scanner.nextLine();
                System.out.print("Code de sécurité : ");
                String codeSecurite = scanner.nextLine();
                //sauvegarder les informations de paiement avec la commande
                String detailCredit = "Numéro de carte de crédit:" + numeroCarte +
                        ", date d'expiration:" + dateExpiration +
                        ", code de sécurité:" + codeSecurite;

                commande.setDetailPaiement(detailCredit);
                break;


            case 2:
                // les détails de paiement par PayPal
                System.out.println("Entrez les détails de PayPal:");
                System.out.print("Adresse email PayPal : ");
                String emailPayPal = scanner.nextLine();

                String detailPaypal = "Email Paypal:" + emailPayPal;
                commande.setDetailPaiement(detailPaypal);
                break;

            case 3:
                // détails de paiement par carte cadeau
                System.out.println("Entrez les détails de la carte cadeau:");
                System.out.print("Code de la carte cadeau : ");
                String codeCarteCadeau = scanner.nextLine();

                String detailCadeau = "Code de la carte cadeau:" + codeCarteCadeau;
                commande.setDetailPaiement(detailCadeau);
                break;
            default:
                System.out.println("Mode de paiement non reconnu.");
        }
    }


    private static int choixUtil(Scanner scanner) {
        int choixPaiement = 0;

        try {
            choixPaiement = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }

        return choixPaiement;
    }

    private static Commande creerNouvelleCommande() {
        // nouvelle commande avec produit panier
        // ajouter info du panier
        return null;
    }

    public static void rechercheProduit() {
        System.out.println("Entrez le nom du produit:");
        String recherche = scanner.nextLine();
        System.out.println("1.choisir une categorie");
        System.out.println("2.Filtrer avec le prix");
        System.out.println("3.Filtrer avec la note moyenne");
        System.out.println("4.Filtrer avec le nombre de like ");

        int cas = UnishopControleur.choixUtil();
        switch (cas) {
            case 1 -> categorie();
            case 2 -> filtrePrix();
            case 3 -> filtreMoyenne();
            case 4 -> filtreLikes();
            default -> System.out.println("Aucune information pour cette action.");

        }

        List<Produit> produitsTrouves = Catalogue.rechercherProduit(recherche);

        if (produitsTrouves.isEmpty()) {
            System.out.println("Aucun produit trouvé pour la recherche : " + recherche);
        } else {
            System.out.println("Produits trouvés :");
            for (int i = 0; i < produitsTrouves.size(); i++) {
                Produit produit = produitsTrouves.get(i);
                System.out.println((i + 1) + ". " + produit.getTitre() + " - " + produit.getPrix());
            }

            System.out.println("Entrez le numéro du produit que vous souhaitez ajouter au panier (0 pour annuler) :");
            int choixProduit = UnishopControleur.choixUtil();

            if (choixProduit > 0 && choixProduit <= produitsTrouves.size()) {
                Produit produitSelectionne = produitsTrouves.get(choixProduit - 1);
                System.out.println("Entrez la quantité que vous souhaitez ajouter au panier :");
                int quantite = UnishopControleur.choixUtil();

                PanierAchat.ajouterAuPanier(produitSelectionne, quantite);
            } else {
                System.out.println("Opération annulée.");
            }
        }

    }

    public static void filtrePrix() {
        System.out.println("Prix sélectionné");

    }

    public static void filtreMoyenne() {
        System.out.println("Moyenne sélectionnée");

    }

    public static void filtreLikes() {
        System.out.println("Nombre de likes sélectionné");

    }

    private static void confirmerReceptionCommande() {
        System.out.println("Entrez le numéro de la commande :");
        int numeroCommande = choixUtil(scanner);

        Commande commandeAConfirmer = recupererCommandeParNum(numeroCommande);

        if (commandeAConfirmer != null) {
            System.out.println("Détails de la commande :");
            afficherDetailsCommande(commandeAConfirmer); //ajouter ce qu'on veut que ca l'affiche

            proposerConfirmation(commandeAConfirmer);

            boolean confirmerReceptionCommande = demanderConfirmation();

            // Oui
            if (confirmerReceptionCommande) {
                commandeAConfirmer.confirmerReceptionCommande(confirmerReceptionCommande);
                System.out.println("La réception de la commande a été confirmée. L'état de la commande est maintenant 'livrée'.");
            }
            // Non
            else {
                System.out.println("La réception de la commande n'a pas été confirmée. L'état de la commande reste inchangé.");
            }
        }
        // Informations invalides/la commande n'existe pas dans le database
        else {
            System.out.println("Commande introuvable. Veuillez vérifier le numéro de commande.");
        }
    }

    private static boolean demanderConfirmation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Confirmez-vous la reception de la commande? Oui/Non");
        String reponse = scanner.nextLine();
        return reponse.equalsIgnoreCase("Oui");
    }

    private static void proposerConfirmation(Commande commandeAConfirmer) {
        System.out.println("Confirmez-vous la réception de la commande? (Oui/Non)");
        Scanner scanner = new Scanner(System.in);
        String reponse = scanner.nextLine();
        boolean confirmerReceptionCommande = reponse.equalsIgnoreCase("Oui");

        if (confirmerReceptionCommande) {
            System.out.println("Vous avez choisi de confirmer la réception de la commande.");
        } else {
            System.out.println("Vous avez choisi de ne pas confirmer la réception de la commande.");
        }
    }

    private static void afficherDetailsCommande(Commande commandeAConfirmer) {
        System.out.println("Numéro de commande : " + commandeAConfirmer.getNumeroCommande());
        System.out.println("État de la commande : " + commandeAConfirmer.getEtat());
        System.out.println("Date de commande : " + commandeAConfirmer.getDateCommande());
        System.out.println("Adresse de livraison : " + commandeAConfirmer.getAdresseLivraison());
        System.out.println("Téléphone : " + commandeAConfirmer.getTelephone());
        System.out.println("Prix : " + commandeAConfirmer.getPrix());
        System.out.println("Produit : " + commandeAConfirmer.getProduit().toString());
        System.out.println("Retour reçu : " + (commandeAConfirmer.isRetourRecu() ? "Oui" : "Non"));
    }

    private static Commande recupererCommandeParNum(int numeroCommande) {
        return null;
    }

    public static void categorie() {
        System.out.println("Une catégorie est sélectionnée");

    }

    public void envoyerNotification(String message) {
        NotificationAcheteur notification = new NotificationAcheteur(acheteur, message);
        acheteur.getNotifications().add(notification);
        notification.envoyerNotification();
    }

    public static void voirNotification() {
        List<NotificationAcheteur> notifications = acheteurConnecte.getNotifications();
        for (NotificationAcheteur notification : notifications) {
            System.out.println(notification.getMessage());
        }
    }

    public static void gestionSuiveur() {
        int nombreSuiveurs = acheteurConnecte.getSuiveur();
        if (nombreSuiveurs > 0) {
            nombreSuiveurs--;
            System.out.println("Vous avez perdu un suiveur. Nombre total de suiveurs : " + nombreSuiveurs);
        } else {
            System.out.println("Vous n'avez pas de suiveurs à perdre.");
        }
    }

    public static void likerRevendeur() {
        if (acheteurConnecte != null) {
            // Afficher la liste des revendeurs disponibles
            List<Revendeur> revendeurs = Initialisation.getListeRevendeurs();
            System.out.println("Liste des revendeurs disponibles : ");
            for (int i = 0; i < revendeurs.size(); i++) {
                System.out.println((i + 1) + ". " + revendeurs.get(i).getNom()); // Affichez le nom du revendeur
            }

            // Sélectionnez un revendeur à liker
            System.out.println("Sélectionnez le numéro du revendeur que vous souhaitez liker : ");
            int choixRevendeur = UnishopControleur.choixUtil();

            if (choixRevendeur > 0 && choixRevendeur <= revendeurs.size()) {
                Revendeur revendeurAliker = revendeurs.get(choixRevendeur - 1);
                acheteur.likerRevendeur(revendeurAliker);
                System.out.println("Vous avez liké le revendeur avec succès.");
            } else {
                System.out.println("Numéro de revendeur invalide.");
            }
        } else {
            System.out.println("Vous devez être connecté en tant qu'acheteur pour liker un revendeur.");
        }
    }

    public void suivreProfil(Acheteur autreAcheteur) {
        acheteur.incrementerSuiveur(autreAcheteur);
        String message = "Nouvel acheteur" + autreAcheteur.getPseudo() + "a commencé à vous suivre";
        envoyerNotification(message);
    }

    public void likeProduitRevendeur(Produit produit, Revendeur revendeur) {
        String message = "Un de vos revendeurs likés " + revendeur.getNom() + "a ajoute un nouveau produit :" + produit.getTitre();
        envoyerNotification(message);
    }

    public void nouvelllePromotionProduitRevendeur(Produit produit, Revendeur revendeur) {
        String message = "Il y a une nouvelle promotion sur le produit " + produit.getTitre() + "chez votre revendeur liké :" + revendeur.getNom();
        envoyerNotification(message);
    }

    public void changementEtatCommande(Commande commande) {
        String message = "L'état de votre commande" + commande.getNumeroCommande() + "a changé à:" + commande.getEtat();
        envoyerNotification(message);
    }

    public void promotionProduitliked(Produit produit) {
        String message = "Le produit" + produit.getTitre() + "que vous liké est en promotion";
        envoyerNotification(message);
    }

    public void solutionProposee(Produit produit, String descriptionSolution) {
        String message = "Le revendeur a proposé une solution pour votre problème signalé sur le produit " + produit.getTitre() + ". La solution est :" + descriptionSolution;
        envoyerNotification(message);
    }

    public void accumulerPointsFidelite(float montantAchat) {
        int pointsFidelite = acheteur.getpointsFidelite();
        //1 point pour chaque 2 dollars depensé
        int nvxPoints = (int) (montantAchat / 2);
        pointsFidelite += nvxPoints;
        System.out.println("Vous avez accumulé " + nvxPoints + " points de fidélité pour cet achat");
        System.out.println("Vous avez maintenant en total " + pointsFidelite + " points de fidélité");
    }

    public void utiliserPointsFidelite(float montantAchat) {
        int pointsFidelite = acheteur.getpointsFidelite();
        int pointsUtilises = (int) (pointsFidelite / 2);
        if (pointsUtilises > 0) {
            float rabais = pointsUtilises * 0.02f * montantAchat; // 1 point pour 2 centimes de rabais
            System.out.println("Vous avez utilisé " + pointsUtilises + " points de fidélité pour cet achat, pour obtenir un rabais de $" + rabais);
            pointsFidelite -= pointsUtilises;
            System.out.println("Vous avez maintenant en total " + pointsFidelite + " points de fidélité");
        } else {
            System.out.println("Vous n'avez pas assez de points de fidélité pour obtenir un rabais");
        }
    }


    public static void evaluerProduit() {
        System.out.println("Entrez le nom du produit à évaluer:");
        String recherche = scanner.nextLine();

        List<Produit> produitsTrouves = Catalogue.rechercherProduit(recherche);

        if (produitsTrouves.isEmpty()) {
            System.out.println("Aucun produit trouvé pour : " + recherche);
            return;
        }

        System.out.println("Produits trouvés :");
        for (int i = 0; i < produitsTrouves.size(); i++) {
            System.out.println((i + 1) + ". " + produitsTrouves.get(i).getTitre());
        }

        System.out.println("Choisissez le numéro du produit que vous souhaitez évaluer:");
        int choixProduit = UnishopControleur.choixUtil();

        if (choixProduit < 1 || choixProduit > produitsTrouves.size()) {
            System.out.println("Choix invalide.");
            return;
        }

        Produit produitSelectionne = produitsTrouves.get(choixProduit - 1);

        System.out.println("Donnez une note entre 0 et 5 pour le produit " + produitSelectionne.getTitre() + ":");
        int note = scanner.nextInt();
        scanner.nextLine();

        if (note < 0 || note > 5) {
            System.out.println("Note invalide. Elle doit être comprise entre 0 et 5.");
            return;
        }

        System.out.println("Entrez votre commentaire:");
        String commentaire = scanner.nextLine();

        EvaluerProduit nouvelleEvaluation = new EvaluerProduit(note, commentaire);
        produitSelectionne.ajouterEvaluation(nouvelleEvaluation);

        System.out.println("Votre évaluation a été ajoutée avec succès.");
    }
    public static void voirPointsFidelite() {
        if (acheteurConnecte != null) {
            int pointsFidelite = acheteurConnecte.getpointsFidelite();
            System.out.println("Vous avez " + pointsFidelite + " points de fidélité.");
        } else {
            System.out.println("Vous devez être connecté pour voir vos points de fidélité.");
        }
    }

    public static void likerProduit () {
        System.out.println("Choisissez un produit à liker:");
        List<Produit> produits = Catalogue.getListeProduits();

        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i).getTitre());
        }

        System.out.println("Entrez le numéro du produit:");
        int choix = UnishopControleur.choixUtil();

        if (choix > 0 && choix <= produits.size()) {
            Produit produit = produits.get(choix - 1);
            acheteurConnecte.likerProduit(produit);
            System.out.println("Vous avez liké le produit: " + produit.getTitre() + ".");
        } else {
            System.out.println("Choix invalide.");
        }
    }
}
