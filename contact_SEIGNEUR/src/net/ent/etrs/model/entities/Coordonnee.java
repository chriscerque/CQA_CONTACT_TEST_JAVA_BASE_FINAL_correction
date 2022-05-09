package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;

public class Coordonnee implements Comparable<Coordonnee>{

    private Contact contact;
    private String id;
    private TypeCoordonnee typeCoordonnee;

    protected Coordonnee() {
    }

    protected Coordonnee(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    private void setContact(Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)){
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }
        this.contact = contact;
    }

    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) throws CoordonneeException {
        if (Objects.isNull(typeCoordonnee)){
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
        this.typeCoordonnee = typeCoordonnee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("contact=").append(contact);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Coordonnee o) {
        return this.typeCoordonnee.compareTo(o.typeCoordonnee);
    }
}
