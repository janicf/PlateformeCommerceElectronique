import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaterielInformatique extends Produit {
    private String marque;
    private String modele;
    private String dateLancement;
    private String sousCategorie;           //ex: ordinateur, souris, clavier, disque dur externe, etc.
    private static Scanner scanner = new Scanner(System.in);

    public MaterielInformatique(){
        setTitre("");
        setDescription("");
        setQuantiteInitiale(0);
        setPrix(0);
        setPointBase(0);
        setMarque("");
        setModele("");
        setDateLancement("");
        setSousCategorie("");
        super.getEvaluation();
    }

    public MaterielInformatique(MaterielInformatique materiel){
        System.out.println("Entrer le titre de votre produit");
        materiel.setTitre(scanner.nextLine());

        System.out.println("Entrer une description");
        materiel.setDescription(scanner.nextLine());

        try{
            System.out.println("Entrer la quantité");
            materiel.setQuantiteInitiale(scanner.nextInt());

            System.out.println("Entrer le prix");
            float prix = scanner.nextFloat();
            materiel.setPrix(prix);

            System.out.println("Ajouter des points bonus");
            System.out.println("1. Oui");
            System.out.println("2. Non");

            if(scanner.nextInt() == 1){
                System.out.println("Entrer le nombre de point bonus (maximum de 20)");
                materiel.setPointBase((int) (scanner.nextInt() * prix));
            }
            else materiel.setPointBase((int) prix);

        }catch (NumberFormatException e){
            System.out.println("Veuillez entrer un nombre");
        }

        System.out.println("Entrer la marque");
        materiel.setMarque(scanner.nextLine());

        System.out.println("Entrer le modèle");
        materiel.setModele(scanner.nextLine());

        System.out.println("Entrer la date de lancement");
        materiel.setDateLancement(scanner.nextLine());

        System.out.println("Entrer la sous-catégorie");
        materiel.setSousCategorie(scanner.nextLine());

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

    public String getDateLancement() {
        return dateLancement;
    }

    public void setDateLancement(String dateLancement) {
        this.dateLancement = dateLancement;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }
}
