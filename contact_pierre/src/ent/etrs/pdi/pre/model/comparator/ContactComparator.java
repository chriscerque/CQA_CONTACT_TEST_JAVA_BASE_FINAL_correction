package ent.etrs.pdi.pre.model.comparator;

import ent.etrs.pdi.pre.model.entities.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
