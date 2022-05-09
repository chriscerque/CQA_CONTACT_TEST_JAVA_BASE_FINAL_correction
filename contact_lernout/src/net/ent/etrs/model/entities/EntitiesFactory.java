package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;

public class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Contact fabriquerContact(String s1, String s2, LocalDate localDate) throws ContactException {
        Contact contact = new Contact(s1, s2, localDate);
        return contact;
    }

    public static Coordonnee fabriquerTelephone(Contact contact, String s1, TypeNumero typeNumero) throws CoordonneeException {
        Telephone telephone = new Telephone(contact, s1, typeNumero);
        return telephone;
    }

    public static Coordonnee fabriquerMail(Contact contact, String s1, TypeMail typeMail) throws CoordonneeException {
        Mail mail = new Mail(contact, s1, typeMail);
        return mail;
    }
}


