package net.ent.etrs.rbnm.model.comparator;

import net.ent.etrs.rbnm.model.entities.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {


    /* ********************* */
    /* ***** ATTRIBUTS ***** */

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public ContactComparator() {
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
    public int compare(Contact o1, Contact o2) {
        int comp = 0;

        comp = o1.getNom().compareTo(o2.getNom());
        if (comp == 0){
            comp = o1.getId().compareTo(o2.getId());
        }
        return comp;
    }

}
