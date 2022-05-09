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
    /////ATTRIBUTS/////
    private List<Coordonnee> coordonnees = new ArrayList<>();
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

    /////CONSTRUCTEUR/////
    protected Contact(String nom, LocalDate dateNaissance, String prenom) throws ContactException {
        this.setNom(nom);
        this.setDateNaissance(dateNaissance);
        this.setPrenom(prenom);
        this.id = String.valueOf(UUID.randomUUID());
    }

    /////ACCESSEURS/////
    //GETTER//
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

    //SETTER//
    public void setNom(String nom) throws ContactException {
        if(Objects.isNull(nom))
        {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }

        this.nom = nom;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws ContactException {
        if(Objects.isNull(dateNaissance))
        {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if(dateNaissance.isAfter(LocalDate.now()))
        {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }

        this.dateNaissance = dateNaissance;
    }

    public void setPrenom(String prenom) throws ContactException {
        if(Objects.isNull(prenom))
        {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }

        this.prenom = prenom;
    }

    /////IDENTITY/////
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

    /////METHODES/////
    /**
     * Vérifie que la coordonnée n'est pas dans la liste des coordonnées du contact.
     * @param coordonnee
     */
    private void controlerCoordonneeExist(Coordonnee coordonnee) throws CoordonneeException {
        if(coordonnees.contains(coordonnee))
        {
            coordonnees.remove(coordonnee);
        }
        else
        {
            if(coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE))
            {
                throw new CoordonneeException(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION);
            }
            if(coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL))
            {
                throw new CoordonneeException(C.MSG_MAIL_INEXISTANT_EXCEPTION);
            }
        }
    }

    /**
     * Vérifie que la coordonnée n'est pas dans la liste des coordonnées du contact.
     * @param coordonnee
     */
    private void controlerCoordonneeNonExist(Coordonnee coordonnee) throws CoordonneeException {
        if(!coordonnees.contains(coordonnee))
        {
            coordonnees.add(coordonnee);
        }
        else
        {
            if(coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE))
            {
                throw new CoordonneeException(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION);
            }
            if(coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL))
            {
                throw new CoordonneeException(C.MSG_MAIL_EXISTANT_EXCEPTION);
            }
        }
    }

    //TODO: pour ajouter et supprimer, vérifier bon fonctionnement avec exception et ajout/suppression(ordre)
    /**
     * Ajoute la coordonnée en paramètre à la liste des coordonnées du contact.
     * ATTENTION: Après vérification que la coordonnées n'est pas déjà présente dans la liste.
     * @param coordonnee
     */
    public void ajouterCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
//        controlerCoordonneeExist(coordonnee);
        coordonnees.add(coordonnee);
    }

    /**
     * Retire la coordonnée en paramètre à la liste des coordonnées du contact.
     * ATTENTION: Après vérification que la coordonnées est bien présente dans la liste.
     * @param coordonnee
     */
    public void supprimerCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
//        controlerCoordonneeNonExist(coordonnee);
        coordonnees.remove(coordonnee);
    }
}
