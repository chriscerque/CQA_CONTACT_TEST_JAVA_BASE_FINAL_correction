package marine.etrs.ihm_Vue;

import marine.etrs.model_Metier.entities_Class_Factory.Telephone;

public interface TelephoneView {
    /**
     * Affiche les coordonnées téléphone
     *
     * @param telephone le téléphone à afficher.
     */
    void afficherCoordonnee(Telephone telephone);

}
