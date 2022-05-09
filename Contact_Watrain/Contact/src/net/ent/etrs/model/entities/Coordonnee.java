package net.ent.etrs.model.entities;

import net.ent.etrs.model.dao.Identifiable;
import net.ent.etrs.model.exceptions.CoordonneeException;

import java.util.Objects;
import java.util.UUID;

public abstract class Coordonnee implements Identifiable<String> {
	//<editor-fold desc="Attributs">
	private String id = UUID.randomUUID().toString();
	private TypeCoordonnee typeCoordonnee;
	private Contact contact;
	//</editor-fold>

	//<editor-fold desc="Constructeurs">
	protected Coordonnee() {
	}

	protected Coordonnee(final Contact contact) throws CoordonneeException {
		setContact(contact);
		// set type coordonnée par introspection sur le type de la classe
		String typeCoordonneeName = this.getClass().getSimpleName().toUpperCase();
		setTypeCoordonnee(TypeCoordonnee.valueOf(typeCoordonneeName));
	}

	//</editor-fold>

	//<editor-fold desc="Getters">

	@Override
	public String getId() {
		return id;
	}

	public TypeCoordonnee getTypeCoordonnee() {
		return typeCoordonnee;
	}

	public Contact getContact() {
		return contact;
	}

	//</editor-fold>

	//<editor-fold desc="Setters">

	private void setTypeCoordonnee(final TypeCoordonnee typeCoordonnee) throws CoordonneeException {
		if(Objects.isNull(typeCoordonnee)) { throw new CoordonneeException("Le type de coordonnée est obligatoire"); }
		this.typeCoordonnee = typeCoordonnee;
	}

	private void setContact(final Contact contact) throws CoordonneeException {
		if(Objects.isNull(contact)) { throw new CoordonneeException("Le contact est obligatoire"); }
		this.contact = contact;
	}

	//</editor-fold>

	//<editor-fold desc="Equals & Hashcode">

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coordonnee that = (Coordonnee) o;
		return getId().equals(that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	//</editor-fold>

	//<editor-fold desc="ToString">
	//</editor-fold>

	//<editor-fold desc="Autres méthodes">
	//</editor-fold>
} 