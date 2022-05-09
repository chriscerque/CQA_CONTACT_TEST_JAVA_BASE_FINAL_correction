package net.etrs.pdi.mcd.view.facades;


import net.etrs.pdi.mcd.model.commons.entities.Telephone;

public interface TelephoneView {
    /**
     * Affiche les coordonnées téléphone
     *
     * @param telephone le téléphone à afficher.
     */
    void afficherCoordonnee(Telephone telephone);

}
