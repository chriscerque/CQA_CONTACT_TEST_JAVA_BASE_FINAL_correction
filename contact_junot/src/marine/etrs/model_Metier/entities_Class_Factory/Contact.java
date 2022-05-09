package marine.etrs.model_Metier.entities_Class_Factory;

import marine.etrs.model_Metier.entities_Class_Factory.exception.ContactException;
import marine.etrs.model_Metier.references_Constante_Enum.C;

import java.time.LocalDate;
import java.util.*;

public class Contact {
    private String id = UUID.randomUUID().toString();
    List<Coordonnee> coordonnees = new ArrayList<>();
    private String nom;
    private LocalDate dateNaissance;
    private String prenom;

    /**
     * Constructeur avec paramètres.
     * @param nom
     * @param dateNaissance
     * @param prenom
     * @throws ContactException
     */
    protected Contact(final String nom, final String prenom,final LocalDate dateNaissance ) throws ContactException {
        setNom(nom);
        setDateNaissance(dateNaissance);
		setPrenom(prenom);
    }

    public String getId() {
        return id;
    }

    public List<Coordonnee> getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(List<Coordonnee> coordonnees) throws ContactException {
        if (Objects.isNull(coordonnees)){
            throw new ContactException(C.MSG_COORDONNEE_EXCEPTION);
        }

        this.coordonnees = coordonnees;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws ContactException {
        if (Objects.isNull(nom)) {
            throw new ContactException(C.MSG_CONTACT_NOM_EXCEPTION);
        }
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {

        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) throws ContactException {

        if (Objects.isNull(dateNaissance)){
            throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
        }

        this.dateNaissance = dateNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) throws ContactException {
        if (Objects.isNull(prenom)|| prenom.isEmpty()) {
            throw new ContactException(C.MSG_CONTACT_PRENOM_EXCEPTION);
        }
        this.prenom = prenom;
    }

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


    /**
     * METHODE POUR SUPPRIMER UNE COORDONNEE DANS LA LISTE
     *
     * @param coordonnee
     */
    public void supprimerCoordonnees(Coordonnee coordonnee) throws ContactException {
        if (coordonnee == null) {
            throw new ContactException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
        }
        if (!coordonnees.contains(coordonnee)) {
            throw new ContactException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
        }

        coordonnees.remove(coordonnee);


    }

    /**
     * METHODE POUR AJOUTER UNE COORDONNEE DANS LA LISTE
     *
     * @param coordonnee
     */
    public void ajouterCoordonnees(Coordonnee coordonnee) throws ContactException {

        if (coordonnee == null) {
            throw new ContactException(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION);
        }

        if (coordonnees.contains(coordonnee)) {
            throw new ContactException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
        }
        coordonnees.add(coordonnee);

    }

}