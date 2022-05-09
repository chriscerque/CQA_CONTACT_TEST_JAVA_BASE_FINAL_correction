package model.entities;

import model.entities.references.TypeCoordonnee;
import model.exceptions.ContactException;
import model.exceptions.CoordonneeException;
import model.exceptions.MailException;
import model.exceptions.TelephoneException;
import model.references.C;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private List<Coordonnee> coordonnees = new ArrayList<>();
    private final String id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected Contact(String nom, String prenom, LocalDate dateNaissance) throws ContactException {
        this.id = UUID.randomUUID().toString();
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setDateNaissance(dateNaissance);
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    GETTERS					                      	//
    //////////////////////////////////////////////////////////////////////////////////////////

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

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    SETTERS	                         				//
    //////////////////////////////////////////////////////////////////////////////////////////

    private void setNom(String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    private void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(prenom)) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

    private void setDateNaissance(LocalDate dateNaissance) throws ContactException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(C.PATTERN_DATE);
        if (Objects.isNull(dateNaissance)) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////////////////////SPECIFICS/////////////////////////////////////////

    //                                      TO STRING                                       //

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact{");
        sb.append("id='").append(id).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", dateNaissance=").append(dateNaissance);
        sb.append('}');
        return sb.toString();
    }

    //			                        EQUALS & HASH CODE					                //

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

    //////////////////////////////////////////OTHERS//////////////////////////////////////////

    private void controlerCoordonneeNonExist(Coordonnee coordonnee) throws MailException, TelephoneException {
        for (Coordonnee uneCoordonnee : this.coordonnees) {
            if (uneCoordonnee.equals(coordonnee)) {
                if (coordonnee.getTypeCoordonnee() == TypeCoordonnee.MAIL) {
                    throw new MailException(String.format(C.MSG_MAIL_EXISTANT_EXCEPTION, coordonnee));
                } else {
                    throw new TelephoneException(String.format(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION, coordonnee));
                }
            }
        }
    }

    private void controlerCoordonneeExist(Coordonnee coordonnee) throws MailException, TelephoneException {
        boolean exist = false;
        for (Coordonnee uneCoordonnee : this.coordonnees) {
            if (uneCoordonnee.equals(coordonnee)) {
                exist = true;
            }
        }
        if (!exist) {
            if (coordonnee.getTypeCoordonnee() == TypeCoordonnee.MAIL) {
                throw new MailException(String.format(C.MSG_MAIL_INEXISTANT_EXCEPTION, coordonnee));
            } else {
                throw new TelephoneException(String.format(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION, coordonnee));
            }
        }
    }

    public void ajouterCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_CREATION_EXCEPTION);
        }
        try {
            controlerCoordonneeNonExist(coordonnee);
        } catch (MailException | TelephoneException e) {
            throw new CoordonneeException(String.format(C.MSG_CONTACT_CREATION_EXCEPTION, nom, prenom));
        }
        this.coordonnees.add(coordonnee);
    }

    public void supprimerCoordonnees(Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(C.MSG_COORDONNEE_SUPPRESSION_EXCEPTION);
        }
        try {
            controlerCoordonneeExist(coordonnee);
        } catch (MailException | TelephoneException e) {
            throw new CoordonneeException(String.format(C.MSG_CONTACT_SUPPRESSION_EXCEPTION, nom, prenom));
        }
        this.coordonnees.remove(coordonnee);
    }
}
