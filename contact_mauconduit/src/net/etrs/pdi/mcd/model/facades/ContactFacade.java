package net.etrs.pdi.mcd.model.facades;

import net.etrs.pdi.mcd.model.commons.entities.Contact;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.exceptions.BusinessException;

import java.util.List;

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
    void sauvegarderContact(Contact contact) throws BusinessException;

    /**
     * Supprime un contact dans l'application.
     *
     * @param contact le contact à supprimer.
     * @throws ContactException
     */
    void supprimerContact(Contact contact) throws BusinessException;

    /**
     * Mets à jour un contact dans l'application.
     *
     * @param contact le contact à mettre à jour.
     * @throws ContactException
     */
    void mettreAJourContact(Contact contact) throws BusinessException;

    void init();
}
