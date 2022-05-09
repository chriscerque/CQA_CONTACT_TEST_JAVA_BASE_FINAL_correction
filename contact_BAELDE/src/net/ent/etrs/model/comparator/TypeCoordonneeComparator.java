package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {
    public TypeCoordonneeComparator() {}


    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
    }
}
