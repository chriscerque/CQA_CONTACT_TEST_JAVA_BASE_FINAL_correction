package net.ent.etrs.presenter;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;

import java.util.Objects;

public class Presenter {
    private ContactView view;
    private ContactFacade metier;

    protected Presenter(ContactView view, ContactFacade metier) throws PresenterException {
        this.setView(view);
        this.setMetier(metier);
    }

    private void setMetier(ContactFacade metier) throws PresenterException {
        if (Objects.isNull(metier)){
            throw new PresenterException("Le métier est null");
        }
        this.metier = metier;
    }

    private void setView(ContactView view) throws PresenterException {
        if (Objects.isNull(view)){
            throw new PresenterException("La vue est null");
        }
        this.view = view;
    }

    public void init(){
        metier.init();
    }

    public void execute(){
        int choix = -1;

        do {
            choix = view.afficherMenu();
            switch (choix){
                case 1:
                    this.listerContacts();
                    break;
                case 2:
                    try {
                        this.creerContact();
                    } catch (ContactException e) {
                        view.afficherMessage(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        this.supprimerContact();
                    } catch (ContactException e) {
                        view.afficherMessage(e.getMessage());
                    }
                    break;
                case 4:
                    this.listerCoordonnees();
                    break;
                case 5:
                    try {
                        this.ajouterCoordonnee();
                    } catch (CoordonneeException|ContactException e) {
                        view.afficherMessage(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        this.supprimerCoordonnee();
                    } catch (CoordonneeException|ContactException e) {
                        view.afficherMessage(e.getMessage());
                    }
                    break;
                case 0:
                    view.afficherMessage("Au revoir !");
                    break;
            }
        }while (choix != 0);
    }

    private void supprimerCoordonnee() throws CoordonneeException, ContactException {
        Contact contact = view.selectionnerContact(metier.listerContacts());
        contact = view.supprimerCoordonneesContact(contact);
        metier.mettreAJourContact(contact);
    }

    private void ajouterCoordonnee() throws CoordonneeException, ContactException{
        Contact contact = view.selectionnerContact(metier.listerContacts());
        contact = view.saisirCoordonneesContact(contact);
        metier.mettreAJourContact(contact);
    }

    private void listerCoordonnees() {
        Contact contact = view.selectionnerContact(metier.listerContacts());
        view.afficherCoordonnees(contact);
    }

    private void supprimerContact() throws ContactException {
        Contact deleted = view.selectionnerContact(metier.listerContacts());
        metier.supprimerContact(deleted);
    }

    private void creerContact() throws ContactException {
        metier.sauvegarderContact(view.saisirContact());
    }

    private void listerContacts() {
        view.afficherContacts(metier.listerContacts());
    }
    
}
