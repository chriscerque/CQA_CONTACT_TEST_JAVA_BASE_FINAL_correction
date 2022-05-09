/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeNumero;
import net.ent.etrs.model.utils.Utilitaire;

import java.util.Objects;

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
        this.setNumero(numero);
        this.setTypeNumero(typeNumero);
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
        if (Objects.isNull(numero)) {
            throw new CoordonneeException(C.MSG_TELEPHONE_EXCEPTION);
        }
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
