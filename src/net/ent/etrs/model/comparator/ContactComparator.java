/**
 * 
 */
package net.ent.etrs.model.comparator;

import java.util.Comparator;

import net.ent.etrs.model.entities.Contact;

/**
 * @author christophe.cerqueira
 *
 */
public class ContactComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact o1, Contact o2) {
		int compNom = o1.getNom().compareTo(o2.getNom());
		return compNom == 0 ? o1.getPrenom().compareTo(o2.getPrenom()) : compNom;
	}

}
