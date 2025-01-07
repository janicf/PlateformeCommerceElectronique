public class MetriquesRevendeur implements Metriques {
    private float revenu;
    private int nombreArticlesMisVente;
    private int nombreProduitsVendus;

    public MetriquesRevendeur(){
        this.revenu = 0.0F;
        this.nombreArticlesMisVente = 0;
        this.nombreProduitsVendus = 0;
    }

    public void incrementerRevenu(float montant){
        this.revenu += montant;
    }

    public void incrementerNombreArticlesMisVente(){
        this.nombreArticlesMisVente++;
    }

    public void incrementerNombreProduitsVendu(){
        this.nombreProduitsVendus++;
    }

    public float getRevenu() {
        return revenu;
    }

    public int getNombreArticlesMisVente() {
        return nombreArticlesMisVente;
    }

    public int getNombreProduitsVendus() {
        return nombreProduitsVendus;
    }

    @Override
    public void metriquesProfil() {
        System.out.println("Vos métriques");
        System.out.println("Vos revenus sont" + revenu);
        System.out.println("Le nombre d'article que vous avez mis en vente est " + nombreArticlesMisVente);
        System.out.println("Le nombre de produit vendus est " + nombreProduitsVendus);

    }

    @Override
    public void metriquesAccueil() {
        System.out.println("Voici un aperçu de vos métriques");
        System.out.println("Revenu: " + revenu);
        System.out.println("Nombre d'article mis en vente: " + nombreArticlesMisVente);
        System.out.println("Nombre de produit vendus: " + nombreProduitsVendus);
        System.out.println("Pour plus de métriques rendez-vous sur votre profil");
    }
}
