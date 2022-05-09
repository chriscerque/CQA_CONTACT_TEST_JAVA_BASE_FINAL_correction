package net.ent.etrs.start;

import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.console.ViewFactory;

public class Lanceur {

    private static ContactFacade metier;
    private static ContactView vue;
    private Lanceur() {
    }

    public static void main(String[] args) {
        metier = FacadeModelFactory.fabriquerContactModelFacade();
        metier.init(metier);
        vue = ViewFactory.fabriquerContactView();
        Presenter presenter = null;
        try {
            presenter = new Presenter(metier,vue);
        } catch (PresenterException e) {
            e.printStackTrace();
        }
        presenter.executer();


    }
}
