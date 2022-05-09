package net.etrs.pdi.mcd.presenter;

import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.exceptions.BusinessException;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;
import net.etrs.pdi.mcd.presenter.exceptions.PresenterException;
import net.etrs.pdi.mcd.model.facades.ContactFacade;
import net.etrs.pdi.mcd.view.exceptions.ViewException;
import net.etrs.pdi.mcd.view.facades.ContactView;

import java.util.Objects;

public class Presenter implements IPresentable {
// ***** ATTRIBUTS ***** \\
    private final ContactView vue;
    private final ContactFacade metier;

// ***** CONSTRUCTEUR ***** \\
    public Presenter(final ContactView vue, final ContactFacade metier) throws PresenterException {
        if (Objects.isNull(vue)) {
            throw new PresenterException(ConstantesModel.ERR_MODEL_NULL);
        }

        if (Objects.isNull(metier)) {
            throw new PresenterException(ConstantesModel.ERR_VIEW_NULL);
        }

        this.vue = vue;
        this.metier = metier;
    }


// ***** METHODES ***** \\

    /**
     * Initialise les données.
     */
    public void initialiser() {
        this.metier.init();
    }

    /**
     * Execution de l'application et traitement des données.
     */
    public void executer() throws PresenterException {
        int choixMenu = -1;
        do {
           choixMenu = this.vue.afficherMenu();

           switch (choixMenu) {
               case 0:
                   this.vue.afficherMessage("Au revoir !");
                   break;
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
                   listerCoordContact();
                   break;
               case 5:
                   ajouterCoordContact();
                   break;
               case 6:
                   supprimerCoordContact();
                   break;
               default:
                   this.vue.afficherMessage("Err lors du choix du menu !");
           }
        } while(choixMenu != 0);
    }

    /**
     * Cette methode permet d'afficher la liste des contacts.
     */
    private void listerContact() throws PresenterException {
        try {
            this.vue.afficherContacts(this.metier.listerContacts());
        } catch (ViewException e) {
            throw new PresenterException(e.getMessage());
        }
    }

    /**
     * Cette methode permet de creer un nouveau contact.
     */
    private void creerContact() throws PresenterException {
        try {
            this.metier.sauvegarderContact(this.vue.saisirContact());
        } catch (ViewException | BusinessException e) {
            throw new PresenterException(e.getMessage());
        }
    }

    /**
     * Cette methode permet de supprimer un contact existant.
     * La liste des contacts s'affichera avant pour en selectionner un.
     * Je verifie si il existe un contact avant de l'afficher.
     */
    private void supprimerContact() throws PresenterException {
        try {
            if (this.metier.listerContacts().size() == 0) {
                this.vue.afficherMessage(" \n\t ***** Aucun contact ! ***** \n");
            } else {
                this.metier.supprimerContact(this.vue.selectionnerContact(this.metier.listerContacts()));
            }
        } catch (BusinessException e) {
            throw new PresenterException(e.getMessage());
        }

    }

    /**
     * Cette methode permet d'afficher la liste des coordonnées d'un contact existant.
     * La liste des contacts s'affichera avant pour en selectionner un.
     */
    private void listerCoordContact() throws PresenterException {
        try {
            this.vue.afficherCoordonnees(this.vue.selectionnerContact(this.metier.listerContacts()));
        } catch (ViewException e) {
            throw new PresenterException(e.getMessage());
        }
    }

    /**
     * Cette methode permet de creer une nouvelle coordonnée pour un contact choisie precedement via une liste.
     */
    private void ajouterCoordContact() throws PresenterException {
        try {
            this.metier.mettreAJourContact(this.vue.saisirCoordonneesContact(this.vue.selectionnerContact(this.metier.listerContacts())));
        } catch (ViewException | BusinessException e) {
            throw new PresenterException(e.getMessage());
        }
    }

    /**
     * Cette methode permet de supprimer une coordonnée pour un contact choisie precedement.
     */
    private void supprimerCoordContact() throws PresenterException {
        try {
            this.metier.mettreAJourContact(this.vue.supprimerCoordonneesContact(this.vue.selectionnerContact(this.metier.listerContacts())));
        }catch (ViewException | BusinessException e) {
            throw new PresenterException(e.getMessage());
        }
    }


}
