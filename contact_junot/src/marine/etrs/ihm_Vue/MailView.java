package marine.etrs.ihm_Vue;

import marine.etrs.model_Metier.entities_Class_Factory.Mail;


public interface MailView {
    /**
     * Affiche les coordonnées mail
     *
     * @param mail le mail à afficher.
     */
    void afficherCoordonnee(Mail mail);

}
