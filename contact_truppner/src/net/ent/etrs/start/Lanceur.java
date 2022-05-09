package net.ent.etrs.start;


import net.ent.etrs.model.facade.ContactFacadeImpl;
import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.console.ContactViewImpl;
import net.ent.etrs.view.console.ViewFactory;

public class Lanceur {
    //Constructeur en privé pour ne pas instancier
    private Lanceur() {
    }

    public static void main(String[] args) {
        //Instanciation des 2 façades
        ContactFacadeImpl metier = FacadeModelFactory.fabriquerContactModelFacade();
        ContactViewImpl contactVue = ViewFactory.fabriquerContactView();
//        MailViewImpl mailVue = ViewFactory.fabriquerMailView();
//        TelephoneViewImpl telephoneVue = ViewFactory.fabriquerTelephoneView();

        try {
            //Instanciation du presenter
            Presenter presenter = new Presenter(metier, contactVue);

            presenter.exec();

        } catch (PresenterException e) {
            System.out.println("L'application n'a pu être lancée...");
        }
    }
}
