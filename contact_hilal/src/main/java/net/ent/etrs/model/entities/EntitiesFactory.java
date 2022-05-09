package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeCoordonnee;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;

public class EntitiesFactory
{
    private EntitiesFactory()
    {}

    public static Contact fabriquerContact(String nom, String prenom, LocalDate datenaiss) throws ContactException {
        return new Contact(nom, datenaiss, prenom);
    }

    public static Coordonnee fabriquerTelephone(Contact contact, String numero, TypeNumero typeNumero) throws CoordonneeException {
        Coordonnee tel = new Telephone(contact, numero, typeNumero);
        tel.setTypeCoordonnee(TypeCoordonnee.TELEPHONE);
        return tel;
    }

    public static Coordonnee fabriquerMail(Contact contact, String mail, TypeMail typeMail) throws CoordonneeException {
        Coordonnee email = new Mail(contact, mail, typeMail);
        email.setTypeCoordonnee(TypeCoordonnee.MAIL);
        return email;
    }
}
