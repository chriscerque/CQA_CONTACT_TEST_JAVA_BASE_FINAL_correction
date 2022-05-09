package presenter.impl;

import model.entities.Contact;
import model.entities.Coordonnee;
import model.exceptions.ContactException;
import model.exceptions.CoordonneeException;
import model.facade.ContactFacade;
import presenter.Presenter;
import view.ContactView;

public class PresenterImpl implements Presenter {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private ContactFacade metier;
    private ContactView vue;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    public PresenterImpl(ContactFacade metier, ContactView vue) {
        this.metier = metier;
        this.vue = vue;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void executer() {
        this.metier.init();
        int choix;
        do {
            choix = this.vue.afficherMenu();
            traiterOption(choix);
        } while (choix != 0);
    }

    /**
     * Méthode qui permet de rediriger l'utilisateur selon son choix dans le menu
     * @param choix de l'utilisateur
     */
    private void traiterOption(int choix) {
        switch (choix) {
            case 1:
                listerContacts();
                break;
            case 2:
                sauvergarderContact();
                break;
            case 3:
                supprimerContact();
                break;
            case 4:
                listerCoordonneesContact();
                break;
            case 5:
                ajouterCoordonneesContact();
                break;
            case 6:
                supprimerCoordonneesContact();
                break;
            case 0:
        }
    }

    private void listerContacts() {
        vue.afficherContacts(metier.listerContacts());
    }

    private void sauvergarderContact() {
        try {
            metier.sauvegarderContact(vue.saisirContact());
        } catch (ContactException e) {
            e.printStackTrace();
        }
    }

    private void supprimerContact() {
        Contact contact = vue.selectionnerContact(metier.listerContacts());
        try {
            metier.supprimerContact(contact);
        } catch (ContactException e) {
            e.printStackTrace();
        }
    }

    private void listerCoordonneesContact() {
        Contact contact = vue.selectionnerContact(metier.listerContacts());
        vue.afficherContact(contact);
    }

    private void ajouterCoordonneesContact() {
        try {
            Contact contact = vue.selectionnerContact(metier.listerContacts());
            metier.mettreAJourContact(vue.saisirCoordonneesContact(contact));
        } catch (ContactException | CoordonneeException e) {
            e.printStackTrace();
        }
    }

    private void supprimerCoordonneesContact() {
        try {
            Contact contact = vue.selectionnerContact(metier.listerContacts());
            metier.mettreAJourContact(vue.supprimerCoordonneesContact(contact));
        } catch (CoordonneeException | ContactException e) {
            e.printStackTrace();
        }
    }


}
