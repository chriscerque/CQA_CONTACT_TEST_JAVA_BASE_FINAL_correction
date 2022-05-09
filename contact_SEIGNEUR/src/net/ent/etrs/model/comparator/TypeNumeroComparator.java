package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee> {


    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        return o1.compareTo(o2);
    }
}
