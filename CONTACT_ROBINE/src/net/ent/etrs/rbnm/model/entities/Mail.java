/**
 *
 */
package net.ent.etrs.rbnm.model.entities;


import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;
import net.ent.etrs.rbnm.model.references.constantes.C;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeCoordonnee;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeMail;
import net.ent.etrs.rbnm.model.utils.Utilitaire;

import java.util.Objects;

/**
 * Représente une entité Mail héritant de la classe {@link Coordonnee Coordonnee}.
 * @author christophe.cerqueira
 *
 */
public class Mail extends Coordonnee {

    private TypeMail typeMail;
    private String adresseMail;


    /**
     * Constructeur avec paramètres.
     * @param contact
     * @param adresseMail
     * @param typeMail
     * @throws CoordonneeException
     */
    protected Mail(final Contact contact, final String adresseMail, final TypeMail typeMail) throws CoordonneeException {
        super(contact);
        this.setAdresseMail(adresseMail);
        this.setTypeMail(typeMail);

    }

    /**
     * @return the typeMail
     */
    public TypeMail getTypeMail() {
        return typeMail;
    }

    /**
     * @param typeMail the typeMail to set
     */
    private void setTypeMail(final TypeMail typeMail) throws CoordonneeException {
        if (Objects.isNull(typeMail)){
            throw new CoordonneeException(C.MSG_MAIL_EXCEPTION_NULL);
        }
        this.typeMail = typeMail;
    }

    /**
     * @return the adresseMail
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    /**
     * @param adresseMail the adresseMail to set
     * @throws CoordonneeException
     */
    private void setAdresseMail(final String adresseMail) throws CoordonneeException {
        Utilitaire.controlerTelephone(adresseMail);
        this.adresseMail = adresseMail;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\t[adresseMail=%s ", this.adresseMail));
        builder.append(String.format("\typeMail=%s ]", this.typeMail));
        return builder.toString();
    }
}
