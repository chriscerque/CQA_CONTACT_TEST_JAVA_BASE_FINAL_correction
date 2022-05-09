package net.ent.etrs.rbnm.model.dao;

public final class DaoFactory {


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private DaoFactory(){}


    public static IContactMemDao fabriquerContactDao(){
        return new ContactMemDaoImpl();
    }



}
