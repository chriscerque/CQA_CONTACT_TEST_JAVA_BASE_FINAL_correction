package marine.etrs.model_Metier.entities_Class_Factory;

import marine.etrs.model_Metier.entities_Class_Factory.exception.CoordonneeException;
import marine.etrs.model_Metier.references_Constante_Enum.C;

import java.util.Objects;
import java.util.UUID;

public class Coordonnee {
    private String id = UUID.randomUUID().toString();
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

    /**
     * Constructeur avec un paramètre.
     * @param contact
     * @throws CoordonneeException
     */

    protected Coordonnee(final Contact contact) throws CoordonneeException {
        setContact(this.contact = contact);
    }

    public String getId() {
        return id;
    }

    public TypeCoordonnee getTypeCoordonnee() {
        return typeCoordonnee;
    }

    public void setTypeCoordonnee(TypeCoordonnee typeCoordonnee) throws CoordonneeException {
        if (Objects.isNull(typeCoordonnee)) {
            throw new CoordonneeException(C.MSG_AUCUNE_COORDONNEE);
        }

        this.typeCoordonnee = typeCoordonnee;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)) {
            throw new CoordonneeException(C.MSG_CONTACT_CREATION_EXCEPTION);
        }

        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordonnee)) return false;
        Coordonnee that = (Coordonnee) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
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
}