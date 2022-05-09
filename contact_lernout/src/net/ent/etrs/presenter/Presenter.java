package net.ent.etrs.presenter;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.references.C;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;

import java.util.Objects;

public class Presenter {

    private ContactFacade metier;
    private ContactView vue;

    public Presenter(ContactFacade metier, ContactView vue) throws PresenterException {
        if (Objects.isNull(vue) || Objects.isNull(metier)) {
            throw new PresenterException("CONSTRUCTOR PRESENTER");
        }
        this.metier=metier;
        this.vue=vue;
    }

    public void executer() {

        int choix = 0;
        do {
            // afficher le menu
            choix = this.vue.afficherMenu();
            // traiter les options du menu
            traiterOption(choix);

        } while (choix != 0);
    }

    private void traiterOption(int choix) {
        switch (choix) {
            case 1: //Afficher la liste des contacts
                afficherContacts();
                break;
            case 2: //Créer un contact
                creerContact();
                break;
            case 3: //Supprimer un contact
                supprimerContact();
                break;
            case 4: //Lister les coordonées d'un contact
                listerCoordonneesContact();
                break;
            case 5: //Ajouter une coordonnée à un contact
                ajouterCoordonneesContact();
                break;
            case 6: //Supprimer une coordonnée d'un contact
                supprimerCoordonneesContact();
                break;
            default:
                break;
        }

    }


    private void creerContact() {
        try {
            this.metier.sauvegarderContact(this.vue.saisirContact());
            this.vue.afficherMessage(C.MSG_CONTACT_CREATION);
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }

    private void afficherContacts() {
        this.vue.afficherContacts(this.metier.listerContacts());
    }

    private void supprimerContact() {
        try {
            this.metier.supprimerContact(this.vue.selectionnerContact(this.metier.listerContacts()));
            this.vue.afficherMessage(C.MSG_CONTACT_SUPPRESSION);
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }

    private void listerCoordonneesContact() {
        this.vue.afficherCoordonnees(this.vue.selectionnerContact(this.metier.listerContacts()));
    }

    private void ajouterCoordonneesContact() {
        try {
            this.metier.mettreAJourContact(this.vue.selectionnerContact(this.metier.listerContacts()));
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }

    private void supprimerCoordonneesContact() {
        try {
            this.metier.supprimerContact(this.vue.selectionnerContact(this.metier.listerContacts()));
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }



}
