public class MetriquesAcheteur implements Metriques {
    private int nombresCommandes;
    private int nombreArticlesAcheter;
    private int likeSurEvaluation;
    private int nombreLikeProduits;
    private int nombreEvaluationProduits;

    public MetriquesAcheteur(){
        this.nombresCommandes = 0;
        this.nombreArticlesAcheter = 0;
        this.likeSurEvaluation = 0;
        this.nombreLikeProduits = 0;
        this.nombreEvaluationProduits = 0;
    }

    public void incrementerNombreCommandes(){
        this.nombresCommandes++;
    }

    public void incrementerNombreArticlesAcheter(int quantite){
        this.nombreArticlesAcheter += quantite;
    }

    public void incrementerLikeSurEvaluation(){
        this.likeSurEvaluation++;
    }

    public void incrementerLikeProduits(){
        this.nombreLikeProduits++;
    }

    public void incrementerEvaluationProduits(){
        this.nombreEvaluationProduits++;
    }

    public int getNombresCommandes() {
        return nombresCommandes;
    }

    public int getNombreArticlesAcheter() {
        return nombreArticlesAcheter;
    }

    public int getLikeSurEvaluation() {
        return likeSurEvaluation;
    }

    public int getNombreLikeProduits() {
        return nombreLikeProduits;
    }

    public int getNombreEvaluationProduits() {
        return nombreEvaluationProduits;
    }

    @Override
    public void metriquesProfil() {
        System.out.println("Vos métriques");
        System.out.println("Votre nombre de commande est " + nombresCommandes);
        System.out.println("Votre nombre d'articles achetés est " + nombreArticlesAcheter);
        System.out.println("Le nombre de like sur vos évaluations est " + likeSurEvaluation);
        System.out.println("Votre nombre de like sur des produits est " + nombreLikeProduits);
        System.out.println("Votre nombre d'évaluations sur des produits est " + nombreEvaluationProduits);
    }

    @Override
    public void metriquesAccueil() {
        System.out.println("Voici un aperçu de vos métriques");
        System.out.println("Nombre de commande: " + nombresCommandes);
        System.out.println("Nombre d'articles achetés: " + nombreArticlesAcheter);
        System.out.println("Nombre de like évaluation: " + likeSurEvaluation);
        System.out.println("Pour plus de métriques rendez-vous sur votre profil");

    }
}
