package net.ent.etrs.view;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;

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
    void afficherContact(Contact contact);

    /**
     * Affiche une liste de contacts.
     *
     * @param lstContacts la liste de contacts à afficher.
     */
    void afficherContacts(List<Contact> lstContacts);

    /**
     * Demande la saisie des informations d'un contact.
     *
     * @return le contact créé.
     * @throws ContactException si une erreur de création du contact.
     */
    Contact saisirContact() throws ContactException;

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
    void afficherCoordonnees(Contact contact);

    /**
     * Demande la saisie de coordonnées pour un contact.
     *
     * @param contact le contact pour lequel ajouter des coordonnées.
     * @return le contact avec ses nouvelles coordonnées.
     * @throws CoordonneeException si une erreur survient lors de la création d'une coordonnée.
     */
    Contact saisirCoordonneesContact(Contact contact) throws CoordonneeException;

    /**
     * Demande la suppression d'une coordonnée d'un contact.
     *
     * @param contact le contact pour la suppression d'une de ses coordonnées.
     * @return le contact avec ses nouvelles coordonnées.
     * @throws CoordonneeException
     */
    Contact supprimerCoordonneesContact(Contact contact) throws CoordonneeException;
}
