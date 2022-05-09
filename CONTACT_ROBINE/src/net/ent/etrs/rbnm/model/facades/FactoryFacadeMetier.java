package net.ent.etrs.rbnm.model.facades;

public final class FactoryFacadeMetier {


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryFacadeMetier(){}

    public static ContactFacade fabriquerContactModelFacade(){ return new ContactFacadeImpl();}

}
