/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeCoordonnee;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.utils.Utilitaire;

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
        super.setTypeCoordonnee(TypeCoordonnee.MAIL);
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
     * Verifie que l'adresse mail renseignée correspond au patterne ^(.+)@(.+)$
     * @param adresseMail the adresseMail to set
     * @throws CoordonneeException
     */
    private void setAdresseMail(final String adresseMail) throws CoordonneeException {
        Utilitaire.controlerMail(adresseMail);
        this.adresseMail=adresseMail;
    }


    /**
     * toString
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\t[adresseMail=%s ", this.adresseMail));
        builder.append(String.format("\typeMail=%s ]", this.typeMail));
        return builder.toString();
    }
}
