package net.ent.etrs.rbnm.model.references.enumerateds;

import net.ent.etrs.rbnm.model.commons.references.constantes.ConstantesMetier;
import net.ent.etrs.rbnm.model.references.constantes.C;
import net.ent.etrs.rbnm.model.references.exceptions.TypeCoordonneeException;

public enum TypeCoordonnee {

    TELEPHONE("Telephone"),
    MAIL("Mail");


    /* *************************** */
    /* ****** Attributs ****** */
    private String libelle;

    /* *************************** */
    /* ****** Constructeurs ****** */
    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    /* ******************** */
    /* ****** Getter ****** */
    public String getLibelle() {
        return libelle;
    }

    /* ***************************** */
    /* ****** AUTRES METHODES ****** */

    public static TypeCoordonnee getTypeCoordonneeByLibelle(final String unLibelle) throws TypeCoordonneeException {

        for (TypeCoordonnee enumRetour : TypeCoordonnee.values()) {
            if (enumRetour.getLibelle().equals(unLibelle)) {
                return enumRetour;
            }
        }
        throw new TypeCoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
    }


}
