package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.TypeCoordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<TypeCoordonnee> {
    //TODO: à voir à la fin
    @Override
    public int compare(TypeCoordonnee c1, TypeCoordonnee c2) {
        return c1.compareTo(c2);
    }
}
