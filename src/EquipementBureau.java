import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipementBureau extends Produit {
    private String marque;
    private String modele;
    private String sousCategorie;           //ex: table, chaise, lampe, etc
    private static Scanner scanner = new Scanner(System.in);

    public EquipementBureau(){
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

    public EquipementBureau(EquipementBureau equipementBureau){
        System.out.println("Entrer le titre de votre produit");
        equipementBureau.setTitre(scanner.nextLine());

        System.out.println("Entrer une description");
        equipementBureau.setDescription(scanner.nextLine());

        try {
            System.out.println("Entrer la quantité");
            equipementBureau.setQuantiteInitiale(scanner.nextInt());

            System.out.println("Entrer le prix");
            float prix = scanner.nextFloat();
            equipementBureau.setPrix(prix);

            System.out.println("Ajouter des points bonus");
            System.out.println("1. Oui");
            System.out.println("2. Non");

            if(scanner.nextInt() == 1){
                System.out.println("Entrer le nombre de point bonus (maximum de 20)");
                equipementBureau.setPointBase((int) (scanner.nextInt() * prix));
            }
            else equipementBureau.setPointBase((int) prix);

        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
        }

        ControleurRevendeur.ajouterPhotoVid();

        System.out.println("Entrer la marque");
        equipementBureau.setMarque(scanner.nextLine());

        System.out.println("Entrer le modèle");
        equipementBureau.setModele(scanner.nextLine());

        System.out.println("Entrer la sous-catégorie");
        equipementBureau.setSousCategorie(scanner.nextLine());

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
