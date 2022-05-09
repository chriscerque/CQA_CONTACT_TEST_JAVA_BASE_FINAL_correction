package net.ent.etrs.start;

import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.facade.FacadeMetier;
import net.ent.etrs.model.facade.FacadeMetierFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.exceptions.PresenterException;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.console.ContactViewImpl;
import net.ent.etrs.view.console.ViewFactory;

/**
 * Lanceur de l'application
 */
public final class Lanceur {

    private Lanceur() {
    }

    public static void main(String[] args) {
        ContactFacade metier = FacadeMetierFactory.fabriquerFacadeMetier();//FacadeMetierFactory.fabriquerFacadeMetier();
        ContactView vue = ViewFactory.fabriquerContactView();//FacadeVueFactory.fabriquerFacadeVue();

        try {
            Presenter presenter = new Presenter(metier, vue);
            presenter.executer();
        } catch (PresenterException e) {
            System.out.println("L'application n'a pu être lancée...");
        } catch (Exception e) {
            System.out.println("Une erreur est survenue...");
        }
    }
}
