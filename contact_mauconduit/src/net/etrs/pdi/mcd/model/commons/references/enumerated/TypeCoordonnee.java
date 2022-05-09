package net.etrs.pdi.mcd.model.commons.references.enumerated;

public enum TypeCoordonnee {
    TELEPHONE("Telephone"),
    MAIL("Mail");

    private final String libelle;

    private TypeCoordonnee(final String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return this.libelle;
    }
}
