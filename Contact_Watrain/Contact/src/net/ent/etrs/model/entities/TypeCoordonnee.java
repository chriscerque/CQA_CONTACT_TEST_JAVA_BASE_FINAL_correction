package net.ent.etrs.model.entities;

public enum TypeCoordonnee {
	TELEPHONE("Téléphone"),
	MAIL("Mail");

	private final String libelle;

	private TypeCoordonnee(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}