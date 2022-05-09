package net.etrs.pdi.mcd.start;

import net.etrs.pdi.mcd.presenter.exceptions.PresenterException;
import net.etrs.pdi.mcd.view.console.ViewFactory;
import net.etrs.pdi.mcd.view.facades.ContactView;
import net.etrs.pdi.mcd.model.facades.FacadeModelFactory;
import net.etrs.pdi.mcd.model.facades.ContactFacade;
import net.etrs.pdi.mcd.presenter.FactoryPresenter;
import net.etrs.pdi.mcd.presenter.IPresentable;

public class Lanceur {

    // ****************************** \\
    // ***** Creation de la VUE ***** \\
    // ****************************** \\

    private static final ContactView VUE = ViewFactory.fabriquerContactView();

    // ****************************** \\
    // ***** Creation du METIER ***** \\
    // ****************************** \\

    private static final ContactFacade METIER = FacadeModelFactory.fabriquerContactModelFacade();


    public static void main(final String[] args) {

        try {
            IPresentable PRESENTER = FactoryPresenter.creerPresenter(VUE, METIER);

            PRESENTER.initialiser();
            PRESENTER.executer();

        } catch (PresenterException e) {
            System.out.println(e.getMessage());
        }

    }

}
