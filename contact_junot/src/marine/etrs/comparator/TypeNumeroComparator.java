package marine.etrs.comparator;

import marine.etrs.model_Metier.entities_Class_Factory.Contact;
import marine.etrs.model_Metier.entities_Class_Factory.Coordonnee;
import marine.etrs.model_Metier.references_Constante_Enum.TypeNumero;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee> {

    public TypeNumeroComparator() {}

    /**
     *
     * Comparation de deux objets TypeCoordonnee entre eux
     * @param c1 the first object to be compared.
     * @param c2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Coordonnee c1, Coordonnee c2) {
        int comp = 0;
       return comp =c1.getTypeCoordonnee().compareTo(c2.getTypeCoordonnee());
    }
}