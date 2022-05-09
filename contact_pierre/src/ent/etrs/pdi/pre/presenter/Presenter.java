package ent.etrs.pdi.pre.presenter;

import ent.etrs.pdi.pre.model.entities.Contact;
import ent.etrs.pdi.pre.model.exceptions.ContactException;
import ent.etrs.pdi.pre.model.exceptions.CoordonneeException;
import ent.etrs.pdi.pre.model.facade.ContactFacade;
import ent.etrs.pdi.pre.model.references.C;
import ent.etrs.pdi.pre.view.ContactView;

import java.util.List;

public class Presenter {
    /*------- ATTRIBUTS -------*/
    private ContactFacade metier;
    private ContactView vue;

    /*------- CONSTRUCTEUR(S) -------*/
    public Presenter(ContactFacade metier, ContactView vue) {
        this.metier = metier;
        this.vue = vue;
    }

    /*------- AUTRES METHODES -------*/

    /**
     * Permet d'executer l'application en affichant le menu d'option.
     */
    public void executer() {
        int choix = 0;
        do {
            // afficher le menu
            choix = this.vue.afficherMenu();
            // traiter les options du menu
            traiterOption(choix);

        } while (choix != 0);
    }

    /**
     * Traitement des option après choix de l'utilisateur.
     * @param choix
     */
    private void traiterOption(int choix) {
        switch (choix) {
            case 1: //Afficher la liste des contacts
                listerContacts();
                break;
            case 2: //Créer un nouveau contacts
                creerContact();
                break;
            case 3: //Supprimer un contact
                supprimerContact();
                break;
            case 4: //Lister coordonnées d'un contact
                listerCoordonneesContact();
                break;
            case 5: //Ajouter une coordonnées à un contact
                ajouterCoordonneesContact();
                break;
            case 6: //Supprimer coordonnées à un contact
                supprimerCoordonneesContact();
            default:
                break;
        }
    }

    /**
     * Méthode qui va lister les contacts de l'application.
     */
    private void listerContacts(){
        List<Contact> lstContacts = this.metier.listerContacts();
        this.vue.afficherContacts(lstContacts);
    }

    /**
     * Méthode qui permet à l'utilisateur de créer un contact.
     */
    private void creerContact(){
        try {
            Contact contact = this.vue.saisirContact();
            this.metier.sauvegarderContact(contact);
            this.vue.afficherMessage(String.format(C.MSG_CONTACT_CREATION, contact.getNom(), contact.getPrenom()));
        } catch (ContactException e) {
            this.vue.afficherMessage(C.MSG_CONTACT_EXCEPTION);
        }
    }

    /**
     * Méthode qui permet de supprimer un contact de l'application.
     */
    private void supprimerContact(){
        try {
            this.metier.supprimerContact(this.vue.selectionnerContact(this.metier.listerContacts()));
            this.vue.afficherMessage(C.MSG_CONTACT_SUPPRESSION);
        } catch (ContactException e) {
            this.vue.afficherMessage(C.MSG_CONTACT_EXCEPTION);
        }
    }

    /**
     * Méthode qui permet de lister les coordonnées d'un contact selectionné par un utilisateur.
     */
    private void listerCoordonneesContact(){
        this.vue.afficherCoordonnees(this.vue.selectionnerContact(this.metier.listerContacts()));
    }

    /**
     * Méthode qui permet d'ajouter une coordonnée à un contact sélectionné au préalable par l'utilisateur.
     */
    private void ajouterCoordonneesContact(){
        try {
            this.vue.saisirCoordonneesContact(this.vue.selectionnerContact(this.metier.listerContacts()));
        } catch (CoordonneeException e) {
            this.vue.afficherMessage(C.MSG_COORDONNEE_EXCEPTION);
        }
    }

    /**
     * Méthode qui permet de supprimer une coordonnée sélectionnée par l'utilisateur pour un contact également sélectionné au préalable.
     */
    private void supprimerCoordonneesContact(){
        try {
            this.vue.supprimerCoordonneesContact(this.vue.selectionnerContact(this.metier.listerContacts()));
        } catch (CoordonneeException e) {
            this.vue.afficherMessage(C.MSG_COORDONNEE_EXCEPTION);
        }
    }
}
