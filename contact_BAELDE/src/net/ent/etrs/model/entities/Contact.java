package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact {
    // +-------------------------------------------+
    // |                 ATTRIBUTS                 |
    // +-------------------------------------------+

    private List<Coordonnee> coordonnees;
    private String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    // +-------------------------------------------+
    // |               CONSTRUCTEURS               |
    // +-------------------------------------------+

    protected Contact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
        this.coordonnees = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    // +-------------------------------------------+
    // |              GETTERS SETTERS              |
    // +-------------------------------------------+

    public String getId() {
        return this.id;
    }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }
    public List<Coordonnee> getCoordonnees() {
        return this.coordonnees;
    }

    public void setCoordonnees(List<Coordonnee> coordonnees) {
        this.coordonnees = coordonnees;
    }

    private void setNom(String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    private void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(prenom)) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    private void setDateNaissance(LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

    // +-------------------------------------------+
    // |                HASH EQUALS                |
    // +-------------------------------------------+

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getNom(), contact.getNom()) && Objects.equals(getPrenom(), contact.getPrenom()) && Objects.equals(getDateNaissance(), contact.getDateNaissance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom(), getDateNaissance());
    }

    // +-------------------------------------------+
    // |                 TO STRING                 |
    // +-------------------------------------------+

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id='").append(this.id).append('\'');
        sb.append(", nom='").append(this.nom).append('\'');
        sb.append(", prenom='").append(this.prenom).append('\'');
        sb.append(", dateNaissance=").append(this.dateNaissance);
        sb.append('}');
        return sb.toString();
    }

    // +-------------------------------------------+
    // |              AUTRES METHODES              |
    // +-------------------------------------------+

    private void controlerCoordonneeNonExist(Coordonnee coordonnee) throws CoordonneeException {
        if (this.coordonnees.contains(coordonnee)) {
            switch (coordonnee.getTypeCoordonnee()) {
                case TELEPHONE:
                    throw new CoordonneeException(String.format(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION, ((Telephone)coordonnee).getNumero()));
                case MAIL:
                    throw new CoordonneeException(String.format(C.MSG_MAIL_EXISTANT_EXCEPTION, ((Mail)coordonnee).getAdresseMail()));
                default:
                    throw new CoordonneeException();
            }
        }
    }
    private void controlerCoordonneeExist(Coordonnee coordonnee) throws CoordonneeException {
        if (!this.coordonnees.contains(coordonnee)) {
            switch (coordonnee.getTypeCoordonnee()) {
                case TELEPHONE:
                    throw new CoordonneeException(String.format(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION, ((Telephone)coordonnee).getNumero()));
                case MAIL:
                    throw new CoordonneeException(String.format(C.MSG_MAIL_INEXISTANT_EXCEPTION, ((Mail)coordonnee).getAdresseMail()));
                default:
                    throw new CoordonneeException();
            }
        }
    }

    public void ajouterCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
        this.controlerCoordonneeNonExist(coordonnee);
        this.coordonnees.add(coordonnee);
    }

    public void supprimerCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
        this.controlerCoordonneeExist(coordonnee);
        this.coordonnees.remove(coordonnee);
    }
}
