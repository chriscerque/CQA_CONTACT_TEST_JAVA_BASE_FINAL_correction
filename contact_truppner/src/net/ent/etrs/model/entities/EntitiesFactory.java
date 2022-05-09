package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;

import java.time.LocalDate;

public class EntitiesFactory {
    /////CONSTRUCTEUR/////
    private EntitiesFactory(){}

    /////METHODES/////
    public static Contact fabriquerContact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, dateNaissance, prenom);
    }

    public static Telephone fabriquerTelephone(Contact contact, String numero, TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, numero, typeNumero);
    }

    public static Mail fabriquerMail(Contact contact, TypeMail typeMail, String adresseMail) throws CoordonneeException {
        return new Mail(contact, typeMail, adresseMail);
    }
}
