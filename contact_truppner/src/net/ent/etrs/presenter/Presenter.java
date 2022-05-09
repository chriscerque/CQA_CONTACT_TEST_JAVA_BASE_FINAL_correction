package net.ent.etrs.presenter;


import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacadeImpl;
import net.ent.etrs.model.references.C;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.console.ContactViewImpl;

import java.util.Objects;

public class Presenter {
    /////ATTRIBUTS/////
    private ContactFacadeImpl metier;
    private ContactViewImpl contactVue;

    /////CONSTRUCTEUR/////
    public Presenter(ContactFacadeImpl metier, ContactViewImpl contactVue) throws PresenterException {
        if (Objects.isNull(metier)) {
            throw new PresenterException(C.MSG_FM_NULL);
        }
        if (Objects.isNull(contactVue)) {
            throw new PresenterException(C.MSG_CV_NULL);
        }
        this.metier = metier;
        this.contactVue = contactVue;
    }

    /////METHODES/////
    public void exec(){
        this.metier.init();

        int choix = 0;
        do {
            choix = this.contactVue.afficherMenu();

            traiterOption(choix);
        } while (choix != 0);
    }
    /////////////////////////////////////////////////////////////////////////////////////
    private void traiterOption(int choix) {
        switch (choix) {
            case 1:
                listerContacts();
                break;
            case 2:
                creerContact();
                break;
            case 3:
                supprimerContact();
                break;
            case 4:
                listerCoordonneesContact();
                break;
            case 5:
                ajouterCoordonneeContact();
                break;
            case 6:
                supprimerCoordonneeContact();
                break;
            case 0:
                break;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode permettant de lister tous les contacts ainsi que leur coordonnées.
     */
    private void listerContacts() {
        this.contactVue.afficherContacts(this.metier.listerContacts());
        this.contactVue.afficherMessage("\n");
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode permettant de creer un contact (sans coordonnées).
     */
    private void creerContact() {
        try {
            this.metier.sauvegarderContact(this.contactVue.saisirContact());
            this.contactVue.afficherMessage(C.MSG_CONTACT_CREATION + "\n");
        } catch (ContactException e) {
            this.contactVue.afficherMessage(e.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode permettant de supprimer un contact.
     */
    private void supprimerContact() {
        try {
            this.metier.supprimerContact(this.contactVue.selectionnerContact(this.metier.listerContacts()));
            this.contactVue.afficherMessage(C.MSG_CONTACT_SUPPRESSION + "\n");
        } catch (ContactException e) {
            this.contactVue.afficherMessage(e.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode permettant de lister toutes les coordonnées d'un contact choisi parmis la liste des contacts.
     */
    private void listerCoordonneesContact() {
        this.contactVue.afficherCoordonnees(this.contactVue.selectionnerContact(this.metier.listerContacts()));
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode permettant d'ajouter une coordonnée à un contact choisi parmi la liste des contacts.
     */
    private void ajouterCoordonneeContact(){
        try {
            this.metier.mettreAJourContact(this.contactVue.modifierContact(this.contactVue.selectionnerContact(this.metier.listerContacts())));
            this.contactVue.afficherMessage(C.MSG_CONTACT_MISE_A_JOUR);
        } catch (ContactException e) {
            this.contactVue.afficherMessage(e.getMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /**
     * Méthode permettant de supprimer une coordonnée d'un contact choisi parmi la liste des contacts.
     */
    private void supprimerCoordonneeContact() {
        try {
            this.metier.mettreAJourContact(this.contactVue.supprimerCoordonneesContact(this.contactVue.selectionnerContact(this.metier.listerContacts())));
            this.contactVue.afficherMessage(C.MSG_CONTACT_MISE_A_JOUR);
        } catch (ContactException | CoordonneeException e) {
            this.contactVue.afficherMessage(e.getMessage());
        }
    }

}
