/**
 *
 */
package net.ent.etrs.rbnm.model.facades;


import net.ent.etrs.rbnm.model.entities.Contact;
import net.ent.etrs.rbnm.model.exceptions.BusinessExceptions;
import net.ent.etrs.rbnm.model.exceptions.ContactException;

import java.util.List;

/**
 * Façade métier proposant les opérations utiles
 * à l'application.
 *
 * @author christophe.cerqueira
 */
public interface ContactFacade {

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
    void sauvegarderContact(Contact contact) throws ContactException, BusinessExceptions;

    /**
     * Supprime un contact dans l'application.
     *
     * @param contact le contact à supprimer.
     * @throws ContactException
     */
    void supprimerContact(Contact contact) throws ContactException, BusinessExceptions;

    /**
     * Mets à jour un contact dans l'application.
     *
     * @param contact le contact à mettre à jour.
     * @throws ContactException
     */
    void mettreAJourContact(Contact contact) throws ContactException, BusinessExceptions;

    void init(ContactFacade metier);
}
