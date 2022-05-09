/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.utils.Utilitaire;

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
        setAdresseMail(adresseMail);
        setTypeMail(typeMail);
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
    private void setTypeMail(final TypeMail typeMail) {
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
        if (Objects.isNull(adresseMail)){
            throw new CoordonneeException(C.MSG_MAIL_EXCEPTION);
        }
        if (getContact().getCoordonnees().contains(adresseMail)){
            throw new CoordonneeException(C.MSG_MAIL_EXISTANT_EXCEPTION);
        }
        Utilitaire.controlerMail(adresseMail);
        this.adresseMail=adresseMail;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\t[adresseMail=%s ", this.adresseMail));
        builder.append(String.format("\typeMail=%s ]", this.typeMail));
        return builder.toString();
    }
}
