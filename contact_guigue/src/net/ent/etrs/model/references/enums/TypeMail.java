package net.ent.etrs.model.references.enums;

public enum TypeMail {
    /*----------------------
    ***** Listing Enum *****
    ----------------------*/
    PROFESSIONNEL("Professionnel"),
    PERSONNEL("Personnel");

    /*----------------------
    **** Attributs Enum ****
    ----------------------*/
    private String typeMail;

    /*---------------------
    **** Constructeurs ****
    ----------------------*/

    TypeMail(String typeMail) {
        this.typeMail = typeMail;
    }

    /*----------------------
        ******** Getter ********
        ----------------------*/

    public String getTypeMail() {
        return typeMail;
    }
    /*------------------------------*
    ******** Autres methodes ********
    -------------------------------*/




}
