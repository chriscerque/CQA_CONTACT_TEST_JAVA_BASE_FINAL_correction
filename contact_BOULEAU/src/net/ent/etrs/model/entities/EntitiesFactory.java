package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;

public class EntitiesFactory {


////////////////////////////////////////////////////////////////////////////
//---------------------------- CONSTRUCTEUR ------------------------------//
////////////////////////////////////////////////////////////////////////////

    private EntitiesFactory(){}


////////////////////////////////////////////////////////////////////////////
//----------------------------- FABRIQUE ---------------------------------//
////////////////////////////////////////////////////////////////////////////

    /**
     * methode permettant de fabriquer un Contact
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @return
     * @throws ContactException
     */
    public static Contact fabriquerContact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        return new Contact(nom, prenom, dateNaissance);
    }

    /**
     * methode permettant de fabriquer un mail
     * @param contact
     * @param adresseMail
     * @param typeMail
     * @return
     * @throws CoordonneeException
     */

    public static Mail fabriquerMail(final Contact contact, final String adresseMail, final TypeMail typeMail) throws CoordonneeException {
        return new Mail(contact, adresseMail, typeMail);
    }

    /**
     * methode permettant de fabriquer un Telephone
     * @param contact
     * @param numero
     * @param typeNumero
     * @return
     * @throws CoordonneeException
     */

    public static Telephone fabriquerTelephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        return new Telephone(contact, numero, typeNumero);
    }

}
