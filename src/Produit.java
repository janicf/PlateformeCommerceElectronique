import java.util.ArrayList;
import java.util.List;

public abstract class Produit {
    private String titre;
    private String description;
    private String categorie;
    private String dateMiseVente;
    private int quantiteInitiale;
    private float prix;
    private int pointBase;
    private List <EvaluerProduit> evaluations;
    private int likes;
    

    public Produit() {
        this.likes = 0;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDateMiseVente() {
        return dateMiseVente;
    }

    public void setDateMiseVente(String dateMiseVente) {
        this.dateMiseVente = dateMiseVente;
    }

    public int getQuantiteInitiale() {
        return quantiteInitiale;
    }

    public void setQuantiteInitiale(int quantiteInitiale) {
        this.quantiteInitiale = quantiteInitiale;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getPointBase() {
        return pointBase;
    }

    public void setPointBase(int pointBase) {
        this.pointBase = pointBase;
    }

    public List<EvaluerProduit> getEvaluation() {
        return evaluations;
    }

    public void ajouterEvaluation (EvaluerProduit evaluation) {
        evaluations.add(evaluation);
    }

    public void setEvaluations(List<EvaluerProduit> nouvellesEvaluations) {
        this.evaluations = nouvellesEvaluations;
    }

    public void likerProduit() {
        this.likes++;
    }

    public int getLikes() {
        return this.likes;
    }

}
