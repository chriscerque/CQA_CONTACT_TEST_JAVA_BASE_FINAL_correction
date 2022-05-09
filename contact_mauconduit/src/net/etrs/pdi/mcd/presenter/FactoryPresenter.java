package net.etrs.pdi.mcd.presenter;

import net.etrs.pdi.mcd.model.facades.ContactFacade;
import net.etrs.pdi.mcd.presenter.exceptions.PresenterException;
import net.etrs.pdi.mcd.view.facades.ContactView;

public final class FactoryPresenter {

    private FactoryPresenter() {}

    public static IPresentable creerPresenter(final ContactView vue, final ContactFacade metier) throws PresenterException {
        return new Presenter(vue, metier);
    }

}
