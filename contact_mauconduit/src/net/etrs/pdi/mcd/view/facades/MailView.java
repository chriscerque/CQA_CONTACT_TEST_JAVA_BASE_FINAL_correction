package net.etrs.pdi.mcd.view.facades;


import net.etrs.pdi.mcd.model.commons.entities.Mail;

public interface MailView {
    /**
     * Affiche les coordonnées mail
     *
     * @param mail le mail à afficher.
     */
    void afficherCoordonnee(Mail mail);

}
