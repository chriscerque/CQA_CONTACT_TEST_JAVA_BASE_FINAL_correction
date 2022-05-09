/**
 *
 */
package model.entities;

import model.entities.references.TypeMail;
import model.exceptions.CoordonneeException;
import model.utils.Utilitaire;

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
        this.typeMail = typeMail;
        this.setAdresseMail(adresseMail);
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
        Utilitaire.controlerMail(adresseMail);
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
