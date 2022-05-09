package net.etrs.pdi.mcd.model.comparator;

import net.etrs.pdi.mcd.model.commons.entities.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getNom().compareTo(o2.getNom());
    }
}
