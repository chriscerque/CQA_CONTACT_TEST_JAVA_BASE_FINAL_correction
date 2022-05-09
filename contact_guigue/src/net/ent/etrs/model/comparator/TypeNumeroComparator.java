package net.ent.etrs.model.comparator;

import net.ent.etrs.model.references.enums.TypeCoordonnee;
import net.ent.etrs.model.references.enums.TypeNumero;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<TypeNumero> {

    @Override
    public int compare(TypeNumero o1, TypeNumero o2) {

        int retour = o1.name().compareTo(o2.name());

        return retour;
    }

    public TypeNumeroComparator() {

    }

}  // fin de classe
