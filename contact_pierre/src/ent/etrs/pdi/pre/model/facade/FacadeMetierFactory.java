package ent.etrs.pdi.pre.model.facade;

public final class FacadeMetierFactory {
    /*------- CONSTRUCTEUR(S) -------*/
    private FacadeMetierFactory() {
    }

    /*------- AUTRES METHODES -------*/
    public static ContactFacade fabriquerContactFacade(){
        return new ContactFacadeImpl();
    }
}
