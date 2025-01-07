public class NotificationRevendeur {

    private Revendeur revendeur;
    private String message;

    public NotificationRevendeur(Revendeur revendeur, String message) {
        this.revendeur = revendeur;
        this.message = message;
    }

    public void envoyerNotification() {
        System.out.println("Notification pour: " + revendeur.getNom() + ": " + message);
    }

    public String getMessage() {
        return message;
    }
}
