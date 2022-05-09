package view;

import model.entities.Telephone;

public interface TelephoneView {
    /**
     * Affiche les coordonnées téléphone
     *
     * @param telephone le téléphone à afficher.
     */
    void afficherCoordonnee(Telephone telephone);

}
