package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Contact;

import java.util.Comparator;
import java.util.Locale;

public class ContactComparator implements Comparator<Contact> {
	//<editor-fold desc="Attributs">
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	public ContactComparator() {
	}

    @Override
    public int compare(Contact o1, Contact o2) {
        int retour = o1.getNom().toLowerCase(Locale.ROOT).compareTo(o2.getNom().toLowerCase(Locale.ROOT));
        if (retour == 0) {
            retour = o1.getPrenom().compareTo(o2.getPrenom());
        }

        return retour;
    }
    //</editor-fold>

	//<editor-fold desc="Getters">
	//</editor-fold>

	//<editor-fold desc="Setters">
	//</editor-fold>

	//<editor-fold desc="Equals & Hashcode">
	//</editor-fold>

	//<editor-fold desc="ToString">
	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	//</editor-fold>
} 