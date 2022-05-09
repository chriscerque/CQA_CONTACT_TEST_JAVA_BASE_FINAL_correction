package net.ent.etrs.model.entities;

public enum TypeCoordonnee {
    TELEPHONE("Téléphone"), MAIL("Email");

    /////ATTRIBUTS/////
    private String libelle;

    /////CONSTRUCTEUR/////
    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    /////GETTER/////
    public String getLibelle() {
        return libelle;
    }
}
