package org.example;
import java.util.ArrayList;
import java.util.Scanner; // Import indispensable pour lire au clavier

public class ContactsManager {
    ArrayList<Contact> myFriends;

    public ContactsManager() {
        this.myFriends = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        myFriends.add(contact);
    }

    public Contact searchContact(String searchName) {
        for (Contact contact : myFriends) {
            // Comparé le nom saisi
            if (contact.name.equalsIgnoreCase(searchName)) {
                return contact;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ContactsManager myContactsManager = new ContactsManager();
        Scanner scanner = new Scanner(System.in);

        // Ajout des contacts (Etape 5 de ton exo)
        myContactsManager.addContact(new Contact("Jean", "0123456789"));
        myContactsManager.addContact(new Contact("Alice", "0612345678"));
        myContactsManager.addContact(new Contact("Bob", "0789456123"));
        myContactsManager.addContact(new Contact("Charlie", "0654321098"));
        myContactsManager.addContact(new Contact("Diane", "0600112233"));

        // Interaction utilisateur
        System.out.println("=== Recherche de Contact ===");
        System.out.print("Entrez le nom à rechercher : ");
        String nomSaisi = scanner.nextLine(); // Attend que tu tapes un nom

        // Lancement de la recherche
        Contact resultat = myContactsManager.searchContact(nomSaisi);

        // Affichage du résultat
        if (resultat != null) {
            System.out.println("Trouvé ! Le numéro de " + resultat.name + " est : " + resultat.phoneNumber);
        } else {
            System.out.println("Désolé, le contact '" + nomSaisi + "' n'a pas été trouvé.");
        }

        scanner.close();
    }
}

