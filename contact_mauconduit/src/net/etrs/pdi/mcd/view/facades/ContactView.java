package net.etrs.pdi.mcd.view.facades;

import net.etrs.pdi.mcd.model.commons.entities.Contact;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.view.exceptions.ViewException;

import java.util.List;

public interface ContactView {

    /**
     * Affiche un message.
     *
     * @param msg le message à affciher.
     */
    void afficherMessage(String msg);

    /**
     * Affiche le menu de l'application.
     *
     * @return
     */
    int afficherMenu();

    /**
     * Affiche un contact.
     *
     * @param contact le contact à afficher.
     */
    void afficherContact(Contact contact) throws ViewException;

    /**
     * Affiche une liste de contacts.
     *
     * @param lstContacts la liste de contacts à afficher.
     */
    void afficherContacts(List<Contact> lstContacts) throws ViewException;

    /**
     * Demande la saisie des informations d'un contact.
     *
     * @return le contact créé.
     */
    Contact saisirContact() throws ViewException;

    /**
     * Affiche la liste des contacts et demande la sélection d'un contact.
     *
     * @param lstContacts la liste de contacts à afficher.
     * @return le contact sélectionné.
     */
    Contact selectionnerContact(List<Contact> lstContacts);

    /**
     * Affiche les coordonnées d'un contact.
     *
     * @param contact le contactpour affichage de ses coordonnées.
     */
    void afficherCoordonnees(Contact contact) throws ViewException;

    /**
     * Demande la saisie de coordonnées pour un contact.
     *
     * @param contact le contact pour lequel ajouter des coordonnées.
     * @return le contact avec ses nouvelles coordonnées.
     * @throws CoordonneeException si une erreur survient lors de la création d'une coordonnée.
     */
    Contact saisirCoordonneesContact(Contact contact) throws ViewException;

    /**
     * Demande la suppression d'une coordonnée d'un contact.
     *
     * @param contact le contact pour la suppression d'une de ses coordonnées.
     * @return le contact avec ses nouvelles coordonnées.
     * @throws CoordonneeException
     */
    Contact supprimerCoordonneesContact(Contact contact) throws ViewException;
}
