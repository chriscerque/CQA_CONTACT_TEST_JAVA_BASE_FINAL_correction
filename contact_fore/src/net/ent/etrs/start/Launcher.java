package net.ent.etrs.start;

import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.PresenterFactory;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.console.ViewFactory;

public class Launcher {

    public static void main(String[] args) {

        try {
            Presenter presenter = PresenterFactory.fabriquerPresenter(ViewFactory.fabriquerContactView(), FacadeModelFactory.fabriquerContactModelFacade());
            presenter.init();
            presenter.execute();
        } catch (PresenterException e) {
            System.out.println("Il y a eu une erreur. ");
        }

    }
}
