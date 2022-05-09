/**
 *
 */
package net.ent.etrs.model.facade;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;

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

    void init(ContactFacade metier);
}
