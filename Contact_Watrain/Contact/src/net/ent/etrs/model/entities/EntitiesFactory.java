package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;

import java.time.LocalDate;

/**
 * Regroupe les fabriques des entités métier.
 *
 */
public final class EntitiesFactory {
    private EntitiesFactory() {
    }

    public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, prenom, dateNaissance);
    }

    public static Coordonnee fabriquerMail(final Contact contact, final String mail, final TypeMail typeMail) throws CoordonneeException {
        Coordonnee coordonnee = new Mail(contact, mail, typeMail);
        return coordonnee;
    }

    public static Coordonnee fabriquerTelephone(Contact contact, String telephone, TypeNumero typeNumero) throws CoordonneeException {
        Coordonnee coordonnee = new Telephone(contact, telephone, typeNumero);
        return coordonnee;
    }
}
