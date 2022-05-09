package net.ent.etrs.model.references;

public enum TypeCoordonnee
{
    //valeurs de l'enum
    TELEPHONE("telephone"),
    MAIL("mail");

    //attributs de l'enum
    private String libelle;

    //constructeur
    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    //accesseurs

    public String getLibelle() {
        return libelle;
    }
}
