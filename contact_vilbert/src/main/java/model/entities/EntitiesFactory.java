package model.entities;

import model.entities.references.TypeMail;
import model.entities.references.TypeNumero;
import model.exceptions.ContactException;
import model.exceptions.CoordonneeException;

import java.time.LocalDate;

public final class EntitiesFactory {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    private EntitiesFactory() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, prenom, dateNaissance);
    }

    public static Coordonnee fabriquerTelephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, numero, typeNumero);
    }

    public static Coordonnee fabriquerMail(final Contact contact, final String adresseMail, final TypeMail typeMail) throws CoordonneeException {
        return new Mail(contact, adresseMail, typeMail);
    }
}
