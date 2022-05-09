package net.ent.etrs.model.dao;


public final class DaoFactory {
    private static ContactMemoireDao contactMemoireDaoInstance;

    public static AbstractContactDao fabriquerContactDao() {
        if (contactMemoireDaoInstance == null){
            contactMemoireDaoInstance = new ContactMemoireDao();
        }
        return contactMemoireDaoInstance;
    }
}
