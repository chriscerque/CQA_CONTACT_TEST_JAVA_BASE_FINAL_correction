package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee>
{
    public TypeCoordonneeComparator() {
    }

    public int compare(Coordonnee coord1, Coordonnee coord2)
    {
        return coord1.getId().compareTo(coord2.getId());
    }
}
