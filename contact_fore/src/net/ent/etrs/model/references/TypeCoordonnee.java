package net.ent.etrs.model.references;

public enum TypeCoordonnee {
    TELEPHONE("Téléphone"),
    MAIL("Adresse mail");

    private final String libelle;

    TypeCoordonnee(String libelle){
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
}
