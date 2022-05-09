package net.etrs.pdi.mcd.model.facades;

public final class FacadeModelFactory {

    /**
     * Permet de creer la facade metier.
     * @return ContactFacadeImpl.
     */
    public static ContactFacade fabriquerContactModelFacade() {
        return new ContactFacadeImpl();
    }

}
