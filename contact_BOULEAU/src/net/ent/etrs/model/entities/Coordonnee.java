package net.ent.etrs.model.entities;

import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public abstract class Coordonnee {

////////////////////////////////////////////////////////////////////////////
//----------------------------- ATTRIBUTS --------------------------------//
////////////////////////////////////////////////////////////////////////////


    private Contact contact;
    private String id;
    private TypeCoordonnee typeCoordonnee;

////////////////////////////////////////////////////////////////////////////
//---------------------------- CONSTRUCTEUR ------------------------------//
////////////////////////////////////////////////////////////////////////////

    protected Coordonnee() {
    }

    protected Coordonnee(Contact contact) {
        setContact(contact);
    }

    ////////////////////////////////////////////////////////////////////////////
//---------------------------- GETTER SETTER -----------------------------//
////////////////////////////////////////////////////////////////////////////

    public Contact getContact() {
        return contact;
    }

    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    ////////////////////////////////

    //normalement en PRIVE !!!!!
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    //normalement en PRIVE !!!!!
    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }


////////////////////////////////////////////////////////////////////////////
//----------------------------- EQUAL H-CODE -----------------------------//
////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonnee that = (Coordonnee) o;
        return Objects.equals(contact, that.contact) && Objects.equals(id, that.id) && typeCoordonnee == that.typeCoordonnee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(contact, id, typeCoordonnee);
    }


////////////////////////////////////////////////////////////////////////////
//----------------------------- TO STRING --------------------------------//
////////////////////////////////////////////////////////////////////////////

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("contact=").append(contact);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append('}');
        return sb.toString();
    }


////////////////////////////////////////////////////////////////////////////
//-------------------------- AUTRES METHODES -----------------------------//
////////////////////////////////////////////////////////////////////////////


}
