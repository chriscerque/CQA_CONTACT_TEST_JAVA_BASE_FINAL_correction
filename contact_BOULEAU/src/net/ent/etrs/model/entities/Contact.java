package net.ent.etrs.model.entities;

import net.ent.etrs.model.comparator.TypeCoordonneeComparator;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class Contact {

////////////////////////////////////////////////////////////////////////////
//----------------------------- ATTRIBUTS --------------------------------//
////////////////////////////////////////////////////////////////////////////

    private List<Coordonnee> coordonnees;
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

////////////////////////////////////////////////////////////////////////////
//---------------------------- CONSTRUCTEUR ------------------------------//
////////////////////////////////////////////////////////////////////////////


    //todo

    public Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);

    }


////////////////////////////////////////////////////////////////////////////
//---------------------------- GETTER SETTER -----------------------------//
////////////////////////////////////////////////////////////////////////////

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


    //////////////////////


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
        if(dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        if(dateNaissance.format(DateTimeFormatter.ofPattern(C.PATTERN_DATE)) != C.PATTERN_DATE){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_FORMAT_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }


    public void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(nom)){
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }


    ////////////////////////////////////////////////////////////////////////////
//----------------------------- EQUAL H-CODE -----------------------------//
////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(coordonnees, contact.coordonnees) && Objects.equals(id, contact.id) && Objects.equals(nom, contact.nom) && Objects.equals(dateNaissance, contact.dateNaissance) && Objects.equals(prenom, contact.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordonnees, id, nom, dateNaissance, prenom);
    }


////////////////////////////////////////////////////////////////////////////
//----------------------------- TO STRING --------------------------------//
////////////////////////////////////////////////////////////////////////////

    //NOT

////////////////////////////////////////////////////////////////////////////
//-------------------------- AUTRES METHODES -----------------------------//
////////////////////////////////////////////////////////////////////////////


     /**
     * Méthode permettant de controler si les coordonnees existent
     * @param coordonnee
     * @throws CoordonneeException
     */

    private void controlerCoordonneeNonExist(Coordonnee coordonnee) throws CoordonneeException {
        if(coordonnees.contains(coordonnee)){
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
    }

    /**
     *  Méthode permettant d'ajouter des coordonnees
     * @param coordonnee
     * @throws CoordonneeException
     */

    public void ajouterCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
       controlerCoordonneeNonExist(coordonnee);
       coordonnees.add(coordonnee);
    }

    /**
     *  Méthode permettant de supprimer des coordonnees
     * @param coordonnee
     * @throws CoordonneeException
     */
    public void supprimerCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        controlerCoordonneeNonExist(coordonnee);
        coordonnees.add(coordonnee);
    }

}
