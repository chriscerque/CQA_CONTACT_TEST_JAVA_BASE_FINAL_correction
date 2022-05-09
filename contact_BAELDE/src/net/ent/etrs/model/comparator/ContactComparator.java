package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {
    public ContactComparator() {}

    @Override
    public int compare(Contact o1, Contact o2) {
        int c = o1.getNom().compareTo(o2.getNom());
        if (c != 0) return c;
        c = o1.getPrenom().compareTo(o2.getPrenom());
        if (c != 0) return c;
        return o1.getDateNaissance().compareTo(o2.getDateNaissance());
    }
}
