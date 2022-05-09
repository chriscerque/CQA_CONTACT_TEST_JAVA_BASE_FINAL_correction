package ent.etrs.pdi.pre.model.comparator;

import ent.etrs.pdi.pre.model.entities.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {
    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        return o1.getTypeCoordonnee().compareTo(o2.getTypeCoordonnee());
    }
}
