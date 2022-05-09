package ent.etrs.pdi.pre.model.entities;

import ent.etrs.pdi.pre.model.exceptions.CoordonneeException;
import ent.etrs.pdi.pre.model.references.TypeCoordonnee;
import ent.etrs.pdi.pre.model.exceptions.ContactException;
import ent.etrs.pdi.pre.model.exceptions.MailException;
import ent.etrs.pdi.pre.model.exceptions.TelephoneException;
import ent.etrs.pdi.pre.model.references.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact {
    /*------- ATTRIBUTS -------*/
    private List<Coordonnee> coordonnees = new ArrayList<>();
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

    /*------- CONSTRUCTEUR(S) -------*/
    public Contact(String nom, LocalDate dateNaissance, String prenom) throws ContactException {
        this.setNom(nom);
        this.setDateNaissance(dateNaissance);
        this.setPrenom(prenom);
        this.id = UUID.randomUUID().toString();
    }

    /*------- ASCESSEURS -------*/
    // GETTER
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

    // SETTER
    private void setNom(String nom) throws ContactException {
        if (Objects.isNull(nom)){
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    private void setDateNaissance(LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

    private void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(prenom)){
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    /*------- EQUALS / HASH CODE -------*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(getId(), contact.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    /*------- TO STRING -------*/
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /*------- AUTRES METHODES -------*/

    /**
     * Méthode qui permet de contrôler si une coordonnées n'existe pas dans la liste.
     * @param coordonnee : Coordonnee, correspond à un élément Coordonnee
     * @throws TelephoneException, cas où c'est un téléphone
     * @throws MailException, cas où c'est un mail
     */
    private void controlerCoordonneeNonExist(Coordonnee coordonnee) throws TelephoneException, MailException {
        if (!coordonnees.contains(coordonnee)){
            if (coordonnee.getTypeCoordonnee() == TypeCoordonnee.TELEPHONE){
                throw new TelephoneException(String.format(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION,coordonnee.getContact().nom));
            } else {
                throw new MailException(String.format(C.MSG_MAIL_INEXISTANT_EXCEPTION,coordonnee.getContact().nom));
            }
        }
    }

    /**
     * Méthode qui permet de contrôler si une coordonnées existe dans la liste.
     * @param coordonnee : Coordonnee, correspond à un élément Coordonnee
     * @throws TelephoneException, cas où c'est un téléphone
     * @throws MailException, cas où c'est un mail
     */
    private void controlerCoordonneeExist(Coordonnee coordonnee) throws TelephoneException, MailException {
        if (coordonnees.contains(coordonnee)) {
            if (coordonnee.getTypeCoordonnee() == TypeCoordonnee.TELEPHONE) {
                throw new TelephoneException(String.format(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION,coordonnee.getContact().nom));
            } else {
                throw new MailException(String.format(C.MSG_MAIL_EXISTANT_EXCEPTION,coordonnee.getContact().nom));
            }
        }
    }

    /**
     * Méthode qui permet de supprimer une coordonnée de la liste du contact.
     * @param coordonnee : Coordonnee, correspond à un élément Coordonnee
     * @throws CoordonneeException, remonte une exception
     */
    public void supprimerCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        try {
            controlerCoordonneeNonExist(coordonnee);
        } catch (TelephoneException | MailException e) {
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
        this.coordonnees.remove(coordonnee);
    }

    /**
     * Méthode qui permet d'ajouter une coordonnée de la liste du contact.
     * @param coordonnee : Coordonnee, correspond à un élément Coordonnee
     * @throws CoordonneeException, remonte une exception
     */
    public void ajouterCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        try {
            controlerCoordonneeExist(coordonnee);
        } catch (TelephoneException | MailException e) {
            throw new CoordonneeException(C.MSG_COORDONNEE_EXCEPTION);
        }
        this.coordonnees.add(coordonnee);
    }
}
