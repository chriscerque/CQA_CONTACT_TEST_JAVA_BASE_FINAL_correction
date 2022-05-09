package net.ent.etrs.model.dao;

public class DaoFactory {

    // CONS PRIVE
    private DaoFactory() {
    }

    public static AbstractContactDao fabriquerContactDao() {
        return new ContactMemoireDao();
    }

}
