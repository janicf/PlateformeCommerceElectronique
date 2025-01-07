import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Initialisation {
    private static List<Acheteur> listeAcheteurs;
    private static List<Revendeur> listeRevendeurs;
    private static List<Commande> listeCommandes;
    
    public Initialisation(){
        new PanierAchat();
        lireAcheteursDepuisFichier();
        lireRevendeursDepuisFichier();
        lireProduitsDepuisFichier();
        lireCommandeDepuisFichier();
    }

    private static void lireAcheteursDepuisFichier() {
        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new FileReader("acheteurs.json"))) {
            Type acheteurListType = new TypeToken<List<Acheteur>>() {}.getType();
            listeAcheteurs = gson.fromJson(reader, acheteurListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void lireRevendeursDepuisFichier() {
        Gson gson = new Gson();

        try (BufferedReader reader = new BufferedReader(new FileReader("revendeurs.json"))) {
            Type revendeurListType = new TypeToken<List<Revendeur>>() {}.getType();
            listeRevendeurs = gson.fromJson(reader, revendeurListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void lireProduitsDepuisFichier(){
        Gson gson = new Gson();
        Catalogue catalogue = new Catalogue();

        try (BufferedReader reader = new BufferedReader(new FileReader("produits.json"))) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                String type = jsonObject.get("produit").getAsString();

                // Utilise le champ "type" pour déterminer la classe à instancier
                switch (type) {
                    case "Papeterie":
                        catalogue.ajouterProduitCatalogue(gson.fromJson(element, Papeterie.class));
                        break;
                    case "Livres":
                        catalogue.ajouterProduitCatalogue(gson.fromJson(element, Livres.class));
                        break;
                    case "EquipementBureau":
                        catalogue.ajouterProduitCatalogue(gson.fromJson(element, EquipementBureau.class));
                        break;
                    case "MaterielInformatique":
                        catalogue.ajouterProduitCatalogue(gson.fromJson(element, MaterielInformatique.class));
                        break;
                    case "RessourceApprentissage":
                        catalogue.ajouterProduitCatalogue(gson.fromJson(element, RessourceApprentissage.class));
                        break;
                    default:
                        System.out.println("Type de produit inconnu : " + type);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lireCommandeDepuisFichier(){
        listeCommandes = new ArrayList<>();
        try (FileReader reader = new FileReader("commandes.json")) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                Commande commande = new Commande();
                commande.setNumeroCommande(jsonObject.get("numeroCommande").getAsInt());
                commande.setEtat(jsonObject.get("etat").getAsString());
                commande.setDateCommande(jsonObject.get("dateCommande").getAsString());
                commande.setAdresseLivraison(jsonObject.get("adresseLivraison").getAsString());
                commande.setTelephone(jsonObject.get("telephone").getAsString());
                commande.setPrix(jsonObject.get("prix").getAsFloat());
                commande.setRetourRecu(jsonObject.get("retourRecu").getAsBoolean());

                // Utilise le champ "produit" pour déterminer la classe à instancier
                JsonObject produitJsonObject = jsonObject.getAsJsonObject("produit");
                String produitType = produitJsonObject.get("produit").getAsString();

                Produit produit = createProduitInstance(produitType, produitJsonObject);
                commande.setProduit(produit);

                listeCommandes.add(commande);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     private static Produit createProduitInstance(String produitType, JsonObject produitJsonObject) {
        switch (produitType) {
            case "Papeterie":
                return new Gson().fromJson(produitJsonObject, Papeterie.class);
            case "Livres":
                return new Gson().fromJson(produitJsonObject, Livres.class);
            case "EquipementBureau":
                return new Gson().fromJson(produitJsonObject, EquipementBureau.class);
            case "MaterielInformatique":
                return new Gson().fromJson(produitJsonObject, MaterielInformatique.class);
            case "RessourceApprentissage":
                return new Gson().fromJson(produitJsonObject, RessourceApprentissage.class);
            default:
                throw new IllegalArgumentException("Unknown produit type: " + produitType);
        }
    }

     public static void sauvegarderAcheteursDansFichier() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("acheteurs2.json")) {
            gson.toJson(listeAcheteurs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderRevendeursDansFichier() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("revendeurs2.json")) {
            gson.toJson(listeRevendeurs, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderCommandesDansFichier() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("commandes2.json")) {
            gson.toJson(listeCommandes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sauvegarderProduitsDansFichier() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Produit> listeProduits = Catalogue.getListeProduits();

        try (FileWriter writer = new FileWriter("produits2.json")) {
            gson.toJson(listeProduits, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Acheteur> getListeAcheteurs() {
        return listeAcheteurs;
    }

    public static void ajouterAcheteur(Acheteur acheteur){
        listeAcheteurs.add(acheteur);
    }

    public static List<Revendeur> getListeRevendeurs() {
        return listeRevendeurs;
    }

    public static void ajouterRevendeur(Revendeur revendeur){
        listeRevendeurs.add(revendeur);
    }
}
