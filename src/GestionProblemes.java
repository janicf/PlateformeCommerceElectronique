import java.util.ArrayList;
import java.util.List;

public class GestionProblemes {
    private List<Probleme> problemes;

    public GestionProblemes() {
        this.problemes = new ArrayList<>();
    }

    public List<Probleme> getProblemes() {
        return problemes;
    }

    public void signalerProbleme(int numCommande, String description) {
        Probleme probleme = new Probleme(numCommande, description);
        problemes.add(probleme);
        System.out.println("Problème signalé : " + probleme);
    }

    public void resoudreProbleme(int numProb, String solution) {
        Probleme probleme = findProbleme (numProb);
        if (probleme != null) {
            probleme.setResolu(true);
            probleme.setSolution(solution);
            System.out.println("Problème résolu : " + probleme);
        } else {
            System.out.println("Problème " + numProb + "non trouvé");
        }
    }
    
    private Probleme findProbleme(int numProb) {
        for (Probleme probleme : problemes) {
            if (probleme.getNumProb() == numProb) {
                return probleme;
            }
        }
        return null;
    }
}
