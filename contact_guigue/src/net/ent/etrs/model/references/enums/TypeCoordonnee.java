package net.ent.etrs.model.references.enums;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.constantes.C;
import net.ent.etrs.model.references.constantes.ConstantesMetier;

public enum TypeCoordonnee {
    /*----------------------
    ***** Listing Enum *****
    ----------------------*/
TELEPHONE("Téléphone"),
MAIL("Mail");

    /*----------------------
    **** Attributs Enum ****
    ----------------------*/
    private String libelle;

    /*---------------------
    **** Constructeurs ****
    ----------------------*/

    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    /*----------------------
        ******** Getter ********
        ----------------------*/
    public String getLibelle() {
        return libelle;
    }
    
    /*------------------------------*
    ******** Autres methodes ********
    -------------------------------*/

    public static TypeCoordonnee getTypeCoordonneeByLibelle(final String unLibelle) throws CoordonneeException {

        for (TypeCoordonnee enumRetour : TypeCoordonnee.values()) {
            if (enumRetour.getLibelle().equals(unLibelle)) {
                return enumRetour;
            }
        }
        throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
    }


}
