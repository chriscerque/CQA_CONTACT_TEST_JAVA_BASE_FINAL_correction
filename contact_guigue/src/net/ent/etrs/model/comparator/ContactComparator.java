package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {


    @Override
    public int compare(Contact o1, Contact o2) {

        int retour = o1.getNom().compareToIgnoreCase(o2.getNom());
        if (retour == 0) {
            o1.getPrenom().compareToIgnoreCase(o2.getPrenom());
        }
        if (retour == 0) {
            o1.getDateNaissance().compareTo(o2.getDateNaissance());
        }
        return retour;
    }



/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    public ContactComparator() {

    }

}  // fin de classe
