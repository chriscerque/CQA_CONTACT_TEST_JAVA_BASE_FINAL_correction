package net.ent.etrs.presenter;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.references.C;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.MailView;
import net.ent.etrs.view.TelephoneView;

import java.util.Objects;

public class Presenter {

////////////////////////////////////////////////////////////////////////////
//----------------------------- ATTRIBUTS --------------------------------//
////////////////////////////////////////////////////////////////////////////

    private ContactFacade metier;
    private ContactView vue;

////////////////////////////////////////////////////////////////////////////
//---------------------------- CONSTRUCTEUR ------------------------------//
////////////////////////////////////////////////////////////////////////////

    public Presenter(ContactFacade metier, ContactView vue, MailView vueMail, TelephoneView vueTelephone) throws PresenterException {
        if (Objects.isNull(metier)) {
            throw new PresenterException(C.MSG_FACADE_METIER_NULL);
        }
        if (Objects.isNull(vue)) {
            throw new PresenterException(C.MSG_FACADE_VUE_NULL);
        }
        this.metier = metier;
        this.vue = vue;
    }

////////////////////////////////////////////////////////////////////////////
//---------------------------- LANCEMENT ---------------------------------//
////////////////////////////////////////////////////////////////////////////

    public void exec() throws PresenterException {

        this.metier.init();

        int choix = 0;
        do {
            choix = this.vue.afficherMenu();

            traiterOption(choix);
        } while (choix != 0);
    }


////////////////////////////////////////////////////////////////////////////
//---------------------------- MENU CHOIX --------------------------------//
////////////////////////////////////////////////////////////////////////////

// RAPPEL OPTIONS
//    		"Lister les contacts",
//          "Créer un nouveau contact",
//          "Supprimer un contact",
//          "Lister les coordonnées d'un contact",
//          "Ajouter une coordonnée à un contact",
//          "Supprimer une coordonnée à un contact"
//
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
                listerCoordoneesContacts();
                break;
            case 5:
                ajouterCoordoneesContacts();
                break;
            case 6:
                supprimerCoordoneesContacts();
                break;
            case 0:
                this.vue.afficherMessage(C.MSG_QUITTER);
                break;
        }
    }

////////////////////////////////////////////////////////////////////////////
//------------------------ METHODES CHOIX --------------------------------//
////////////////////////////////////////////////////////////////////////////

    private void listerContacts() {
        this.vue.afficherContacts(this.metier.listerContacts());
    }

    private void creerContact()  {

        try {
            Contact contact = this.vue.saisirContact();
            metier.sauvegarderContact(contact);
        } catch (ContactException e) {
            throw new RuntimeException(e);
        }

    }

    private void supprimerContact(){
        Contact contact = this.vue.selectionnerContact(this.metier.listerContacts());
        try {
            metier.supprimerContact(contact);
        } catch (ContactException e) {
            throw new RuntimeException(e);
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }
    }

    private void  listerCoordoneesContacts(){
        Contact contact = this.vue.selectionnerContact(this.metier.listerContacts());

        this.vue.afficherCoordonnees(contact);

    }
    private void  ajouterCoordoneesContacts(){
        Contact contact = this.vue.selectionnerContact(this.metier.listerContacts());
        try {
            this.vue.saisirCoordonneesContact(contact);
        } catch (CoordonneeException e) {
            throw new RuntimeException(e);
        }
    }

    private void  supprimerCoordoneesContacts(){
        Contact contact = this.vue.selectionnerContact(this.metier.listerContacts());
        try {
            this.vue.supprimerCoordonneesContact(contact);
        } catch (CoordonneeException e) {
            throw new RuntimeException(e);
        }

    }




}
