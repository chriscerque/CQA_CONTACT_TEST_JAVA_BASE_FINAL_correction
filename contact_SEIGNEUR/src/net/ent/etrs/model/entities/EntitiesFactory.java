package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;

public class EntitiesFactory {

    private EntitiesFactory() {
    }

    public static Contact fabriquerContact(String Nom, String Prenom, LocalDate date) throws ContactException {
        Contact contact = null;

        contact = new Contact(Nom, Prenom, date);

        return contact;
    }

    public static Telephone fabriquerTelephone(Contact contact, String num, TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, num, typeNumero);
    }

    public static Mail fabriquerMail(Contact contact, String adresse, TypeMail typeMail) throws CoordonneeException {
        return new Mail (contact, adresse, typeMail);
    }
}
