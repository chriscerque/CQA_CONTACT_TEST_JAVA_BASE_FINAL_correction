package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;

public class EntitiesFactory {

    private EntitiesFactory(){}

    public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, prenom, dateNaissance);
    }

    public static Coordonnee fabriquerMail(final Contact contact, final String adresseMail, final TypeMail typeMail) throws CoordonneeException {
        return new Mail(contact, adresseMail, typeMail);
    }

    public static Coordonnee fabriquerTelephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, numero, typeNumero);
    }
}
