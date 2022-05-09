package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.exceptions.CoordonneeException;
import ent.etrs.pdi.pre.model.references.C;
import ent.etrs.pdi.pre.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public class Coordonnee {
    /*------- ATTRIBUTS -------*/
    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;


    /*------- CONSTRUCTEUR(S) -------*/
    public Coordonnee(Contact contact) throws CoordonneeException {
        this.setContact(contact);
        this.id = UUID.randomUUID().toString();
    }

    public Coordonnee() {
        this.id = UUID.randomUUID().toString();
    }

    /*------- ASCESSEURS -------*/
    // GETTER
    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }

    // SETTER
    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    private void setContact(Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)){
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }
        this.contact = contact;
    }

    /*------- EQUALS / HASH CODE -------*/
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

    /*------- TO STRING -------*/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append(", contact=").append(contact);
        sb.append('}');
        return sb.toString();
    }
    /*------- AUTRES METHODES -------*/
}
