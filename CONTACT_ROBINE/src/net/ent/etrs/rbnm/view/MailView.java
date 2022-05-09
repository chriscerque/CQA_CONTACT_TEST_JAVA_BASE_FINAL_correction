package net.ent.etrs.rbnm.view;


import net.ent.etrs.rbnm.model.entities.Mail;

public interface MailView {
    /**
     * Affiche les coordonnées mail
     *
     * @param mail le mail à afficher.
     */
    void afficherCoordonnee(Mail mail);

}
