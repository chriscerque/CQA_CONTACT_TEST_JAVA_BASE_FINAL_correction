package marine.etrs.ihm_Vue.ihm;

public final class ConstanteIHM {


    public static final String MSG_SUPP_CONTACT_REUSSI = "suppression reussi !";
    public static final String MSG_CREATION_REUSSI = "création reussi !";
    public static final String MSG_AJOUT_COORDONNEE_CONTACT_REUSSI = "ajout coordonnées contact reussi !";

    private ConstanteIHM() {
    }

    /**
     * CREATION D'UN MENU VIA A TABLEAU DE STRING
     */
    public static final String[] TABLEAU_STR_MENU = {
            "/*------ MENU ------*/",
            "CHARGEMENT",
            "LISTER",
            "MODIFIER",
            "SUPPRIMER",
            "CREEER",
            "QUITTER",
    };

    /**
     * GESTION DES ERREURS VIA DES CONSTANSTES
     */
    public static final String MSG_ERR_TABLEAU_MENU_VAUT_NULL = "ERR null dans le tableau";
    public static final String MSG_INVITE = "votre choix";


    public final static int MENU1_CHX_MINI = 0;
    public final static int MENU1_CHX_MAXI = TABLEAU_STR_MENU.length-2;



}

