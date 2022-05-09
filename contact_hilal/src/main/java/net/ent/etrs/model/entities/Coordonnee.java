package net.ent.etrs.model.entities;

import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public class Coordonnee
{
    //attributs de la class

    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    //constructeurs
    public Coordonnee(Contact contact) {
        this.id = UUID.randomUUID().toString();
        this.setContact(contact);
    }

    public Coordonnee() {
    }

    //accesseurs


    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }

    protected void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    private void setContact(Contact contact) {
        this.contact = contact;
    }

    //methodes

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
        final StringBuffer sb = new StringBuffer(typeCoordonnee.getLibelle());
        return sb.toString();
    }
}
