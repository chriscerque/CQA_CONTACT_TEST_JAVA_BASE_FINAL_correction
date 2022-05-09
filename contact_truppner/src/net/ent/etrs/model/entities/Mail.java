/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.util.Objects;

/**
 * Représente une entité Mail héritant de la classe {@link Coordonnee Coordonnee}.
 * @author christophe.cerqueira
 *
 */
public class Mail extends Coordonnee {
    /////ATTRIBUTS/////
    private TypeMail typeMail;
    private String adresseMail;

    /////CONSTRUCTEUR/////
    /**
     * Constructeur avec paramètres.
     * @param contact
     * @param adresseMail
     * @param typeMail
     * @throws CoordonneeException
     */
    public Mail(final Contact contact, final TypeMail typeMail, final String adresseMail) throws CoordonneeException {
        super(contact);
        this.setTypeMail(typeMail);
        this.setAdresseMail(adresseMail);
        this.setTypeCoordonnee(TypeCoordonnee.MAIL);
    }

    /////ACCESSEURS/////
    //GETTER//
    /**
     * @return the typeMail
     */
    public TypeMail getTypeMail() {
        return typeMail;
    }

    /**
     * @return the adresseMail
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    //SETTER//
    /**
     * @param typeMail the typeMail to set
     */
    private void setTypeMail(final TypeMail typeMail) throws CoordonneeException {
        if(Objects.isNull(typeMail))
        {
            throw new CoordonneeException(C.MSG_MAIL_TYPE);
        }

        this.typeMail = typeMail;
    }

    /**
     * @param adresseMail the adresseMail to set
     * @throws CoordonneeException
     */
    private void setAdresseMail(final String adresseMail) throws CoordonneeException {
        //TODO à implémenter
        if(Objects.isNull(adresseMail))
        {
            throw new CoordonneeException(C.MSG_MAIL_NULL);
        }

        this.adresseMail = adresseMail;
    }

    /////TO STRING/////
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\t[adresseMail=%s ", this.adresseMail));
        builder.append(String.format("\typeMail=%s ]", this.typeMail));
        return builder.toString();
    }
}
