/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

/**
 * Classe abstraite représentant une coordonnée.
 * @author christophe.cerqueira
 *
 */
public abstract class Coordonnee {

    /**
     * Identifiant de la personne.
     */
    private final String id = UUID.randomUUID().toString();
    private Contact contact;
    private TypeCoordonnee typeCoordonnee;

    /**
     *
     */
    protected Coordonnee() {
        setTypeCoordonnee(TypeCoordonnee.valueOf(this.getClass().getSimpleName().toUpperCase()));
    }

    /**
     * @param contact
     * @throws CoordonneeException
     */
    protected Coordonnee(final Contact contact) throws CoordonneeException {
        setContact(contact);
        setTypeCoordonnee(TypeCoordonnee.valueOf(this.getClass().getSimpleName().toUpperCase()));
    }

    /**
     * Retourne le contact associé à la coordonnée.
     * @return contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * Affecte un contact à la coordonnée.
     * Une exception est levée si le contact est null.
     * @param contact the contact to set
     * @throws CoordonneeException
     */
    private void setContact(final Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }
        this.contact = contact;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne le {@link TypeCoordonnee type} de la coordonnée.
     * @return typeCoordonnee
     */
    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    /**
     * @param typeCoordonnee the typeCoordonnee to set
     */
    private void setTypeCoordonnee(final TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordonnee other = (Coordonnee) obj;
        if (id == null) {
			return other.id == null;
        } else return id.equals(other.id);
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s [id=", this.getClass().getSimpleName()));
        builder.append(id);
        builder.append(", contact=");
        builder.append(contact.toString());
        builder.append(", typeCoordonnee=");
        builder.append(typeCoordonnee);
        builder.append("]");
        return builder.toString();
    }


}
