package net.etrs.pdi.mcd.model.dao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static IContactMemoireDao fabriquerContactDao() {
        return new ContactMemoireDao();
    }
}
