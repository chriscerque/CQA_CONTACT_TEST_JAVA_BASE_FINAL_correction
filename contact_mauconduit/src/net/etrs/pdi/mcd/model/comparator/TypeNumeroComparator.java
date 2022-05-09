package net.etrs.pdi.mcd.model.comparator;

import net.etrs.pdi.mcd.model.commons.entities.Coordonnee;
import net.etrs.pdi.mcd.model.commons.entities.Mail;
import net.etrs.pdi.mcd.model.commons.entities.Telephone;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee> {

    @Override
    public int compare(Coordonnee c1, Coordonnee c2) {
        if (c1 instanceof Telephone && c2 instanceof Telephone) {
            return ((Telephone) c1).getTypeNumero().compareTo(((Telephone) c2).getTypeNumero());
        }

        if (c1 instanceof Mail && c2 instanceof Mail) {
            return ((Mail) c1).getTypeMail().compareTo(((Mail) c2).getTypeMail());
        }

        return 0;
    }
}
