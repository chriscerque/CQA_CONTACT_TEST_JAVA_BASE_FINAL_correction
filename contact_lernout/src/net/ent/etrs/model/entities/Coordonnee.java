package net.ent.etrs.model.entities;

import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public abstract class Coordonnee {
    private Contact contact;
    private String id;
    private TypeCoordonnee typeCoordonnee;

    protected Coordonnee(Contact contact) {
        this.setContact(contact);
        this.setId();

    }

    protected Coordonnee() {
    }

    /**
     * Setter Getter
     */
    public Contact getContact() {
        return contact;
    }

    private void setContact(Contact contact){
        this.contact = contact;
    }

    private String getId() {
        return id;
    }

    public void setId() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) {
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
}
