package ent.etrs.pdi.pre.view;

import ent.etrs.pdi.pre.model.entities.Mail;

public interface MailView {
    /**
     * Affiche les coordonnées mail
     *
     * @param mail le mail à afficher.
     */
    void afficherCoordonnee(Mail mail);

}
