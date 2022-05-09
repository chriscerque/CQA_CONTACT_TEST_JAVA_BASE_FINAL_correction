package net.ent.etrs.model.entities;

import net.ent.etrs.model.references.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public abstract class Coordonnee {
/*----------------------
Attributs +0+1
-----------------------*/
    private Contact contact;
    private String id;
    private TypeCoordonnee typeCoordonnee;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected Coordonnee() {

    }

    protected Coordonnee(Contact contact) {
        this.setContact(contact);
        this.id = UUID.randomUUID().toString();
        if (this instanceof Telephone ) {
            this.setTypeCoordonnee(TypeCoordonnee.TELEPHONE);
        }
        else {
            this.setTypeCoordonnee(TypeCoordonnee.MAIL);
        }
    }

    /*----------------------
GETTERS
-----------------------*/

    public Contact getContact() {
        return contact;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public String getId() {
        return id;
    }

    /*----------------------
SETTERS
-----------------------*/

    private void setContact(final Contact contact) {
        this.contact = contact;
    }

    private void setTypeCoordonnee(final TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    /*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnee)) return false;
        Coordonnee that = (Coordonnee) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    /*----------------------
TOSTRING
-----------------------*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Coordonnee{");
        sb.append("contact=").append(contact);
        sb.append(", id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append('}');
        return sb.toString();
    }
    /*----------------------
AUTRES METHODES
-----------------------*/


}  // fin de classe
