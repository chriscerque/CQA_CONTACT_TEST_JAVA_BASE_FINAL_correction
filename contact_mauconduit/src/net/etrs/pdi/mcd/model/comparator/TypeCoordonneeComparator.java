package net.etrs.pdi.mcd.model.comparator;

import net.etrs.pdi.mcd.model.commons.entities.Coordonnee;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeCoordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {

    public TypeCoordonneeComparator() {

    }

    @Override
    public int compare(final Coordonnee c1, final Coordonnee c2) {

        try {
            if (c1.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)) {
                return 1;
            }
            if (c1.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
                return -1;
            }
        } catch (CoordonneeException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
