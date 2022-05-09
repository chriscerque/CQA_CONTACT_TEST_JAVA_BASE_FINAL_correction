/**
 *
 */
package model.entities;

import model.entities.references.TypeNumero;
import model.exceptions.CoordonneeException;
import model.references.C;
import model.utils.Utilitaire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author christophe.cerqueira
 */
public class Telephone extends Coordonnee {

    private String numero;
    private TypeNumero typeNumero;

    /**
     * @throws CoordonneeException
     */

    protected Telephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        super(contact);
        this.typeNumero = typeNumero;
        this.setNumero(numero);
    }


    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     * @throws CoordonneeException
     */
    private void setNumero(final String numero) throws CoordonneeException {
        Utilitaire.controlerTelephone(numero);
        this.numero = numero;
    }


    /**
     * @return the typeNumero
     */
    public TypeNumero getTypeNumero() {
        return typeNumero;
    }


    /**
     * @param typeNumero the typeNumero to set
     */
    private void setTypeNumero(final TypeNumero typeNumero) {
        this.typeNumero = typeNumero;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\t[numero=%s ", this.numero));
        builder.append(String.format("\ttypeNumero=%s ]", this.typeNumero));
        return builder.toString();
    }


}
