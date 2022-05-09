package model.entities;

import model.entities.references.TypeCoordonnee;
import model.exceptions.CoordonneeException;
import model.references.C;

import java.util.Objects;
import java.util.UUID;

public class Coordonnee {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected Coordonnee() {
    }

    protected Coordonnee(Contact contact) throws CoordonneeException {
        this.id = UUID.randomUUID().toString();
        this.setContact(contact);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    GETTERS					                      	//
    //////////////////////////////////////////////////////////////////////////////////////////

    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    SETTERS	                         				//
    //////////////////////////////////////////////////////////////////////////////////////////

    private void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) {
        this.typeCoordonnee = typeCoordonnee;
    }

    private void setContact(Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }
        this.contact = contact;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////SPECIFICS/////////////////////////////////////////

    //                                      TO STRING                                       //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append('}');
        return sb.toString();
    }

    //TODO

    //			                        EQUALS & HASH CODE					                //

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
