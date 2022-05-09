package net.ent.etrs.rbnm.model.comparator;

import net.ent.etrs.rbnm.model.entities.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {


    /* ********************* */
    /* ***** ATTRIBUTS ***** */

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public TypeCoordonneeComparator() {
    }
    /* ****************** */
    /* ***** GETTER ***** */

    /* ****************** */
    /* ***** SETTER ***** */

    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */

    /* ********************* */
    /* ***** TO STRING ***** */

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        int comp = 0;

        comp = o1.getTypeCoordonnee().compareTo(o2.getTypeCoordonnee());

        if (comp == 0) {
            comp = o1.getId().compareTo(o2.getId());
        }

        return comp;
    }


}
