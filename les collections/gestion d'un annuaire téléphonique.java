import java.util.HashMap;
import java.util.Scanner;

public class AnnuaireTelephonique {
HashMap<String, String> annuaire = new HashMap<>();
Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
 boolean cont = true;
        while (cont) {
        afficherMenu();
      int choix = scanner.nextInt();
      scanner.nextLine();

     if (choix == 1) {
     ajouterContact();
     } else if (choix == 2) {
     rechercherContact();
     } else if (choix == 3) {
     modifierNumero();
     } else if (choix == 4) {
    supprimerContact();
    } else if (choix == 5) {
     afficherTousContacts();
     } else if (choix == 6) {
     cont= false;
     System.out.println("Au revoir :");
  } else {
       System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    public static void afficherMenu() {
        System.out.println("Menu Annuaire Téléphonique");
        System.out.println("ajouter  contact");
        System.out.println("rechercher  contact");
        System.out.println("modifier numéro");
        System.out.println("supprimer  contact");
        System.out.println("afficher tous les contacts");
        System.out.println("quitter");
        System.out.print("votre choix : ");
    }

    public static void ajouterContact() {
        System.out.print("Entrez le nom du contact : ");
        String nom = scanner.nextLine();
        if (annuaire.containsKey(nom)) {
            System.out.println("Ce contact existe déjà !");
            return;
        }
        System.out.print("Entrez le numéro de téléphone (8 chiffres) : ");
        String numero = scanner.nextLine();
        if (!estNumeroValide(numero)) {
            System.out.println("Numéro invalide. Il doit contenir exactement 8 chiffres.");
            return;
        }
        annuaire.put(nom, numero);
        System.out.println("Contact ajouté avec succès.");
    }

    public static void rechercherContact() {
        System.out.print("Entrez le nom du contact à rechercher : ");
        String nom = scanner.nextLine();
        if (annuaire.containsKey(nom)) {
            System.out.println("Numéro : " + annuaire.get(nom));
        } else {
            System.out.println("Contact introuvable.");
        }
    }

    public static void modifierNumero() {
        System.out.print("Entrez le nom du contact à modifier : ");
        String nom = scanner.nextLine();
        if (!annuaire.containsKey(nom)) {
            System.out.println("Contact introuvable.");
            return;
        }
        System.out.print("Entrez le nouveau numéro (8 chiffres) : ");
        String nouveauNumero = scanner.nextLine();
        if (!estNumeroValide(nouveauNumero)) {
            System.out.println("Numéro invalide. Il doit contenir exactement 8 chiffres.");
            return;
        }
        annuaire.replace(nom, nouveauNumero);
        System.out.println("Numéro modifié avec succès.");
    }

    public static void supprimerContact() {
        System.out.print("entrez le nom du contact à supprimer : ");
        String nom = scanner.nextLine();
        if (annuaire.containsKey(nom)) {
            annuaire.remove(nom);
            System.out.println("contact supprimé avec succès.");
        } else {
            System.out.println("contact introuvable.");
        }
    }

    public static void afficherTousContacts() {
        if (annuaire.isEmpty()) {
            System.out.println("Aucun contact dans l'annuaire.");
            return;
        }
        System.out.println("Liste des contacts :");
        annuaire.forEach((nom, numero)  {
            System.out.println("Nom : " + nom + ", Numéro : " + numero);
        });
    }

    public static boolean estNumeroValide(String numero) {
        if (numero.length() != 8) {
            return false;
        }
        for (char c : numero.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
