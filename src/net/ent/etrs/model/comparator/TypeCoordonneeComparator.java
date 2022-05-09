package net.ent.etrs.model.comparator;

import java.util.Comparator;

import net.ent.etrs.model.entities.Coordonnee;


public class TypeCoordonneeComparator implements Comparator<Coordonnee> {

	@Override
	public int compare(Coordonnee t1, Coordonnee t2) {
		return t1.getTypeCoordonnee().getLibelle().compareTo(t2.getTypeCoordonnee().getLibelle());
	}

}
