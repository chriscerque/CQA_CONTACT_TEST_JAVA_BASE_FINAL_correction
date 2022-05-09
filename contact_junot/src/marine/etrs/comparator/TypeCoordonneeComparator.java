package marine.etrs.comparator;

import marine.etrs.model_Metier.entities_Class_Factory.Coordonnee;

import java.util.Comparator;

public class TypeCoordonneeComparator implements Comparator<Coordonnee> {

    public TypeCoordonneeComparator() {

    }


    /**
     * Comparation de deux objets Coordonnee entre eux
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(final Coordonnee c1, final Coordonnee c2) {
        int comp = 0;
        return comp = c1.getId().compareTo(c2.getId());
    }
}