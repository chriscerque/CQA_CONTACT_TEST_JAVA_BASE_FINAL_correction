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
    //attributs de la class

    private List<Coordonnee> coordonnees = new ArrayList<>();
    private String id;
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;


    //constructeurs

    public Contact(String nom, LocalDate dateNaissance, String prenom) throws ContactException {
        this.id = UUID.randomUUID().toString();
        this.setNom(nom);
        this.setDateNaissance(dateNaissance);
        this.setPrenom(prenom);
    }

    //accesseurs
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws ContactException {
        if(dateNaissance.isAfter(LocalDate.now()))
        {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //methodes

    /**
     * cette methode verifiera si la coordonnée n'existe pas dans la liste pour l'ajout sinon elle enverra une exception
     * @param coordonnee: Coordonnee
     * @throws TelephoneException
     * @throws MailException
     */
    private void controllerCoodonneeNonExist(Coordonnee coordonnee) throws TelephoneException, MailException {
        int count = 0;
        for (Coordonnee coord : coordonnees) {
            if (coord.equals(coordonnee)) {
                count++;
            }
        }
        if(count != 0)
        {
            if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
                throw new MailException(C.MSG_MAIL_EXISTANT_EXCEPTION);
            }
            else if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE))
            {
                throw new TelephoneException(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION);
            }
        }
    }

    /**
     * cette methode verifiera si la coordonnée existe dans la liste pour la suppression sinon elle enverra une exception
     * @param coordonnee: Coordonnee
     * @throws TelephoneException
     * @throws MailException
     */
    private void controllerCoodonneeExist(Coordonnee coordonnee) throws TelephoneException, MailException {
        int count = 0;
        for (Coordonnee coord : coordonnees) {
            if (coord.equals(coordonnee)) {
                count++;
            }
        }
        if(count == 0)
        {
            if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.MAIL)) {
                throw new MailException(C.MSG_MAIL_INEXISTANT_EXCEPTION);
            }
            else if (coordonnee.getTypeCoordonnee().equals(TypeCoordonnee.TELEPHONE))
            {
                throw new TelephoneException(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION);
            }
        }
    }

    public void ajouterCoordonnees(Coordonnee coordonnee) throws MailException, TelephoneException {
        this.controllerCoodonneeNonExist(coordonnee);
        this.coordonnees.add(coordonnee);
    }

    public void supprimerCoordonnees(Coordonnee coordonnee) throws MailException, TelephoneException {
        this.controllerCoodonneeExist(coordonnee);
        this.coordonnees.remove(coordonnee);
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
        final StringBuffer sb = new StringBuffer("Contact");
        sb.append(" ").append(this.nom).append(" ");
        sb.append(this.prenom).append(" ");
        sb.append(this.dateNaissance.toString()).append("\n");
        return sb.toString();
    }
}
