package net.ent.etrs.model.facade;

public class FacadeModelFactory
{
    private FacadeModelFactory() {}

    public static ContactFacade fabriquerContactModelFacade()
    {
        return new ContactFacadeImpl();
    }
}
