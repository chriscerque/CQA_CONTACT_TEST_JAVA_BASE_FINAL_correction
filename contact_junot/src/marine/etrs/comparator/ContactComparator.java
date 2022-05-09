package marine.etrs.comparator;

import marine.etrs.model_Metier.entities_Class_Factory.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {

    public ContactComparator() {

    }


    /**
     * Comparation de deux objets Contact entre eux
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Contact c1, Contact c2) {
        int comp = 0;
        comp = c1.getNom().compareTo(c2.getNom());
        if (comp==0){
            comp = c1.getPrenom().compareTo(c2.getPrenom());
        }
        return comp;
    }
}