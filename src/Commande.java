public class Commande {
    private int numeroCommande;
    private String etat;
    private String dateCommande;
    private Produit produit;
    private String adresseLivraison;
    private String telephone;
    private float prix;
    private boolean retourRecu;
    private Probleme probleme;
    private String detailPaiement;
    private boolean remboursement;
    

    public boolean isRembourser(){
        return remboursement;
    }
    public void setRemboursement(boolean remboursement){
        this.remboursement=remboursement;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    
    public void confirmerReceptionCommande(boolean confirmation){
        if (confirmation){
            this.setEtat("Livré");
            System.out.println("La réception de la commande a été confirmée. La commande est maintenant 'Livré'.");
        }
        else{
            System.out.println("La réception de la commande n'a pas été confirmée. L'état de la commande reste inchangé.");
        }
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    public boolean isRetourRecu() {
        return retourRecu;
    }

    public void setRetourRecu(boolean retourRecu) {
        this.retourRecu = retourRecu;
    }

    public void confirmerReceptionRetour() {
        if (!this.retourRecu) {
            this.retourRecu = true;
            System.out.println("Retour de la commande"+ numeroCommande + "a été confirmé");
        } else {
            System.out.println("Retour de la commande"+ numeroCommande + "a deja été confirmé");
        }
    }

    public void setProbleme(Probleme probleme) {
        this.probleme = probleme;
    }

    public Probleme getProbleme() {
        return probleme;
    }
    
    public String getDetailPaiement(){
        return detailPaiement;
    }

    public void setDetailPaiement(String detailPaiement){
        this.detailPaiement = detailPaiement;
    }
}
