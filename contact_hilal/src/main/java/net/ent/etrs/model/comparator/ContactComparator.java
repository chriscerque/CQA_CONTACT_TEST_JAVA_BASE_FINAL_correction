package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Contact;

import java.util.Comparator;

public class ContactComparator implements Comparator<Contact>
{
    public ContactComparator() {
    }

    public int compare(Contact cont1, Contact cont2)
    {
        return cont1.getId().compareTo(cont2.getId());
    }
}
