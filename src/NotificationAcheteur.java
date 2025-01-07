public class NotificationAcheteur {

    private Acheteur acheteur;
    private String message;

    public NotificationAcheteur(Acheteur acheteur, String message) {
        this.acheteur = acheteur;
        this.message = message;
    }

    public void envoyerNotification() {
        System.out.println("Notification pour: " + acheteur.getPseudo() + ": " + message);
    }

    public String getMessage() {
        return message;
    }
}
