package net.ent.etrs.model.references;

public enum TypeCoordonnee {
    TELEPHONE("Téléphone"), MAIL("Mail");

    private String libelle;

    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }
}
