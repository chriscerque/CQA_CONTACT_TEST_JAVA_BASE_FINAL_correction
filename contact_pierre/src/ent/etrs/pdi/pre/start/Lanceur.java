package ent.etrs.pdi.pre.start;

import ent.etrs.pdi.pre.model.facade.ContactFacade;
import ent.etrs.pdi.pre.model.facade.FacadeMetierFactory;
import ent.etrs.pdi.pre.presenter.Presenter;
import ent.etrs.pdi.pre.view.ContactView;
import ent.etrs.pdi.pre.view.console.ViewFactory;

public class Lanceur {
    public static void main(String[] args) {
        ContactFacade metier = FacadeMetierFactory.fabriquerContactFacade();
        ContactView vue = ViewFactory.fabriquerContactView();

//        try {
            Presenter presenter = new Presenter(metier, vue);
            presenter.executer();
//        } catch (PresenterException e) {
//            System.out.println("L'application n'a pu être lancée...");
//        }
    }
}
