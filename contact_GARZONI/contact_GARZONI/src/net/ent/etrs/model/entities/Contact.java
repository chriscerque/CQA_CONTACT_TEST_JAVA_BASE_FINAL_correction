package net.ent.etrs.model.entities;

import net.ent.etrs.model.dao.common.ID;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact implements ID<String> {
/*----------------------
Attributs +0+1
-----------------------*/
	private List<Coordonnee> coordonnees = new ArrayList<>();
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

    protected Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        this.setNom(nom);
        this.setDateNaissance(dateNaissance);
        this.setPrenom(prenom);
        this.id = UUID.randomUUID().toString();
    }

    /*----------------------
GETTERS
-----------------------*/

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
    /*----------------------
SETTERS
-----------------------*/

    private void setDateNaissance(final LocalDate dateNaissance) throws ContactException {
        if(Objects.isNull(dateNaissance)){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if(dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = LocalDate.parse(dateNaissance.format(DateTimeFormatter.ofPattern(C.PATTERN_DATE)));
    }

    private void setNom(final String nom) throws ContactException {
        if(Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    private void setPrenom(final String prenom) throws ContactException {
        if(Objects.isNull(prenom)) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    /*----------------------
EQUALS & HASHCODE
-----------------------*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return getId().equals(contact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    /*----------------------
TOSTRING
-----------------------*/

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Contact{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }
    /*----------------------
AUTRES METHODES
-----------------------*/

    public void ajouterCoordonnees(final Coordonnee coord) throws CoordonneeException {
        this.controlerCoordonneesExist(coord);
        this.coordonnees.add(coord);
    }

    public void supprimerCoordonnees(final Coordonnee coord) throws CoordonneeException {
        this.controlerCoordonneesNonExist(coord);
        this.coordonnees.remove(coord);
    }

    private void controlerCoordonneesExist(final Coordonnee coord) throws CoordonneeException {
        if(this.coordonnees.contains(coord)){
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
    }

    private void controlerCoordonneesNonExist(final Coordonnee coord) throws CoordonneeException {
        if(!this.coordonnees.contains(coord)){
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
    }


}  // fin de classe
