package net.ent.etrs.rbnm.start;

import net.ent.etrs.rbnm.model.facades.ContactFacade;
import net.ent.etrs.rbnm.model.facades.FactoryFacadeMetier;
import net.ent.etrs.rbnm.presenter.FactoryPresenter;
import net.ent.etrs.rbnm.presenter.IPresentable;
import net.ent.etrs.rbnm.view.ContactView;
import net.ent.etrs.rbnm.view.console.ViewFactory;


public class Lanceur {

    /* *************** */
    /* ***** VUE ***** */
    //Création d'une vue.
    private static final ContactView VUE = ViewFactory.fabriquerContactView();


    /* ****************** */
    /* ***** METIER ***** */
    //Création d'un metier.
    private static final ContactFacade METIER = FactoryFacadeMetier.fabriquerContactModelFacade();


    public static void main(String[] args) {

        try {
            //Instanciation d'un presentable via la fabrique presenter
            IPresentable presenter = FactoryPresenter.fabriquerPresenter(VUE, METIER);

            //Lancement de la méthode d'initialisation
            presenter.initialiser();

            //Lancement de la méthode d'execution
            presenter.executer();
        } catch (Exception e) {
            //Affichage du message d'erreur.
            System.out.println(e.getMessage() + " L'application n'a pu être lancée..");
        }

    }

}
