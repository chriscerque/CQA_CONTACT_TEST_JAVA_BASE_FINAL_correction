package net.ent.etrs.presenter;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.references.C;
import net.ent.etrs.view.ContactView;

import java.util.List;
import java.util.Objects;

public class ContactPresenter implements Presenter {

    private ContactView vue;
    private ContactFacade metier;

    public ContactPresenter(ContactView vue, ContactFacade metier) {
        this.setVue(vue);
        this.setMetier(metier);
    }

    //TODO CONTROLE VUE ET METIER NULL
    private void setVue(ContactView vue) {
        if (Objects.isNull(vue)) {
            throw new RuntimeException();
        }
        this.vue = vue;
    }
    private void setMetier(ContactFacade metier) {
        if (Objects.isNull(vue)) {
            throw new RuntimeException();
        }
        this.metier = metier;
    }



    public void initialiser() {
        this.metier.init();
    }

    public void executer() {
        int choixMenu;
        do {
            choixMenu = vue.afficherMenu();
            switch (choixMenu) {
                case 0:
                    break;
                case 1:
                    this.listerContacts();
                    break;
                case 2:
                    this.creerNouveauContact();
                    break;
                case 3:
                    this.supprimerContact();
                    break;
                case 4:
                    this.listerCoorContact();
                    break;
                case 5:
                    this.ajouterCoorContact();
                    break;
                case 6:
                    this.supprimerCoorContact();
                    break;
                default:
            }
        } while (choixMenu != 0);
    }



    private void listerContacts() {
        List<Contact> contacts = this.metier.listerContacts();
        if (contacts.size() == 0) {
            this.vue.afficherMessage(C.MSG_AUCUN_CONTACT);
        } else {
            this.vue.afficherContacts(contacts);
        }
    }

    private void creerNouveauContact() {
        Contact c;
        try {
            c = this.vue.saisirContact();
            try {
                this.metier.sauvegarderContact(c);
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_CREATION, c.getNom().toUpperCase(), c.getPrenom()));
            } catch (ContactException e) {
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_CREATION_EXCEPTION, c.getNom().toUpperCase(), c.getPrenom()));
            }
        } catch (ContactException e) {
            this.vue.afficherMessage(e.getMessage());
        }
    }

    private void supprimerContact() {
        List<Contact> contacts = this.metier.listerContacts();
        if (contacts.size() == 0) {
            this.vue.afficherMessage(C.MSG_AUCUN_CONTACT);
        } else {
            Contact c = this.vue.selectionnerContact(contacts);

            try {
                this.metier.supprimerContact(c);
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_SUPPRESSION, c.getNom().toUpperCase(), c.getPrenom()));
            } catch (ContactException e) {
                //TODO METTRE LE MESSAGE DANS LA DAO
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_SUPPRESSION_EXCEPTION, c.getNom().toUpperCase(), c.getPrenom()));
            }
        }
    }

    private void listerCoorContact() {
        List<Contact> contacts = this.metier.listerContacts();
        if (contacts.size() == 0) {
            this.vue.afficherMessage(C.MSG_AUCUN_CONTACT);
        } else {
            this.vue.afficherCoordonnees(this.vue.selectionnerContact(contacts));
        }
    }

    private void ajouterCoorContact() {
        List<Contact> contacts = this.metier.listerContacts();
        if (contacts.size() == 0) {
            this.vue.afficherMessage(C.MSG_AUCUN_CONTACT);
        } else {
            Contact c = this.vue.selectionnerContact(contacts);
            try {
                c = this.vue.saisirCoordonneesContact(c);
                this.metier.mettreAJourContact(c);
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_MISE_A_JOUR, c.getNom().toUpperCase(), c.getPrenom()));
            } catch (CoordonneeException | ContactException e) {
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION, c.getNom().toUpperCase(), c.getPrenom()));
            }
        }
    }

    private void supprimerCoorContact() {
        List<Contact> contacts = this.metier.listerContacts();
        if (contacts.size() == 0) {
            this.vue.afficherMessage(C.MSG_AUCUN_CONTACT);
        } else {
            Contact c = this.vue.selectionnerContact(contacts);
            try {
                c = this.vue.supprimerCoordonneesContact(c);
                this.metier.mettreAJourContact(c);
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_MISE_A_JOUR, c.getNom().toUpperCase(), c.getPrenom()));
            } catch (ContactException e) {
                this.vue.afficherMessage(String.format(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION, c.getNom().toUpperCase(), c.getPrenom()));
            } catch (CoordonneeException e) {
                this.vue.afficherMessage(C.MSG_AUCUNE_COORDONNEE);
            }
        }
    }
}
