package net.ent.etrs.model.entities;

import net.ent.etrs.model.dao.Identifiable;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.C;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Contact implements Identifiable<String> {
	//<editor-fold desc="Attributs">
	private List<Coordonnee> coordonnees = new ArrayList<Coordonnee>();
	private String id = UUID.randomUUID().toString();
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;

	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	protected Contact(final String nom, final String prenom, final LocalDate dateNaissance) throws ContactException {
		setNom(nom);
		setPrenom(prenom);
		setDateNaissance(dateNaissance);
	}
	//</editor-fold>

	//<editor-fold desc="Getters">

	public List<Coordonnee> getCoordonnees() {
		return coordonnees;
	}

	@Override
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

	//</editor-fold>

	//<editor-fold desc="Setters">

	private void setNom(final String nom) {
		this.nom = nom;
	}

	private void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	private void setDateNaissance(final LocalDate dateNaissance) throws ContactException {
		if(Objects.isNull(dateNaissance)) throw new ContactException("La date de naissance doit être renseignée");
		if(dateNaissance.isAfter(LocalDate.now())) throw new ContactException("La date de naissance doit être antérieure à aujourd'hui");

		// Change le format de la date de naissance en dd/MM/yyyy
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern(C.PATTERN_DATE);
		String text = dateNaissance.format(formatters);
		this.dateNaissance = LocalDate.parse(text, formatters);;
	}

	//</editor-fold>

	//<editor-fold desc="Equals & Hashcode">

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Contact contact = (Contact) o;
		return getId().equals(contact.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	//</editor-fold>

	//<editor-fold desc="ToString">
	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	public void ajouterCoordonnees(final Coordonnee coordonnees) throws CoordonneeException {
		controlerCoordonneeNonExist(coordonnees);
		this.coordonnees.add(coordonnees);
	}

	public void supprimerCoordonnees(final Coordonnee coordonnees) throws CoordonneeException {
		controlerCoordonneeExist(coordonnees);
		this.coordonnees.remove(coordonnees);
	}

	private void controlerCoordonneeExist(final Coordonnee coordonnee) throws CoordonneeException {
		if(!this.coordonnees.contains(coordonnee)) throw new CoordonneeException("La coordonnée n'existe pas");
	}

	private void controlerCoordonneeNonExist(final Coordonnee coordonnee) throws CoordonneeException {
		if(this.coordonnees.contains(coordonnee)) throw new CoordonneeException("La coordonnée existe déjà");
	}
	//</editor-fold>
} 