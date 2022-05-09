package net.ent.etrs.model.dao;

public class DaoFactory {

    private DaoFactory() {
    }

    private static ContactMemDao contactMemDao;

    public static AbstractContactDao fabriquerContactDao(){
        if (contactMemDao == null){
            contactMemDao = new ContactMemDao();
        }
        return contactMemDao;
    }
}
