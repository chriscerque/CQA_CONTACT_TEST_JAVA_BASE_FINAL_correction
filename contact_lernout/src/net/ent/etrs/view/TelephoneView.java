package net.ent.etrs.view;

import net.ent.etrs.model.entities.Telephone;

public interface TelephoneView {
    /**
     * Affiche les coordonnées téléphone
     *
     * @param telephone le téléphone à afficher.
     */
    void afficherCoordonnee(Telephone telephone);

}
