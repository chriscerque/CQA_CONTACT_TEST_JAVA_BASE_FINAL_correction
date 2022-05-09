package net.ent.etrs.presenter;

import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;

public class PresenterFactory {
    private PresenterFactory(){}

    public static Presenter fabriquerPresenter(ContactView view, ContactFacade metier) throws PresenterException {
        return new Presenter(view, metier);
    }
}
