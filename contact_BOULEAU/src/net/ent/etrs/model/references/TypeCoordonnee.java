package net.ent.etrs.model.references;

public enum TypeCoordonnee {
    TELEPHONE("Telephone"),
    MAIL("Mail");

    private String libelle;

    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }



}
