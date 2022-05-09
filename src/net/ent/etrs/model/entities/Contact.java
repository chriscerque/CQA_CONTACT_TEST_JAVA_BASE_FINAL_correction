/**
 *
 */
package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;
import net.ent.etrs.model.utils.Utilitaire;

import java.time.LocalDate;
import java.util.*;


/**
 * @author christophe.cerqueira
 */
public class Contact {

    private final String id = UUID.randomUUID().toString();
    private final List<Coordonnee> coordonnees = new ArrayList<>();
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;


    /**
     * Constructeur de la classe Contact avec paramètres.
     *
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @throws ContactException
     */
    protected Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
    }


    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }


    /**
     * @param nom the nom to set
     * @throws ContactException
     */
    private void setNom(final String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        if (nom.isEmpty()) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom.trim().toUpperCase();
    }


    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }


    /**
     * @param prenom the prenom to set
     * @throws ContactException
     */
    private void setPrenom(final String prenom) throws ContactException {
        if (Objects.isNull(prenom)) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        if (prenom.isEmpty()) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom.trim();
    }


    /**
     * @return the dateNaissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }


    /**
     * @param dateNaissance the dateNaissance to set
     * @throws ContactException
     */
    private void setDateNaissance(final LocalDate dateNaissance) throws ContactException {
        if (Objects.isNull(dateNaissance)) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
        }
        this.dateNaissance = dateNaissance;
    }


    /**
     * @return the coordonnees
     */
    public List<Coordonnee> getCoordonnees() {
        return Collections.unmodifiableList(coordonnees);
    }

    public void ajouterCoordonnees(final Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(C.MSG_TELEPHONE_EXCEPTION);
        }
        controlerCoordonneeExist(coordonnee);

        this.coordonnees.add(coordonnee);

    }

    public void supprimerCoordonnees(final Coordonnee coordonnee) throws CoordonneeException {
        if (Objects.isNull(coordonnee)) {
            throw new CoordonneeException(C.MSG_TELEPHONE_EXCEPTION);
        }
        controlerCoordonneeNonExist(coordonnee);
        this.coordonnees.remove(coordonnee);
    }


    private void controlerCoordonneeExist(final Coordonnee coordonnee) throws CoordonneeException {
        switch (coordonnee.getTypeCoordonnee()) {
            case TELEPHONE:
                Telephone t = (Telephone) coordonnee;
                Utilitaire.controlerTelephone(t.getNumero());
                if (this.coordonnees.contains(coordonnee)) {
                    throw new CoordonneeException(String.format(C.MSG_TELEPHONE_NUMERO_EXISTANT_EXCEPTION, t.getNumero()));
                }
                break;

            case MAIL:
                //TODO
                Mail m = (Mail) coordonnee;
                Utilitaire.controlerMail(m.toString());
                if (this.coordonnees.contains(coordonnee)) {
                    throw new CoordonneeException(String.format(C.MSG_MAIL_EXISTANT_EXCEPTION, m));
                }
                break;
            default:
                break;
        }
    }

    private void controlerCoordonneeNonExist(final Coordonnee coordonnee) throws CoordonneeException {
        switch (coordonnee.getTypeCoordonnee()) {
            case TELEPHONE:
                Telephone t = (Telephone) coordonnee;
                Utilitaire.controlerTelephone(t.getNumero());
                if (!this.coordonnees.contains(coordonnee)) {
                    throw new CoordonneeException(String.format(C.MSG_TELEPHONE_NUMERO_INEXISTANT_EXCEPTION, t.getNumero()));
                }
                break;

            case MAIL:
                //TODO
                Mail m = (Mail) coordonnee;
                Utilitaire.controlerMail(m.toString());
                if (!this.coordonnees.contains(coordonnee)) {
                    throw new CoordonneeException(String.format(C.MSG_MAIL_INEXISTANT_EXCEPTION, m));
                }
                break;
            default:
                break;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return nom.equals(contact.nom) && prenom.equals(contact.prenom) && dateNaissance.equals(contact.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, dateNaissance);
    }
}
