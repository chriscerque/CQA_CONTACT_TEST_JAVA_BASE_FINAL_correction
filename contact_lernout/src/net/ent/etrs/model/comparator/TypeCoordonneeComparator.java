package net.ent.etrs.model.comparator;

import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Comparator;


public class TypeCoordonneeComparator implements Comparator<TypeCoordonnee> {
    @Override
    public int compare(final TypeCoordonnee o1, final TypeCoordonnee o2) {
        int comp = 0;
        comp=o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
        if(comp==0){
            comp = o1.getLibelle().compareTo(o2.getLibelle());
        }
        return comp;
    }
}
