package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.Telephone;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee> {

    @Override
    public int compare(final Coordonnee o1, final Coordonnee o2) {
        int comp = 0;
        comp=o1.getTypeCoordonnee().compareTo(o2.getTypeCoordonnee());

        return comp;
    }

}
