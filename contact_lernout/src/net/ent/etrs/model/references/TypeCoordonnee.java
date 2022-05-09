package net.ent.etrs.model.references;

public enum TypeCoordonnee {
    TELEPHONE("telephone"),
    MAIL("mail");

    private final String libelle;

    private TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
