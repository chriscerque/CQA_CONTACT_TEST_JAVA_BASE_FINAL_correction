package net.ent.etrs.model.facade;

public final class FacadeMetierFactory {

    private FacadeMetierFactory() {}

    public static ContactFacade fabriquerFacadeMetier() {
        return new ContactFacadeImpl();
    }
}
