package marine.etrs.model_Metier.facade;

import marine.etrs.model_Metier.entities_Class_Factory.Contact;
import marine.etrs.model_Metier.entities_Class_Factory.exception.ContactException;

import java.util.List;

public interface ContactFacade {

    /**
     * Permet initialiser des données pour l'application.
     */

    //public void initialiserApplication() throws BusinessException;


    // Exemple de methode :
    //public void creerArticle(final Article article) throws BusinessException;


    /**
     * Retourne la liste des contacts de l'application.
     *
     * @return la liste des contacts.
     */
    List<Contact> listerContacts();

    /**
     * Cré un contact dans l'application.
     *
     * @param contact le contact à créer.
     * @throws ContactException
     */
    void sauvegarderContact(Contact contact) throws ContactException;

    /**
     * Supprime un contact dans l'application.
     *
     * @param contact le contact à supprimer.
     * @throws ContactException
     */
    void supprimerContact(Contact contact) throws ContactException;

    /**
     * Mets à jour un contact dans l'application.
     *
     * @param contact le contact à mettre à jour.
     * @throws ContactException
     */
    void mettreAJourContact(Contact contact) throws ContactException;

    //void init(ContactFacade metier);
    void init();
}
