package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.enums.TypeMail;
import net.ent.etrs.model.references.enums.TypeNumero;

import java.time.LocalDate;

public final class EntitiesFactory {

    /*--------------------------------
    Methodes permettant de faire appel 
    aux constructeurs des différentes 
    classes métierla construction
    --------------------------------*/

    public static Mail fabriquerMail(final Contact contact, final String adresseMail, final TypeMail typeMail) throws CoordonneeException {
    return new Mail(contact, adresseMail, typeMail);
    }

    public static Telephone fabriquerTelephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, numero, typeNumero);
    }

    public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, prenom, dateNaissance);
    }


    /*----------------------
    ** Constructeur privé **
    -----------------------*/
    private EntitiesFactory() {
    }

}  // fin de classe
