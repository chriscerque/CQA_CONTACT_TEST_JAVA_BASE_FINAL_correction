package net.ent.etrs.rbnm.presenter;

import net.ent.etrs.rbnm.model.facades.ContactFacade;

import net.ent.etrs.rbnm.view.ContactView;


public final class FactoryPresenter {


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    private FactoryPresenter(){}

    public static Presenter fabriquerPresenter(final ContactView vue, final ContactFacade metier) throws Exception {
        return new Presenter(vue, metier);
    }


}
