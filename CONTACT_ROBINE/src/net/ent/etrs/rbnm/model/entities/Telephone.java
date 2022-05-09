/**
 *
 */
package net.ent.etrs.rbnm.model.entities;


import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;
import net.ent.etrs.rbnm.model.references.constantes.C;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeNumero;
import net.ent.etrs.rbnm.model.utils.Utilitaire;

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
        Utilitaire.controlerTelephone(numero);
        //TODO à implémenter
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
    private void setTypeNumero(final TypeNumero typeNumero) throws CoordonneeException {
        if (Objects.isNull(typeNumero)){
            throw new CoordonneeException(C.MSG_TELEPHONE_EXCEPTION_NULL);
        }

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
