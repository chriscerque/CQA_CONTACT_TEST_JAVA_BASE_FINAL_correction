package net.ent.etrs.model.dao;

public class DaoFactory {
    private DaoFactory(){}

    public static IContactMemoireDao fabriquerContactDao(){
        return new ContactMemoireDao();
    }
}
