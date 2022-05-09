package net.ent.etrs.presenter;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.exceptions.MailException;
import net.ent.etrs.model.exceptions.TelephoneException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.model.facade.exceptions.BusinessException;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.console.ViewFactory;
import net.ent.etrs.view.exceptions.ViewException;

public class Presenter
{
    //attributs du presenter
    private ContactView vue;
    private ContactFacade metier;

    //constructeur du presenter
    public Presenter() {
        this.vue = ViewFactory.fabriquerContactView();
        this.metier = FacadeModelFactory.fabriquerContactModelFacade();
    }

    //methodes du presenter

    /**
     * methode permettant d'initialiser le metier
     */
    public void init()
    {
        this.metier.init();
    }

    /**
     * methode qui gere l'execution du programme
     * @throws ViewException
     * @throws BusinessException
     */
    public void start() throws ViewException, BusinessException {
        int choix = -1;

        do{
            choix = vue.afficherMenu();
            switch (choix)
            {
                case 0: vue.afficherMessage("au revoir !"); break;
                case 1: listerContact(); break;
                case 2: creerNouveauContact(); break;
                case 3: supprimerContact(); break;
                case 4: listerCoordonnees(); break;
                case 5: ajouterCoordonnees(); break;
                case 6: supprimerCoordonnees(); break;
                default: vue.afficherMessage("qu'est ce que vous faites la, c'est pas normal...");break;
            }
        }while(choix != 0);
    }

    /**
     * methode permettant d'afficher les contacts
     */
    private void listerContact()
    {
        vue.afficherContacts(metier.listerContacts());
    }

    /**
     * methode permettant de créer un nouveau contact
     * @throws ViewException
     */
    private void creerNouveauContact() throws ViewException {
        try {
            metier.sauvegarderContact(vue.saisirContact());
        } catch (ContactException e) {
            throw new ViewException(e.getMessage());
        }
    }

    /**
     * methode permettant de supprimer un contact
     * @throws BusinessException
     */
    private void supprimerContact() throws BusinessException {
        try {
            metier.supprimerContact(vue.selectionnerContact(metier.listerContacts()));
        } catch (ContactException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    /**
     * methode permettant de lister les coordonnées d'un contact
     */
    private void listerCoordonnees()
    {
        vue.afficherCoordonnees(vue.selectionnerContact(metier.listerContacts()));
    }

    /**
     * methode permettant d'ajouter des coordonnées à un contact
     * @throws ViewException
     */
    private void ajouterCoordonnees() throws ViewException {
        try {
            vue.saisirCoordonneesContact(vue.selectionnerContact(metier.listerContacts()));
        } catch (CoordonneeException | TelephoneException | MailException e) {
            throw new ViewException(e.getMessage());
        }
    }

    /**
     * methode permettant de supprimer des coordonnées à un contact
     * @throws ViewException
     */
    private void supprimerCoordonnees() throws ViewException {
        try {
            vue.supprimerCoordonneesContact(vue.selectionnerContact(metier.listerContacts()));
        } catch (CoordonneeException | MailException | TelephoneException e) {
            throw new ViewException(e.getMessage());
        }
    }
}
