package net.ent.etrs.model.facade;

public class FacadeModelFactory {

    public static ContactFacade fabriquerContactModelFacade(){
        return new ContactFacadeImpl();
    }
}
