package net.ent.etrs.model.comparator;

import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.Mail;
import net.ent.etrs.model.entities.Telephone;
import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Comparator;

public class TypeNumeroComparator implements Comparator<Coordonnee>
{
    public TypeNumeroComparator() {
    }

    public int compare(Coordonnee coord1, Coordonnee coord2)
    {
        int valeur = 0;
        if(coord1.getTypeCoordonnee().equals(TypeCoordonnee.MAIL))
        {
            valeur = ((Mail) coord1).getAdresseMail().compareTo(((Mail) coord2).getAdresseMail());
        }
        else if (coord1.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE))
        {
            valeur = ((Telephone) coord1).getNumero().compareTo(((Telephone) coord2).getNumero());
        }
        return valeur;
    }
}
