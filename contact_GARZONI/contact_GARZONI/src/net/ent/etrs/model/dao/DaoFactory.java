package net.ent.etrs.model.dao;

import net.ent.etrs.model.entities.Contact;

public final class DaoFactory {

    /**
     * Fabrique une DAO pour la gestion des entités {@link Contact}.
     *
     * @return l'instance de {@link IContactMemoireDao}
     */
    public static IContactMemoireDao fabriquerContactDao() {
        return new ContactMemoireDao();
    }


/*----------------------
CONSTRUCTEURS BLOQUE
-----------------------*/
    private DaoFactory() {

    }

} // fin de classe
