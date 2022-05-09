package net.ent.etrs.presenter;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.MailView;
import net.ent.etrs.view.TelephoneView;

public class Presenter {

    private ContactFacade metier;
    private TelephoneView telVue;
    private MailView mailVue;
    private ContactView contVue;

    public Presenter(ContactFacade metier, TelephoneView telVue, MailView mailVue, ContactView contVue) {
        this.metier = metier;
        this.telVue = telVue;
        this.mailVue = mailVue;
        this.contVue = contVue;
    }

    public void executer() {
        int choix = 0;
        do {
            choix = this.contVue.afficherMenu();

            traiterOption(choix);
        } while (choix != 0);

    }

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
            case 4 :
                listerCoordonneeContact();
                break;
            case 5 :
                ajouterCoordonneeContact();
                break;
            case 6 :
                supprimerCoordonneeContact();
                break;
            default:
                break;
        }
    }

    private void supprimerCoordonneeContact() {
        try {
            contVue.supprimerCoordonneesContact(contVue.selectionnerContact(metier.listerContacts()));
        } catch (CoordonneeException e) {
            contVue.afficherMessage(e.getMessage());
        }
    }

    private void ajouterCoordonneeContact() {
        try {
            contVue.saisirCoordonneesContact(contVue.selectionnerContact(metier.listerContacts()));
        } catch (CoordonneeException e) {
            contVue.afficherMessage(e.getMessage());
        }
    }

    private void listerCoordonneeContact() {
        Contact cont = null;
        cont = (contVue.selectionnerContact(metier.listerContacts()));
        contVue.afficherCoordonnees(cont);
    }

    private void listerContacts(){
        contVue.afficherContacts(metier.listerContacts());
    }

    private void creerContact(){
        try {
            metier.sauvegarderContact(contVue.saisirContact());
        } catch (ContactException e) {
            contVue.afficherMessage(e.getMessage());
        }
    }

    private void supprimerContact(){
        ;
        try {
            metier.supprimerContact(contVue.selectionnerContact(metier.listerContacts()));
        } catch (ContactException e) {
            contVue.afficherMessage(e.getMessage());
        }
    }
}
