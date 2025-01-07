public class EvaluerProduit {
    private int note;
    private String commentaire;
    private int likes;

    public EvaluerProduit(int note, String commentaire) {
        this.note = note;
        this.commentaire = commentaire;
        this.likes= 0;
    }

    public int getNote() {
        return note;
    }

    public void setNote (int note){
        if (note >=0  && note <= 5 ) {
            this.note = note;
        } else {
            throw new IllegalArgumentException ("La note doit être comprise entre 0 et 5");
        }
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire (String commentaire){
        this.commentaire = commentaire;
    }

    public int getLikes() {
        return likes;
    }

    public void incrementLikes (){
        likes++;
    }

    public int calculerPoints(){
        return (likes>0)? 10: 0; // 10 points si le produit a au moins un like, 0 sinon
    }

    public void handleInappropriteEvaluation(){
        if (likes>0) {
            likes=0; // on supprime les likes si l'évaluation est signalée comme inappropriée ou supprimer
        }
    }

    @Override
    public String toString() {
        return "Note: " + note + ", Commentaire: " + commentaire + ", Likes: " + likes;
    }
}
