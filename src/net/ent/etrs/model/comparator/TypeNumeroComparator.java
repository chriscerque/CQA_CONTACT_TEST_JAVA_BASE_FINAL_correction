package net.ent.etrs.model.comparator;

import java.util.Comparator;

import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.Mail;
import net.ent.etrs.model.entities.Telephone;
import net.ent.etrs.model.references.TypeCoordonnee;


public class TypeNumeroComparator implements Comparator<Coordonnee> {

	@Override
	public int compare(Coordonnee c1, Coordonnee c2) {
		if((c1.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)) && (c2.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE))) {
			return ((Telephone) c1).getTypeNumero().name().compareTo(((Telephone) c2).getTypeNumero().name());
		}
		if((c1.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) && (c2.getTypeCoordonnee().equals(TypeCoordonnee.MAIL))) {
			return ((Mail) c1).getTypeMail().name().compareTo(((Mail) c2).getTypeMail().name());
		}
		
		return 0;
		
	}

}
