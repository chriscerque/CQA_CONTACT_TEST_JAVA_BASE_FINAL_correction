package net.ent.etrs.presenter;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.references.C;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;

import java.util.List;

/**
 * Presenter pour la gestion des contacts (selon le paradigme MVP).
 *
 * @author christophe.cerqueira
 */
public final class ContactPresenter {
    /**
     * vue de l'application.
     */
    private final ContactView vue;
    /**
     * façade métier de l'application.
     */
    private final ContactFacade metier;

    /**
     * @param vue
     * @param metier
     */
    public ContactPresenter(final ContactView vue, final ContactFacade metier) {
        this.vue = vue;
        this.metier = metier;
    }

    public void executer() {
        int choix = 0;
        do {
            // afficher le menu
            choix = this.vue.afficherMenu();

            // traitement du menu
            traiterMenu(choix);

        } while (choix != 0);

    }

    private void traiterMenu(final int choix) {
        //		"Lister les contacts",
        //		"Créer un nouveau contact",
        //		"Supprimer un contact",
        //		"Lister les coordonnée d'un contact",
        //		"Ajouter une coordonnée à un contact",
        //		"Supprimer une coordonnée à un contact"

        switch (choix) {
            case 1: // Lister les contacts
                menuAfficherContacts();
                break;
            case 2: // Créer un nouveau contact
                menuCreerContact();
                break;
            case 3: // Supprimer un contact
                menuSupprimerContact();
                break;
            case 4: // Lister les coordonnées d'un contact
                menuListerCoordonneesContact();
                break;
            case 5: // Ajouter une coordonnée à un contact
                menuAjouterCoordonneesContact();
                break;
            case 6: // Supprimer une coordonnée à un contact
                menuSupprimerCoordonneesContact();
                break;
            default:
                break;
        }

    }

    private void menuSupprimerCoordonneesContact() {
        Contact contactSelectionne = listerContact();
        try {
            this.metier.mettreAJourContact(this.vue.supprimerCoordonneesContact(contactSelectionne));
        } catch (ContactException | CoordonneeException e1) {
            this.vue.afficherMessage(e1.getMessage());
        }

    }

    private void menuAjouterCoordonneesContact() {
        Contact contactSelectionne = listerContact();
        try {

            this.metier.mettreAJourContact(this.vue.saisirCoordonneesContact(contactSelectionne));
            this.vue.afficherMessage(String.format(C.MSG_CONTACT_MISE_A_JOUR, contactSelectionne.getNom(), contactSelectionne.getPrenom()));
        } catch (ContactException | CoordonneeException e1) {
            this.vue.afficherMessage(e1.getMessage());
        }
    }

    private void menuListerCoordonneesContact() {
        Contact contactSelectionne = listerContact();
        this.vue.afficherCoordonnees(contactSelectionne);
    }

    private void menuSupprimerContact() {
        Contact contactSelectionne = listerContact();
        try {
            this.metier.supprimerContact(contactSelectionne);
            this.vue.afficherMessage(String.format(C.MSG_CONTACT_SUPPRESSION, contactSelectionne.getNom(), contactSelectionne.getPrenom()));
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }

    }


    private void menuCreerContact() {
        try {
            // je m'adresse à la vue
            Contact contactSaisie = this.vue.saisirContact();
            // je m'adresse à la facade métier
            this.metier.sauvegarderContact(contactSaisie);
            this.vue.afficherMessage(String.format(C.MSG_CONTACT_CREATION, contactSaisie.getNom(), contactSaisie.getPrenom()));
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }

    private void menuAfficherContacts() {
        // je m'adresse à la facade métier pour récupérer la liste
        // des contacts.
        List<Contact> liste = this.metier.listerContacts();

        // je m'adresse à la vue pour afficher la liste.
        this.vue.afficherContacts(liste);


    }


    private Contact listerContact() {
        List<Contact> liste = this.metier.listerContacts();
        try {
            if (liste.size() <= 0) {
                throw new PresenterException(C.MSG_AUCUN_CONTACT);
            }
        } catch (PresenterException e) {
            this.vue.afficherMessage(C.MSG_AUCUN_CONTACT);
            this.executer();
        }
        return this.vue.selectionnerContact(liste);
    }


}
