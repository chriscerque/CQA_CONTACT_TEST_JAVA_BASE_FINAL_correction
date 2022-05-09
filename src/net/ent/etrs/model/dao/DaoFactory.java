package net.ent.etrs.model.dao;

/**
 * Fabrique de persistance.
 *
 * @author christophe.cerqueira
 */
public final class DaoFactory {

    private DaoFactory() {
    }


    public static IContactMemoireDao fabriquerContactDao() {
        return new ContactMemoireDao();
    }

}
