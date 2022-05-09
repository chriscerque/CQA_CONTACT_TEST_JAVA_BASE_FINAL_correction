package net.ent.etrs.rbnm.presenter;

import net.ent.etrs.rbnm.model.entities.Contact;
import net.ent.etrs.rbnm.model.exceptions.BusinessExceptions;
import net.ent.etrs.rbnm.model.exceptions.ContactException;
import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;
import net.ent.etrs.rbnm.model.facades.ContactFacade;
import net.ent.etrs.rbnm.model.references.constantes.C;
import net.ent.etrs.rbnm.presenter.exceptions.PresenterException;
import net.ent.etrs.rbnm.view.ContactView;


import java.util.Objects;

public class Presenter implements IPresentable{


    // ********************* \\
    // ***** ATTRIBUTS ***** \\
    private ContactView contactView;
    private ContactFacade metier;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public Presenter(ContactView contactView, ContactFacade metier) throws Exception {
        this.setMetier(metier);
        this.setContactView(contactView);
    }
    /* ****************** */
    /* ***** GETTER ***** */

    public ContactView getContactView() {
        return contactView;
    }

    public ContactFacade getMetier() {
        return metier;
    }
    /* ****************** */
    /* ***** SETTER ***** */

    public void setContactView(ContactView contactView) throws Exception {
        if (Objects.isNull(contactView)){
            throw new Exception("ERR : Le paramètre vue vaut NULL" );
        }
        this.contactView = contactView;
    }

    public void setMetier(ContactFacade metier) throws Exception {
        if (Objects.isNull(metier)){
            throw new Exception("ERR : le paramètre metier vaut NULL");
        }
        this.metier = metier;
    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public void initialiser() {
        metier.init(metier);

    }

    @Override
    public void executer() throws PresenterException {
        int choixMenu = -1;
        do {
            choixMenu = contactView.afficherMenu();

            traiterOption(choixMenu);
        }while (choixMenu != 0);

    }

    @Override
    public void traiterOption(final  int choixMenu) throws PresenterException {
        switch (choixMenu) {
            case 1:
                listerContact();
                break;
            case 2:
                creerContact();
                break;
            case 3:
                supprimerContact();
                break;
            case 4:
                listerCoordonnee();
                break;
            case 5:
                ajouterCoordonne();
                break;
            case 6:
                supprimerCoordonneeContact();
                break;

        }
    }

    @Override
    public void listerContact() {
        contactView.afficherContacts(metier.listerContacts());
//        for (Contact c : metier.listerContacts()){
//            contactView.afficherContact(c);
//        }


    }

    @Override
    public void creerContact() throws PresenterException {
        try {
            metier.sauvegarderContact(contactView.saisirContact());
            contactView.afficherMessage(C.MSG_CONTACT_CREATION);

        } catch (ContactException | BusinessExceptions e) {
            throw new PresenterException(C.MSG_CONTACT_CREATION_EXCEPTION);
        }

    }

    @Override
    public void supprimerContact() throws PresenterException {
        if (this.metier.listerContacts().size() > 0) {
            try {
                this.metier.supprimerContact(contactView.selectionnerContact(metier.listerContacts()));
                contactView.afficherMessage(C.MSG_CONTACT_SUPPRESSION);
            } catch (ContactException | BusinessExceptions e) {
                throw new PresenterException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);

            }

        }
    }

    @Override
    public void listerCoordonnee() {

        contactView.afficherCoordonnees(contactView.selectionnerContact(metier.listerContacts()));

        }



    @Override
    public void ajouterCoordonne() throws PresenterException {
        try {

            contactView.saisirCoordonneesContact(contactView.selectionnerContact(metier.listerContacts()));
            contactView.afficherMessage(C.MSG_CONTACT_MISE_A_JOUR);
        } catch (CoordonneeException e) {
            throw new PresenterException(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION);
        }

    }

    @Override
    public void supprimerCoordonneeContact() throws PresenterException {
        if (this.metier.listerContacts().size() > 0) {
            try {
                contactView.saisirCoordonneesContact(contactView.selectionnerContact(metier.listerContacts()));
                contactView.afficherMessage(C.MSG_CONTACT_MISE_A_JOUR);
            } catch (CoordonneeException e) {
                throw new PresenterException(C.MSG_CONTACT_SUPPRESSION_COORDONNEE_EXCEPTION);
            }
        }

    }


}
