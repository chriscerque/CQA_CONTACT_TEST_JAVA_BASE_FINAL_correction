package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.entities.Coordonnee;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {


    @Override
    public int compare(final Contact o1, final Contact o2) {
        int comp = 0;
        comp=o1.getNom().compareTo(o2.getNom());
        if(comp==0){
            comp = o1.getPrenom().compareTo(o2.getPrenom());
        }
        return comp;
    }


}
