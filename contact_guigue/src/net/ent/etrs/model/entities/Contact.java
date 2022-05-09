package net.ent.etrs.model.entities;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.constantes.C;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact{
/*----------------------
Attributs +0+1
-----------------------*/
    private String id = UUID.randomUUID().toString().substring(0,10);
    private String nom;
    private String prenom;
	private LocalDate dateNaissance;
    private List<Coordonnee> coordonnees = new ArrayList<Coordonnee>();

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

	protected Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
		setNom(nom);
		setPrenom(prenom);
		setDateNaissance(dateNaissance);
	}

	private Contact() {}
/*----------------------
GETTERS
-----------------------*/

    /**
     * Méthode permettant d'identifier une instance de manière unique au sein de la DAO.
     *
     * @return String identifiant de l'instance
     */
    public String getId() {
        return this.id;
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

	public List<Coordonnee> getCoordonnees() {
		return coordonnees;
	}
/*----------------------
SETTERS
-----------------------*/

	public void setId(String id) {
		this.id = id;
	}

	public void setNom(String unNom) {
		this.nom = unNom;
	}

	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}

	public void setDateNaissance(LocalDate uneDateNaissance) throws ContactException {

		if (uneDateNaissance == null ) {
			throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_EXCEPTION);
		}
		if(!C.PATTERN_DATE.matches(String.valueOf(uneDateNaissance))) {
			throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
		}
		if(uneDateNaissance.isAfter(LocalDate.now())){
			throw new ContactException(C.MSG_CONTACT_DATE_NAISSANCE_INVALIDE_EXCEPTION);
		}
		this.dateNaissance = uneDateNaissance;
	}

	public void setCoordonnees(List<Coordonnee> coordonnees) {
		this.coordonnees = coordonnees;
	}
/*----------------------
EQUALS & HASHCODE
-----------------------*/

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Contact)) return false;
		Contact personne = (Contact) o;
		return getId().equals(personne.getId());
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
		final StringBuilder sb = new StringBuilder("Contact ");
		sb.append(nom).append(' ').append(prenom).append(' ');
		sb.append('(').append(dateNaissance).append(')');
		sb.append(System.lineSeparator());
		sb.append("Coordonnées : ");
		for (Coordonnee c : coordonnees) {
			sb.append(c.toString());
		}
		return sb.toString();
	}
/*----------------------
AUTRES METHODES
-----------------------*/

	private void controlerCoordonneeNonExist(Coordonnee uneCoordonnee) throws CoordonneeException {

		if (this.coordonnees.contains(uneCoordonnee)){
			throw new CoordonneeException(C.COORDONNEE_EXISTANTE);
		}
	}

	private void controlerCoordonneeExist(Coordonnee uneCoordonnee) throws CoordonneeException {
		if (!this.coordonnees.contains(uneCoordonnee)){
			throw new CoordonneeException(C.COORDONNEE_INEXISTANTE);
		}
	}
	public void supprimerCoordonnees(Coordonnee uneCoordonnee) throws CoordonneeException {

		controlerCoordonneeExist(uneCoordonnee);
		coordonnees.remove(uneCoordonnee);

	}
	public void ajouterCoordonnees(Coordonnee uneCoordonnee) throws CoordonneeException {
		controlerCoordonneeNonExist(uneCoordonnee);
		coordonnees.add(uneCoordonnee);
	}


}  // fin de classe

//TODO: Création Class Personne
// 1-Attributs
// 2-GETTERS
// 3-SETTERS + REGLES DE GESTION
// 4-CONSTRUCTEUR - utiliser les SETTERS
// 5-EQUALS&HASHCODE
// 6-TOSTRING() - avec StringBuilder