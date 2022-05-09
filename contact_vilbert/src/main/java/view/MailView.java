package view;

import model.entities.Mail;

public interface MailView {
    /**
     * Affiche les coordonnées mail
     *
     * @param mail le mail à afficher.
     */
    void afficherCoordonnee(Mail mail);

}
