/**
 *
 */
package marine.etrs.model_Metier.entities_Class_Factory;

import marine.etrs.model_Metier.entities_Class_Factory.exception.CoordonneeException;
import marine.etrs.model_Metier.references_Constante_Enum.TypeNumero;
import marine.etrs.model_Metier.utilitaire.Utilitaire;

/**
 * @author christophe.cerqueira
 */
public class Telephone extends Coordonnee {

    private String numero;
    private TypeNumero typeNumero;

    /**
     * @throws CoordonneeException
     */
//    protected Telephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
//    }


    public Telephone(final Contact contact, final String numero, final TypeNumero typeNumero) throws CoordonneeException {
        super(contact);
        this.numero = numero;
        this.typeNumero = typeNumero;
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
