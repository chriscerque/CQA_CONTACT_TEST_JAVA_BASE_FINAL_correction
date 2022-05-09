package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.Mail;
import net.ent.etrs.model.entities.Telephone;
import net.ent.etrs.model.entities.TypeNumero;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee> {
	//<editor-fold desc="Attributs">
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	public TypeNumeroComparator() {
	}

	@Override
	public int compare(Coordonnee o1, Coordonnee o2) {
		int retour = 0;
		if (o1 instanceof Telephone && o2 instanceof Telephone) {
			Telephone t1 = (Telephone) o1;
			Telephone t2 = (Telephone) o2;
			retour = t1.getTypeNumero().name().compareTo(t2.getTypeNumero().name());

		} else if(o1 instanceof Mail && o2 instanceof Mail) {
			Mail m1 = (Mail) o1;
			Mail m2 = (Mail) o2;
			retour =  m1.getTypeMail().name().compareTo(m2.getTypeMail().name());
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