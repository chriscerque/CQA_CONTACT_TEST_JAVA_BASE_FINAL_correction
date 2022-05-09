package ent.etrs.pdi.pre.model.references;

public enum TypeCoordonnee {
    /*------- ENUMS -------*/
    TELEPHONE("Téléphone"),
    MAIL("Mail");
    /*------- ATTRIBUTS -------*/
    private String libelle;
    /*------- CONSTRUCTEUR(S) -------*/
    private TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }
    /*------- ASCESSEURS -------*/
    // GETTER
    public String getLibelle() {
        return libelle;
    }

    /*------- AUTRES METHODES -------*/
}
