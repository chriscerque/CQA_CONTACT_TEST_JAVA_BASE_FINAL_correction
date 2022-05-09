package net.ent.etrs.presenter;

import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.view.console.ViewFactory;

public final class PresenterFactory {
    private PresenterFactory() {}

    public static Presenter fabriquerContactPresenter() {
        return new ContactPresenter(ViewFactory.fabriquerContactView(), FacadeModelFactory.fabriquerContactModelFacade());
    }
}
