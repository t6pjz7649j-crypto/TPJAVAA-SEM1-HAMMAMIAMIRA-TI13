import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Exercice1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ------------------- PARTIE A — Gestion des notes -------------------
        ArrayList<Integer> notes = new ArrayList<>();
        System.out.print("Combien de notes voulez-vous saisir ? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int note;
            do {
                System.out.print("Note " + (i + 1) + " (0-20) : ");
                note = sc.nextInt();
            } while (note < 0 || note > 20);
            notes.add(note);
        }

        // Afficher toutes les notes avec Iterator
        System.out.println("Liste des notes :");

        Iterator<Integer> it = notes.iterator();

        while (it.hasNext()) {
            int ss=it.next();
            System.out.print( ss+ " ");
        }
        System.out.println();

        // Note maximale et moyenne
        int max = Collections.max(notes);
        double somme = 0;
        for (int nb : notes) somme += nb;
        double moyenne = somme / notes.size();
        System.out.printf("Note maximale : %d\n", max);
        System.out.printf("Moyenne : %.2f\n", moyenne);

        // Supprimer une note donnée
        System.out.print("Entrez la note à supprimer : ");
        int noteSup = sc.nextInt();
        if (notes.contains(noteSup)) {
            notes.remove(Integer.valueOf(noteSup));
            System.out.println("Note supprimée !");
        } else {
            System.out.println("Note non trouvée !");
        }
        System.out.println("Liste après suppression : " + notes);

        // Trier la liste
        Collections.sort(notes);
        System.out.println("Liste triée : " + notes);

        // Supprimer les notes > 18 avec Iterator
        it = notes.iterator();
        while (it.hasNext()) {
            if (it.next() > 18) it.remove();
        }
        System.out.println("Liste après suppression des notes > 18 : " + notes);

        // Rechercher et modifier une note
        System.out.print("Entrez la note à rechercher : ");
        int noteCherchee = sc.nextInt();
        int index = notes.indexOf(noteCherchee);
        if (index != -1) {
            System.out.println("Note trouvée à l'index " + index);
            System.out.print("Entrez la nouvelle valeur pour cette note : ");
            int nouvelleNote = sc.nextInt();
            notes.set(index, nouvelleNote);
        } else {
            System.out.println("Note non trouvée.");
        }
        System.out.println("Liste des notes mise à jour : " + notes);

        // ------------------- PARTIE B — Gestion des étudiants -------------------
        ArrayList<String> etudiants = new ArrayList<>();
        etudiants.add("Alia");
        etudiants.add("Samira");
        etudiants.add("Amira");

        sc.nextLine(); // consommer le saut de ligne restant
        System.out.print("Entrez le nom de l'étudiant à ajouter : ");
        String nom = sc.nextLine();
        etudiants.add(nom);

        // Vérifier si Samira existe
        if (etudiants.contains("Samira")) {
            System.out.println("Samira existe dans la liste.");
        } else {
            System.out.println("Samira n'existe pas dans la liste.");
        }

        // Remplacer Alia par Alia Ben Salah
        int idx = etudiants.indexOf("Alia");
        if (idx != -1) etudiants.set(idx, "Alia Ben Salah");

        // Supprimer un étudiant
        System.out.print("Entrez le nom de l'étudiant à supprimer : ");
        String nomSup = sc.nextLine();
        if (etudiants.contains(nomSup)) {
            etudiants.remove(nomSup);
            System.out.println("Étudiant supprimé !");
        } else {
            System.out.println("Étudiant non trouvé !");
        }

        // Afficher tous les étudiants
        System.out.println("Liste des étudiants :");
        for (String e : etudiants) System.out.println("- " + e);

        // Trier les étudiants
        Collections.sort(etudiants);
        System.out.println("Étudiants triés : " + etudiants);

        // Rechercher un étudiant par lettre
        System.out.print("Rechercher les étudiants commençant par la lettre : ");
        String lettre = sc.nextLine().toLowerCase();
        System.out.println("Résultats :");
        for (String e : etudiants) {
            if (e.toLowerCase().startsWith(lettre)) System.out.println("- " + e);
        }

        sc.close();
    }
}