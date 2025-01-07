public class Probleme {
    private static int numProbCounter = 1;
    
    private int numProb;
    private int numCommande;
    private String description;
    private boolean resolu;
    private String solution;

    public Probleme(int numCommande, String description) {
        this.numProb = numProbCounter++;
        this.numCommande = numCommande;
        this.description = description;
        this.resolu = false;
    }

    public int getNumProb() {
        return numProb;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResolu() {
        return resolu;
    }

    public void setResolu(boolean resolu) {
        this.resolu = resolu;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Probleme : " + 
                "\n  Probleme numero : " + numProb + 
                "\n  Commande numero : " + numCommande + 
                "\n  Description : " + description + 
                "\n  Resolution du probleme : " + resolu + 
                "\n";
    }
}
