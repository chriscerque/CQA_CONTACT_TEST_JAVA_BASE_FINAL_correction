package net.ent.etrs.start;

import net.ent.etrs.model.entities.Telephone;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.presenter.Presenter;
import net.ent.etrs.presenter.exception.PresenterException;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.MailView;
import net.ent.etrs.view.TelephoneView;
import net.ent.etrs.view.console.ViewFactory;


public class LanceurMVP {


    public static void main(String[] args) {


        try {
            //creation facade Model(metier)
            ContactFacade metier = FacadeModelFactory.fabriquerContactModelFacade();

            //chargement des données existantes
            metier.init();

            //creation facades vues
            ContactView vueConctact = ViewFactory.fabriquerContactView();
            MailView vueMail = ViewFactory.fabriquerMailView();
            TelephoneView vueTelephone = ViewFactory.fabriquerTelephoneView();

            //instantiation presenter
            Presenter presenter = new Presenter(metier, vueConctact, vueMail, vueTelephone);

            presenter.exec();
        } catch (PresenterException e) {
            throw new RuntimeException(e);
        }
    }

}
