/**
 *
 */
package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.references.TypeCoordonnee;
import ent.etrs.pdi.pre.model.references.TypeNumero;
import ent.etrs.pdi.pre.model.exceptions.CoordonneeException;
import ent.etrs.pdi.pre.model.utils.Utilitaire;

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
        super.setTypeCoordonnee(TypeCoordonnee.TELEPHONE);
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
