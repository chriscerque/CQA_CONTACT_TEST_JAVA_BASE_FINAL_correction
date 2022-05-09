package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Contact {

    private List<Coordonnee> coordonnees;
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

    protected Contact(String nom, String prenom,LocalDate dateNaissance) throws ContactException {
        setNom(nom);
        setDateNaissance(dateNaissance);
        setPrenom(prenom);
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

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) throws ContactException {
        if (Objects.isNull(nom)){
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws ContactException {

        if (Objects.isNull(dateNaissance)){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

    public void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(prenom)){
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    private boolean controlerCoordonneeExist(Coordonnee coordonnee) throws CoordonneeException {
        boolean ex = false;
        if (!Objects.isNull(coordonnee)){
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
        if (getCoordonnees().contains(coordonnee)){
            ex = true;
        }
        return ex;
    }

    public void ajouterCoordonnees(Coordonnee coordonnee) throws CoordonneeException {

        if (!controlerCoordonneeExist(coordonnee)){
            coordonnees.add(coordonnee);
        }
    }

    public void supprimerCoordonnees(Coordonnee coordonnee) throws CoordonneeException {

        if (controlerCoordonneeExist(coordonnee)){
            coordonnees.remove(coordonnee);
        }
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact ");
        sb.append(nom);
        sb.append(prenom);
        sb.append(dateNaissance);
        sb.append("Coordonnées :");
        for (Coordonnee co: coordonnees) {
            sb.append(System.lineSeparator());
            sb.append(co);
        }
        return sb.toString();
    }
}
