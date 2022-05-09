/**
 *
 */
package net.etrs.pdi.mcd.model.commons.entities;

import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeMail;

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
        if (Objects.isNull(adresseMail) || !adresseMail.matches("^(.+)@(.+)$")) {
            throw new CoordonneeException(ConstantesModel.MSG_EMAIL_INVALIDE);
        }

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
