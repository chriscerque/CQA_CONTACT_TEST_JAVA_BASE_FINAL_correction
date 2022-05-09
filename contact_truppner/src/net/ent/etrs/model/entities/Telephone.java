/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.util.Objects;

/**
 * @author christophe.cerqueira
 */
public class Telephone extends Coordonnee {
    /////ATTRIBUTS/////
    private String numero;
    private TypeNumero typeNumero;

    /////CONSTRUCTEUR/////
    /**
     * @throws CoordonneeException: Si un un paramètre est NULL.
     */
    public Telephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        super(contact);
        this.setNumero(numero);
        this.setTypeNumero(typeNumero);
        this.setTypeCoordonnee(TypeCoordonnee.TELEPHONE);
    }

    /////ACCESSEURS/////
    //GETTER//
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return the typeNumero
     */
    public TypeNumero getTypeNumero() {
        return typeNumero;
    }

    //SETTER//
    /**
     * @param numero the numero to set
     * @throws CoordonneeException
     */
    private void setNumero(final String numero) throws CoordonneeException {
        //TODO à implémenter
        if(Objects.isNull(numero))
        {
            throw new CoordonneeException(C.MSG_NUMERO_NULL);
        }

        this.numero = numero;
    }

    /**
     * @param typeNumero the typeNumero to set
     */
    private void setTypeNumero(final TypeNumero typeNumero) throws CoordonneeException {
        if(Objects.isNull(typeNumero))
        {
            throw new CoordonneeException(C.MSG_TYPE_NUMERO);
        }

        this.typeNumero = typeNumero;
    }

    /////TO STRING/////
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(String.format("\t[numero=%s ", this.numero));
        builder.append(String.format("\ttypeNumero=%s ]", this.typeNumero));
        return builder.toString();
    }

}
