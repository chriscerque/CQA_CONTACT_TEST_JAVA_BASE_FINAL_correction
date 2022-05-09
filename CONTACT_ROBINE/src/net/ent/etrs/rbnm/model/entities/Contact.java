package net.ent.etrs.rbnm.model.entities;

import net.ent.etrs.rbnm.model.exceptions.ContactException;
import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;
import net.ent.etrs.rbnm.model.references.constantes.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Contact {

    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private List<Coordonnee> coordonnees = new ArrayList<>();
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected Contact ( final String nom, final LocalDate dateNaissance, final String prenom) throws ContactException {
        this.setNom(nom);
        this.setDateNaissance(dateNaissance);
        this.setPrenom(prenom);
    }

    /* ****************** */
    /* ***** GETTER ***** */
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

    /* ****************** */
    /* ***** SETTER ***** */
    private void setNom( final String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    private void setDateNaissance( final LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

    private void setPrenom( final String prenom) throws ContactException {
        if (Objects.isNull(prenom)) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    /* **************************** */
    /* ***** EQUAL & HASHCODE ***** */
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

    /* ********************* */
    /* ***** TO STRING ***** */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(String.format("Contact %s %s (%s)\n ",getNom(), getPrenom(), getDateNaissance()));
        sb.append("Coordonnées : \n");
        for (Coordonnee c : coordonnees){
            sb.append(c.getTypeCoordonnee().getLibelle()).append(" : ").append("\n");
        }
        return sb.toString();
    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    private void controlerCoordonneeNonExist( final Coordonnee coordonnee) throws CoordonneeException {
        for (Coordonnee c : coordonnees) {
            if (c.getTypeCoordonnee() != coordonnee.getTypeCoordonnee()) {
                throw new CoordonneeException(C.MSG_CONTACT_COORDONNEE_NONEXIST);
            }
        }


    }

    private void controlerCoordonneeExist( final Coordonnee coordonnee) throws CoordonneeException {
        for (Coordonnee c : coordonnees) {
            if (c.getTypeCoordonnee().equals(coordonnee.getTypeCoordonnee())) {
                throw new CoordonneeException(C.MSG_CONTACT_COORDONNEE_EXIST);
            }
        }
    }

    /**
     * Méthode qui permet d'ajouter un coordonné la list des coordonnées.
     * Si le coordonnées passé en paramètre est déjà présent dans la liste, une exception est levée.
     * @param coordonnee
     * @throws CoordonneeException
     */

    public void ajouterCoordonnees( final Coordonnee coordonnee) throws CoordonneeException {
        for (Coordonnee c : coordonnees) {
            if (c.getTypeCoordonnee().equals(coordonnee.getTypeCoordonnee())) {
                throw new CoordonneeException(C.MSG_CONTACT_COORDONNEE_AJOUT);
            } else {
                this.coordonnees.add(coordonnee);
            }
        }
    }

    /**
     * Méthode qui permet de supprimer un coordonnée de la liste.
     * Si le coordonné n'est pas présent dans la liste une exception est levée.
     * @param coordonnee
     * @throws CoordonneeException
     */
    public void supprimerCoordonnees( final Coordonnee coordonnee) throws CoordonneeException {
        for (Coordonnee c : coordonnees) {
            if (!c.getTypeCoordonnee().equals(coordonnee.getTypeCoordonnee())) {
                throw new CoordonneeException(C.MSG_CONTACT_COORDONNEE_SUPPR);
            } else {
                this.coordonnees.remove(coordonnee);
            }
        }

    }
}
