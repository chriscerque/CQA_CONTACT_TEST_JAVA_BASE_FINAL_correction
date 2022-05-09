package ent.etrs.pdi.pre.view;

import ent.etrs.pdi.pre.model.entities.Telephone;

public interface TelephoneView {
    /**
     * Affiche les coordonnées téléphone
     *
     * @param telephone le téléphone à afficher.
     */
    void afficherCoordonnee(Telephone telephone);

}
