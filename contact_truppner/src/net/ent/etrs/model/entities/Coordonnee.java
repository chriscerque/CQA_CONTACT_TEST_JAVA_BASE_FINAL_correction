package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.util.Objects;
import java.util.UUID;

public class Coordonnee {
    /////ATTRIBUTS/////
    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    /////CONSTRUCTEURS/////
    protected Coordonnee(Contact contact) throws CoordonneeException {
        this.setContact(contact);
        this.id = String.valueOf(UUID.randomUUID());
    }

    protected Coordonnee(){}

    /////ACCESSEURS/////
    //GETTER//
    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }

    //SETTER//
    //TODO: voir pour tester en private à la fin si le temps
    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) throws CoordonneeException {
        if(Objects.isNull(typeCoordonnee))
        {
            throw new CoordonneeException(C.MSG_COORDONNEE_TYPE);
        }

        this.typeCoordonnee = typeCoordonnee;
    }

    public void setContact(Contact contact) throws CoordonneeException {
        if(Objects.isNull(contact))
        {
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }

        this.contact = contact;
    }

    /////IDENTITY/////
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

    /////TO STRING/////
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append(", contact=").append(contact);
        sb.append('}');
        return sb.toString();
    }
}
