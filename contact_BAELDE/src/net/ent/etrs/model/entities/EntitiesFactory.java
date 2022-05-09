package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;

public final class EntitiesFactory {
    private EntitiesFactory() {}

    public static Contact fabriquerContact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
        //TODO METIER EXCEPTION
        return new Contact(nom, prenom, dateNaissance);
    }

    public static Coordonnee fabriquerTelephone(Contact contact, String numero, TypeNumero typeNumero) throws CoordonneeException {
        //TODO METIER EXCEPTION
        return new Telephone(contact, numero, typeNumero);
    }

    public static Coordonnee fabriquerMail(Contact contact, String adresseMail, TypeMail typeMail) throws CoordonneeException {
        //TODO METIER EXCEPTION
        return new Mail(contact, adresseMail, typeMail);
    }

    //TODO final avant les parametres
}
