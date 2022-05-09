package net.ent.etrs.model.references.enums;

public enum TypeNumero {
    /*----------------------
    ***** Listing Enum *****
    ----------------------*/
    FAX("Fax"),
    PROFESSIONNEL("professionnel"),
    MOBILE("Mobile"),
    DOMICILE("Domcile");

    /*----------------------
    **** Attributs Enum ****
    ----------------------*/
    private String typeNumero;

    /*---------------------
    **** Constructeurs ****
    ----------------------*/

    TypeNumero(String typeNumero) {
        this.typeNumero = typeNumero;
    }

    /*----------------------
        ******** Getter ********
        ----------------------*/
    public String getTypeNumero() {
        return typeNumero;
    }
    /*------------------------------*
    ******** Autres methodes ********
    -------------------------------*/



}
