package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.Mail;
import net.ent.etrs.model.entities.Telephone;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee> {
    public TypeNumeroComparator() {}

    @Override
    public int compare(Coordonnee o1, Coordonnee o2) {
        if (o1 instanceof Mail) {
            if (o2 instanceof Mail) {
                Mail m1 = (Mail)o1;
                Mail m2 = (Mail)o2;
                return m1.getTypeMail().compareTo(m2.getTypeMail());
            } else {
                return -1;
            }
        } else if (o1 instanceof Telephone) {
            if (o2 instanceof Telephone) {
                Telephone t1 = (Telephone)o1;
                Telephone t2 = (Telephone)o2;
                return t1.getTypeNumero().compareTo(t2.getTypeNumero());
            } else {
                return 1;
            }
        }
        return 0;
    }
}
