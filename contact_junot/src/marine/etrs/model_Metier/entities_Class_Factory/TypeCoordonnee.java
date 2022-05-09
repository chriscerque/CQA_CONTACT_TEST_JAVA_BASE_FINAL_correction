package marine.etrs.model_Metier.entities_Class_Factory;

public enum TypeCoordonnee {

	TELEPHONE("tel"), MAIL("mail");

	private String libelle;

	TypeCoordonnee(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}