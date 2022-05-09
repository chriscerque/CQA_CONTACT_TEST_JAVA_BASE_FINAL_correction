package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public abstract class Coordonnee {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    protected Coordonnee(Contact contact) throws CoordonneeException {
        this.setContact(contact);
        this.setTypeCoordonnee(TypeCoordonnee.valueOf(this.getClass().getSimpleName().toUpperCase()));
        this.id = UUID.randomUUID().toString();
    }

    protected Coordonnee() throws CoordonneeException {
        this.setTypeCoordonnee(TypeCoordonnee.valueOf(this.getClass().getName().toUpperCase()));
        this.id = UUID.randomUUID().toString();
    }

    // +-------------------------------------------+
    // |              GETTERS SETTERS              |
    // +-------------------------------------------+

    public String getId() {
        return this.id;
    }
    public TypeCoordonnee getTypeCoordonnee() {
        return this.typeCoordonnee;
    }
    public Contact getContact() {
        return this.contact;
    }

    private void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) throws CoordonneeException {
        if (Objects.isNull(typeCoordonnee)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_TYPE_NULL_EXCEPTION);
        }
        this.typeCoordonnee = typeCoordonnee;
    }

    private void setContact(Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }
        this.contact = contact;
    }

    // +-------------------------------------------+
    // |                HASH EQUALS                |
    // +-------------------------------------------+

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // +-------------------------------------------+
    // |                 TO STRING                 |
    // +-------------------------------------------+

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("id='").append(this.id).append('\'');
        sb.append(", typeCoordonnee=").append(this.typeCoordonnee);
        sb.append(", contact (id)=").append(this.contact.getId());
        sb.append('}');
        return sb.toString();
    }
}
