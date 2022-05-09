package net.ent.etrs.rbnm.presenter;

import net.ent.etrs.rbnm.presenter.exceptions.PresenterException;

public interface IPresentable {

    public void initialiser();

    public void executer() throws PresenterException;

    /**
     * Méthode qui permet de traiter les choix du menu menu principale;
     * la méthode fait reference a d'autres méthodes.
     * @param choixMenu
     * @throws PresenterException
     */

    void traiterOption(int choixMenu) throws PresenterException;


    /**
     * Méthode qui permet de lister les contacts.
     */
    void listerContact();

    /**
     * Méthode qui permet de creer des contacts.
     */
    void creerContact() throws PresenterException;

    /**
     * Méthode qui permet de supprimer un contact.
     */
    void supprimerContact() throws PresenterException;

    /**
     * Méthode qui permet de lister les coordonnées d'un contact.
     */
    void listerCoordonnee();

    /**
     * Méthode qui permet d'ajouter des coordonnées à un contact préalablement choisi.
     */
    void ajouterCoordonne() throws PresenterException;

    /**
     * Méthode qui permet de supprimer un coordonnées à un contact préalablement choisi.
     */
    void supprimerCoordonneeContact() throws PresenterException;

}
