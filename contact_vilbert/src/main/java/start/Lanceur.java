package start;

import model.facade.ContactFacade;
import model.facade.impl.FacadeModelFactory;
import presenter.Presenter;
import presenter.impl.PresenterFactory;
import view.ContactView;
import view.console.ViewFactory;

public class Lanceur {

    public static void main(String[] args) {

        ContactView vue = ViewFactory.fabriquerContactView();
        ContactFacade metier = FacadeModelFactory.fabriquerContactModelFacade();
        Presenter presenter = PresenterFactory.createPresenter(vue, metier);
        presenter.executer();

    }

}
