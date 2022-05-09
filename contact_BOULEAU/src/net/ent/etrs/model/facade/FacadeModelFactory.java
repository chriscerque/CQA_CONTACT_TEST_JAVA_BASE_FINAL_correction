package net.ent.etrs.model.facade;

public class FacadeModelFactory {

    public static ContactFacadeImpl fabriquerContactModelFacade() {
        return new ContactFacadeImpl();
    }

}
