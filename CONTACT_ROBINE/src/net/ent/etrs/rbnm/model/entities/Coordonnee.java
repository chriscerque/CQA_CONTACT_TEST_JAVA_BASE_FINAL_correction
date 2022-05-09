package net.ent.etrs.rbnm.model.entities;

import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;
import net.ent.etrs.rbnm.model.references.constantes.C;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeCoordonnee;


import java.util.Objects;

public class Coordonnee {


    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected Coordonnee( final Contact contact) throws CoordonneeException {
        this.setContact(contact);
    }

    protected Coordonnee() {
    }

    /* ****************** */
    /* ***** GETTER ***** */
    public String getId() {
        return id;
    }
    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }
    public Contact getContact() {
        return contact;
    }

    /* ****************** */
    /* ***** SETTER ***** */
    protected void setTypeCoordonnee( final TypeCoordonnee typeCoordonnee) throws CoordonneeException {
        if (Objects.isNull(typeCoordonnee)){
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }

        this.typeCoordonnee = typeCoordonnee;
    }

    private void setContact(final Contact contact) throws CoordonneeException {
        if (Objects.isNull(typeCoordonnee)){
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }
        this.contact = contact;
    }
    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnee)) return false;
        Coordonnee that = (Coordonnee) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /* ********************* */
    /* ***** TO STRING ***** */

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(typeCoordonnee.getLibelle()).append(" (");

        return sb.toString();
    }
    /* *************************** */
    /* ***** AUTRES METHODES ***** */

}
