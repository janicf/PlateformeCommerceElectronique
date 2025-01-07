import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livres extends Produit {
    private int ISBN;
    private String auteur;
    private String maisonEdition;
    private String genre;               //ex: roman, documentaire, bande dessinée, manuel, etc.
    private String dateParution;
    private int numeroEdition;
    private int numeroVolume;
    private static Scanner scanner = new Scanner(System.in);

    public Livres(){
        super.getEvaluation();
    }

    public Livres(Livres livre){
        System.out.println("Entrer le titre de votre produit");
        livre.setTitre(scanner.nextLine());

        System.out.println("Entrer une description");
        livre.setDescription(scanner.nextLine());

        try {
            System.out.println("Entrer la quantité");
            livre.setQuantiteInitiale(scanner.nextInt());

            System.out.println("Entrer le prix");
            float prix = scanner.nextFloat();
            livre.setPrix(prix);

            System.out.println("Ajouter des points bonus");
            System.out.println("1. Oui");
            System.out.println("2. Non");

            if(scanner.nextInt() == 1){
                System.out.println("Entrer le nombre de point bonus (maximum de 20)");
                livre.setPointBase((int) (scanner.nextInt() * prix));
            }
            else livre.setPointBase((int) prix);

            System.out.println("Entrer l'ISBN");
            livre.setISBN(scanner.nextInt());

        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
        }

        System.out.println("Entrer l'auteur");
        livre.setAuteur(scanner.nextLine());

        System.out.println("Entrer la maison d'édition");
        livre.setMaisonEdition(scanner.nextLine());

        System.out.println("Entrer le genre");
        livre.setGenre(scanner.nextLine());

        System.out.println("Entrer la date de parution");
        livre.setDateParution(scanner.nextLine());

        try {
            System.out.println("Entrer le numéro d'édition");
            livre.setNumeroEdition(scanner.nextInt());

            System.out.println("Entrer le numéro du volume");
            livre.setNumeroVolume(scanner.nextInt());

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

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(String maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDateParution() {
        return dateParution;
    }

    public void setDateParution(String dateParution) {
        this.dateParution = dateParution;
    }

    public int getNumeroEdition() {
        return numeroEdition;
    }

    public void setNumeroEdition(int numeroEdition) {
        this.numeroEdition = numeroEdition;
    }

    public int getNumeroVolume() {
        return numeroVolume;
    }

    public void setNumeroVolume(int numeroVolume) {
        this.numeroVolume = numeroVolume;
    }
}
