package net.ent.etrs.model.references;

public enum TypeCoordonnee {

    TELEPHONE("TELEPHONE"),
    MAIL("MAIL");

    private String libelle;

    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
