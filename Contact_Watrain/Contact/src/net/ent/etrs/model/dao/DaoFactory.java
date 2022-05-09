package net.ent.etrs.model.dao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static IContactMemDao fabriquerContactDao() {
        return new ContactMemDao();
    }
}
