package net.ent.etrs.rbnm.view;

import net.ent.etrs.rbnm.model.entities.Telephone;

public interface TelephoneView {
    /**
     * Affiche les coordonnées téléphone
     *
     * @param telephone le téléphone à afficher.
     */
    void afficherCoordonnee(Telephone telephone);

}
