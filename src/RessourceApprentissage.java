import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RessourceApprentissage extends Produit {
    private int ISBN;
    private String auteur;
    private String organisation;
    private String dateParution;
    private String type;            //imprimé ou électronique
    private int numeroEdition;
    private static Scanner scanner = new Scanner(System.in);

    public RessourceApprentissage(){
        setTitre("");
        setDescription("");
        setQuantiteInitiale(0);
        setPrix(0);
        setPointBase(0);
        setISBN(0);
        setAuteur("");
        setOrganisation("");
        setDateParution("");
        setType("");
        setNumeroEdition(0);
        super.getEvaluation();
    }

    public RessourceApprentissage(RessourceApprentissage ressource){
        System.out.println("Entrer le titre de votre produit");
        ressource.setTitre(scanner.nextLine());

        System.out.println("Entrer une description");
        ressource.setDescription(scanner.nextLine());

        try{
            System.out.println("Entrer la quantité");
            ressource.setQuantiteInitiale(scanner.nextInt());

            System.out.println("Entrer le prix");
            float prix = scanner.nextFloat();
            ressource.setPrix(prix);

            System.out.println("Ajouter des points bonus");
            System.out.println("1. Oui");
            System.out.println("2. Non");

            if(scanner.nextInt() == 1){
                System.out.println("Entrer le nombre de point bonus (maximum de 20)");
                ressource.setPointBase((int) (scanner.nextInt() * prix));
            }
            else ressource.setPointBase((int) prix);

            System.out.println("Entrer l'ISBN");
            ressource.setISBN(scanner.nextInt());

        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
        }

        System.out.println("Entrer l'auteur");
        ressource.setAuteur(scanner.nextLine());

        System.out.println("Entrer l'organisation'");
        ressource.setOrganisation(scanner.nextLine());

        System.out.println("Entrer la date de parution");
        ressource.setDateParution(scanner.nextLine());

        System.out.println("Entrer le type");
        ressource.setType(scanner.nextLine());

        try{
            System.out.println("Entrer le numéro d'édition");
            ressource.setNumeroEdition(scanner.nextInt());

        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
        }

        ControleurRevendeur.ajouterPhotoVid();
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getDateParution() {
        return dateParution;
    }

    public void setDateParution(String dateParution) {
        this.dateParution = dateParution;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumeroEdition() {
        return numeroEdition;
    }

    public void setNumeroEdition(int numeroEdition) {
        this.numeroEdition = numeroEdition;
    }
}

