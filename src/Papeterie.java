import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Papeterie extends Produit {
    private String marque;
    private String modele;
    private String sousCategorie;           //ex: cahier, crayon, surligneur, etc.
    private static Scanner scanner = new Scanner(System.in);

    public Papeterie(){
        setTitre("");
        setDescription("");
        setQuantiteInitiale(0);
        setPrix(0);
        setPointBase(0);
        setMarque("");
        setModele("");
        setSousCategorie("");
        super.getEvaluation();
    }

    public Papeterie(Papeterie papeterie){
        System.out.println("Entrer le titre de votre produit");
        papeterie.setTitre(scanner.nextLine());

        System.out.println("Entrer une description");
        papeterie.setDescription(scanner.nextLine());

        try{
            System.out.println("Entrer la quantité");
            papeterie.setQuantiteInitiale(scanner.nextInt());

            System.out.println("Entrer le prix");
            float prix = scanner.nextFloat();
            papeterie.setPrix(prix);

            System.out.println("Ajouter des points bonus");
            System.out.println("1. Oui");
            System.out.println("2. Non");

            if(scanner.nextInt() == 1){
                System.out.println("Entrer le nombre de point bonus (maximum de 20)");
                papeterie.setPointBase((int) (scanner.nextInt() * prix));
            }
            else papeterie.setPointBase((int) prix);

        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
        }

        System.out.println("Entrer la marque");
        papeterie.setMarque(scanner.nextLine());

        System.out.println("Entrer le modèle");
        papeterie.setModele(scanner.nextLine());

        System.out.println("Entrer la sous-catégorie");
        papeterie.setSousCategorie(scanner.nextLine());

        ControleurRevendeur.ajouterPhotoVid();
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }
}
