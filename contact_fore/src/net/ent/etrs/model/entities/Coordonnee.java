package net.ent.etrs.model.entities;

import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public abstract class Coordonnee {
    private final String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    protected Coordonnee() {
        this.id = UUID.randomUUID().toString();
    }

    protected Coordonnee(final Contact contact) {
        this.setContact(contact);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }

    protected void setTypeCoordonnee(final TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    protected void setContact(final Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append(", contact=").append(contact);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
