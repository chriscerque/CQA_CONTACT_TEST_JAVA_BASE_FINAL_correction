package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {
	//<editor-fold desc="Attributs">
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	public TypeCoordonneeComparator() {
	}

	@Override
	public int compare(Coordonnee o1, Coordonnee o2) {
		return o1.getTypeCoordonnee().getLibelle().compareTo(o2.getTypeCoordonnee().getLibelle());
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