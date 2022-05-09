/**
 *
 */
package net.ent.etrs.model.references;

/**
 * @author christophe.cerqueira
 *
 */
public enum TypeCoordonnee {

    TELEPHONE("Téléphone"),
    MAIL("Mail");

    private final String libelle;

    /**
     * @param libelle
     */
    TypeCoordonnee(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }


}
