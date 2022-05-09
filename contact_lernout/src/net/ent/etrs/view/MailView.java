package net.ent.etrs.view;

import net.ent.etrs.model.entities.Mail;

public interface MailView {
    /**
     * Affiche les coordonnées mail
     *
     * @param mail le mail à afficher.
     */
    void afficherCoordonnee(Mail mail);

}
