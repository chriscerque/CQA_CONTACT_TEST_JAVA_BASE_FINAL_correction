package ent.etrs.pdi.pre.model.dao;

public final class DaoFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private DaoFactory() {
    }

    /*------- AUTRES METHODES -------*/
    public static AbstractIContactDao fabriquerContactDao(){
        return new ContactDaoImpl();
    }
}
