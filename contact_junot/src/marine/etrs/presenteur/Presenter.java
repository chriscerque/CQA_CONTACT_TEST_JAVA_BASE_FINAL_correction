package marine.etrs.presenteur;

import marine.etrs.ihm_Vue.ContactView;
import marine.etrs.ihm_Vue.FacadeVue;
import marine.etrs.ihm_Vue.ihm.ConstanteIHM;
import marine.etrs.ihm_Vue.ihm.exeception.VueException;
import marine.etrs.model_Metier.entities_Class_Factory.Contact;
import marine.etrs.model_Metier.entities_Class_Factory.Coordonnee;
import marine.etrs.model_Metier.entities_Class_Factory.exception.ContactException;
import marine.etrs.model_Metier.facade.ContactFacade;

import java.util.List;
import java.util.Objects;

public class Presenter {


//    FacadeVue fVue;
    ContactView fVue;


    ContactFacade fMetier;

    //public Presenter(final FacadeVue fvue, final ContactFacade fmetier) throws PresenterException {
    public Presenter(final ContactView fvue, final ContactFacade fmetier) throws PresenterException {
        if (Objects.isNull(fvue) || Objects.isNull(fmetier)) {
            throw new PresenterException("ERR NUL PRESENT");
        }

        this.fMetier = fmetier;
        this.fVue = fvue;

    }

    public void executer() throws VueException {
        int choix = 0;
        do {
            // afficher le menu

            fVue.afficherMenu();
            // traiter les options du menu
            traiterOption(choix);

        } while (choix != 0);
    }


    private void traiterOption(final int choix) {
        switch (choix) {
            case 1: //Lister les contacts
                listerContacts();

                break;

            case 2: //Créer un nouveau contact
                creeerContact();

                break;

            case 3: //Supprimer un nouveau contact
                supprimerContact();
                break;

            case 4: //lister les coordonnées d'un contact
                listeCoordonneesContact();
                break;

            case 5: //ajouter les coordonnées d'un contact
                ajouterCoordonneesContact();
                break;

            case 6: //supprimer les coordonnées d'un contact
                supprimerCoordonneesContact();
                break;

            default:
                break;
        }

    }
    /*
    CHOIX 1
     */
    private void listerContacts(){
        List<Contact> contacts = this.fMetier.listerContacts();
        this.fVue.afficherContacts(contacts);
    }

    /*
    CHOIX 2
     */
    private void creeerContact(){
        try {
            this.fMetier.mettreAJourContact(this.fVue.saisirContact());
            this.fVue.afficherMessage(ConstanteIHM.MSG_CREATION_REUSSI);
        } catch (ContactException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    CHOIX 3
     */
    private void supprimerContact(){
        try {
            this.fMetier.supprimerContact(this.fVue.saisirContact());
            this.fVue.afficherMessage(ConstanteIHM.MSG_SUPP_CONTACT_REUSSI);

        } catch (ContactException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    CHOIX 4
     */
    private void listeCoordonneesContact(){
        //TODO
//        try {
//            this.fVue.afficherCoordonnees(this.fMetier.listerContacts(this.fVue.selectionnerContact(this.fMetier.listerContacts())));
//        } catch (ContactException e) {
//            throw new RuntimeException(e);
//        }

    }

    /*
    CHOIX 5
     */

    private void ajouterCoordonneesContact(){

        //TODO
//        this.fVue.selectionnerContact(this.fMetier.listerContacts());
//        this.fVue.afficherMessage(ConstanteIHM.MSG_AJOUT_COORDONNEE_CONTACT_REUSSI);



    }

    /*
    CHOIX 6
     */
    private void supprimerCoordonneesContact(){

    }





}


