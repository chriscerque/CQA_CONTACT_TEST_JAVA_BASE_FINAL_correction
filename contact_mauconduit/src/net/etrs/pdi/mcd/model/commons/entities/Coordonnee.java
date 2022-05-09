package net.etrs.pdi.mcd.model.commons.entities;

import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeCoordonnee;

import java.util.Objects;
import java.util.UUID;

public class Coordonnee {
// ***** ATTRIBUTS ***** \\
    private final String id;
    private TypeCoordonnee typeCoordonnee;
    private Contact contact;

// ***** CONSTRUCTEUR ***** \\
    protected Coordonnee(final Contact contact) throws CoordonneeException {
        this.id = UUID.randomUUID().toString();
        this.setContact(contact);

    }

    protected Coordonnee() throws CoordonneeException {
        this.id = UUID.randomUUID().toString();
    }

// ***** GETTER SETTER ***** \\
    public String getId() {
        return this.id;
    }

    private void setTypeCoordonnee(final TypeCoordonnee typeCoordonnee) throws CoordonneeException {
        if (Objects.isNull(typeCoordonnee)) {
            throw new CoordonneeException(ConstantesModel.MSG_COORDONNEE_EXCEPTION);
        }

        this.typeCoordonnee = typeCoordonnee;
    }

    public TypeCoordonnee getTypeCoordonnee() throws CoordonneeException {
        if (Objects.isNull(this.typeCoordonnee)) {
            this.definirTypeCoordonnees();
        }
        return this.typeCoordonnee;
    }

    private void setContact(final Contact contact) throws CoordonneeException {
        if (Objects.isNull(contact)) {
            throw new CoordonneeException(ConstantesModel.MSG_COORDONNEE_CONTACT_NULL_EXCEPTION);
        }

        this.contact = contact;
    }

    public Contact getContact() {
        return this.contact;
    }

    // ***** TO STRING ***** \\

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coordonnee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", typeCoordonnee=").append(typeCoordonnee);
        sb.append(", contact=").append(contact);
        sb.append('}');
        return sb.toString();
    }


// ***** EQUAL HASH ***** \\

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


// ***** METHODES ***** \\

    /**
     * Cette methode permet d'attribuer à une coordonnée un type.
     * Pour cela, je parcours toutes les coordonnées existantes dans mon contact.
     * Je cherche laquelle correspond avec mon instance actuelle.
     * Si l'instance est de type Telephone ou Mail, je le set en fonction.
     * @throws CoordonneeException
     */
    public void definirTypeCoordonnees() throws CoordonneeException {
        for (Coordonnee c : this.contact.getCoordonnees()) {
            if (c.equals(this)) {
                if (c instanceof Telephone) {
                    this.setTypeCoordonnee(TypeCoordonnee.TELEPHONE);
                }

                if (c instanceof Mail) {
                    this.setTypeCoordonnee(TypeCoordonnee.MAIL);
                }
            }
        }
    }
}
