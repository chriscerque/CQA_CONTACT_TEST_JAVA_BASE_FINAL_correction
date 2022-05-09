package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeCoordonnee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact {
    private List<Coordonnee> coordonnees;
    private String id, nom, prenom;
    private LocalDate dateNaissance;

    protected Contact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
        this.setId();
        this.coordonnees = new ArrayList<>();
    }

    /**
     * Setter Getter
     */
    public List<Coordonnee> getCoordonnees() {
        return coordonnees;
    }

    public String getId() {
        return id;
    }

    private void setId() {
        this.id = String.valueOf(UUID.randomUUID());
    }

    public String getNom() {
        return nom;
    }

    private void setNom(String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    private void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(prenom)) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    /**
     * Vérifie que la date de naissance n'est pas après la date actuelle
     *
     * @param dateNaissance
     * @throws ContactException
     */
    private void setDateNaissance(LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }


    public void ajouterCoordonnees(Coordonnee coordonnee) {
        try {
            controlerCoordonneeExist(coordonnee);
        } catch (ContactException e) {
            e.printStackTrace();
        }
        this.coordonnees.add(coordonnee);
    }


    public void supprimerCoordonnees(Coordonnee coordonnee) {
        try {
            controlerCoordonneeNonExist(coordonnee);
        } catch (ContactException e) {
            e.printStackTrace();
        }
        this.coordonnees.remove(coordonnee);
    }
    /**
     * Equals #Code
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contact{");
        sb.append("coordonnees=").append(coordonnees);
        sb.append(", id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Functions
     */

    /**
     * Utilisé pour vérifier si la coordonnée existe lors de l'ajout
     *
     * @param coordonnee
     * @throws ContactException
     */
    private void controlerCoordonneeExist(Coordonnee coordonnee) throws ContactException {
        if (coordonnees.contains(coordonnee)) {
            if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
                throw new ContactException(C.MSG_MAIL_EXISTANT_EXCEPTION);
            } else if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)) {
                throw new ContactException(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION);
            }
        }
    }

    /**
     * Utilisé pour vérifier si la coordonnée existe lors de la suppression
     *
     * @param coordonnee
     * @throws ContactException
     */
    private void controlerCoordonneeNonExist(Coordonnee coordonnee) throws ContactException {
        if (coordonnees.contains(coordonnee)) {
            if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
                throw new ContactException(C.MSG_MAIL_INEXISTANT_EXCEPTION);
            } else if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)) {
                throw new ContactException(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION);
            }
        }

    }


}
