package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.exceptions.ContactException;
import ent.etrs.pdi.pre.model.exceptions.CoordonneeException;
import ent.etrs.pdi.pre.model.references.TypeMail;
import ent.etrs.pdi.pre.model.references.TypeNumero;

import java.time.LocalDate;

public final class EntitiesFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private EntitiesFactory() {
    }

    /*------- AUTRES METHODES -------*/
    public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, dateNaissance, prenom);
    }

    public static Coordonnee fabriquerTelephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, numero, typeNumero);
    }

    public static Coordonnee fabriquerMail(final Contact contact, final String adresse, final TypeMail typeMail) throws CoordonneeException {
        return new Mail(contact, adresse, typeMail);
    }
}
