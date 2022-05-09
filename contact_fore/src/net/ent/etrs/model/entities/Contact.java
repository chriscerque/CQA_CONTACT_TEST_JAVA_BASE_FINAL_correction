package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.MailException;
import net.ent.etrs.model.exceptions.TelephoneException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.references.TypeCoordonnee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact {
    private final List<Coordonnee> coordonnees;
    private final String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    protected Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
        this.id = UUID.randomUUID().toString();
        this.coordonnees = new ArrayList<>();
    }

    private void controlerCoordonneeNonExist(final Coordonnee c) throws MailException, TelephoneException {
        if (this.coordonnees.contains(c)){
            if (c.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)){
                throw new MailException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
            }
            if (c.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)){
                throw new TelephoneException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
            }
        }
    }

    private void controlerCoordonneeExist(final Coordonnee c) throws MailException, TelephoneException {
        if (!this.coordonnees.contains(c)){
            if (c.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)){
                throw new MailException(C.MSG_CONTACT_CREATION_EXCEPTION);
            }
            if (c.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE)){
                throw new TelephoneException(C.MSG_CONTACT_CREATION_EXCEPTION);
            }
        }
    }

    public void supprimerCoordonnees(final Coordonnee c) throws MailException, TelephoneException {
        this.controlerCoordonneeExist(c);
        this.coordonnees.remove(c);
    }

    public void ajouterCoordonnees(final Coordonnee c) throws MailException, TelephoneException {
        this.controlerCoordonneeNonExist(c);
        this.coordonnees.add(c);
    }

    public List<Coordonnee> getCoordonnees() {
        return coordonnees;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setNom(final String nom) throws ContactException {
        if (Objects.isNull(nom)){
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    public void setPrenom(final String prenom) throws ContactException {
        if (Objects.isNull(prenom)){
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    public void setDateNaissance(final LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

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
}
