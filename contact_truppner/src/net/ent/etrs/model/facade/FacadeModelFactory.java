package net.ent.etrs.model.facade;

public class FacadeModelFactory {
    private FacadeModelFactory(){}

    public static ContactFacadeImpl fabriquerContactModelFacade(){
        return new ContactFacadeImpl();
    }
}
