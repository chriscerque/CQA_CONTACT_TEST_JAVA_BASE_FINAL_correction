package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.references.enums.TypeCoordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<TypeCoordonnee> {

    @Override
    public int compare(TypeCoordonnee o1, TypeCoordonnee o2) {
        int retour = o1.name().compareTo(o2.name());
        return retour;
    }

    public TypeCoordonneeComparator() {

    }



}  // fin de classe
