package net.ent.etrs.start;

import net.ent.etrs.model.facades.ContactFacade;
import net.ent.etrs.model.facades.FabriqueFacadeMetier;
import net.ent.etrs.presenter.PresenterGeneral;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.console.ViewFactory;

public final class Lanceur {
    private static final String MSG_ANOMALIE_LANCEUR = "Une erreur est survenue ! Veuillez contacter le service client !";

    public static void main(String[] args) {

        try {

            ContactFacade metier = FabriqueFacadeMetier.creerFacadeMetier();
             ContactView vue = ViewFactory.fabriquerContactView();

             PresenterGeneral presenter = new PresenterGeneral(metier, vue);
             presenter.init();
             presenter.executer();

        } catch (Exception e) {
            System.out.println(MSG_ANOMALIE_LANCEUR);
        }

    } // fin de main

} // fin de classe
