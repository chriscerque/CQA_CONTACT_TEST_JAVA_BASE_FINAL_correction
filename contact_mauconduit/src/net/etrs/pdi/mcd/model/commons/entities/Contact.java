package net.etrs.pdi.mcd.model.commons.entities;

import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.CoordonneeException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.MailException;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.TelephoneException;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;
import net.etrs.pdi.mcd.model.commons.references.enumerated.TypeCoordonnee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact {
// ***** ATTRIBUTS ***** \\
    private final List<Coordonnee> coordonnees;
    private final String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

// ***** CONSTRUCTEUR ***** \\
    protected Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        this.id = UUID.randomUUID().toString();
        this.coordonnees = new ArrayList<>();
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }


// ***** GETTER SETTER ***** \\
    public String getId() {
        return this.id;
    }

    private void setNom(final String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(ConstantesModel.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    private void setPrenom(final String prenom) throws ContactException {
        if (Objects.isNull(prenom)) {
            throw new ContactException(ConstantesModel.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    private void setDateNaissance(final LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)) {
            throw new ContactException(ConstantesModel.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }

        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(ConstantesModel.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }

        this.dateNaissance = dateNaissance;
    }

    public LocalDate getDateNaissance() {
        return this.dateNaissance;
    }

    public List<Coordonnee> getCoordonnees() {
        return this.coordonnees;
    }

    // ***** TO STRING ***** \\

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("coordonnees=").append(coordonnees);
        sb.append(", id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append('}');
        return sb.toString();
    }

// ***** EQUAL HASH ***** \\
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


// ***** METHODES ***** \\

    /**
     * Cette méthode permet de controler si une coordonnées n'existe pas.
     * @param coordonnee: Coordonnee.
     */
    private void controlerCoordonneeNonExist(final Coordonnee coordonnee) throws TelephoneException, MailException, CoordonneeException {
        if (coordonnees.contains(coordonnee) && coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)) {
            throw new TelephoneException(ConstantesModel.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION);
        } else if (coordonnees.contains(coordonnee) && coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
            throw new MailException(ConstantesModel.MSG_MAIL_EXISTANT_EXCEPTION);
        }
    }

    /**
     * Cette méthode permet de controler si une coordonnées existe déjà.
     * @param coordonnee: Coordonnee.
     */
    private void controlerCoordonneeExist(final Coordonnee coordonnee) throws TelephoneException, MailException, CoordonneeException {
        if (!coordonnees.contains(coordonnee) && coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)) {
            throw new TelephoneException(ConstantesModel.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION);
        } else if (!coordonnees.contains(coordonnee) && coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
            throw new MailException(ConstantesModel.MSG_MAIL_INEXISTANT_EXCEPTION);
        }
    }

    /**
     * Cette méthode permet d'ajouter une coordonnée au contact.
     * @param coordonnee: Coordonnee.
     */
    public void ajouterCoordonnees(final Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(ConstantesModel.MSG_COORDONNEE_EXCEPTION);
        }

        try {
            controlerCoordonneeNonExist(coordonnee);
            this.coordonnees.add(coordonnee);

        } catch (TelephoneException | MailException e) {
            throw new CoordonneeException(e.getMessage());
        }
    }

    /**
     * Cette méthode permet de supprimer une coordonnée au contact.
     * @param coordonnee: Coordonnee.
     */
    public void supprimerCoordonnees(final Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(ConstantesModel.MSG_COORDONNEE_SUPPRESSION_EXCEPTION);
        }

        try {
            controlerCoordonneeExist(coordonnee);
            this.coordonnees.remove(coordonnee);
        } catch (TelephoneException | MailException e) {
            throw new CoordonneeException(e.getMessage());
        }
    }
}
