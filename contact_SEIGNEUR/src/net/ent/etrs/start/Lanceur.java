package net.ent.etrs.start;

import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.MailView;
import net.ent.etrs.view.TelephoneView;
import net.ent.etrs.view.console.ViewFactory;

public class Lanceur {

    private Lanceur(){}

    public static void main(String[] args) {

        ContactFacade metier = FacadeModelFactory.fabriquerContactModelFacade();
        metier.init(metier);
        TelephoneView telVue = ViewFactory.fabriquerTelephoneView();
        MailView mailVue = ViewFactory.fabriquerMailView();
        ContactView contVue = ViewFactory.fabriquerContactView();

        Presenter presenter = new Presenter(metier, telVue, mailVue, contVue);
        presenter.executer();
    }

}
