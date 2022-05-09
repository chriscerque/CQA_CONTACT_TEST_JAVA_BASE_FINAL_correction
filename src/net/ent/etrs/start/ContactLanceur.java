package net.ent.etrs.start;

import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.model.facade.FacadeModelFactory;
import net.ent.etrs.presenter.ContactPresenter;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.console.ViewFactory;

public final class ContactLanceur {

    /**
     *
     */

//	private static final Log LOGGER = LogFactory.getLog(ContactLanceur.class);
    private ContactLanceur() {
    }

    public static void main(String[] args) {

//		if(LOGGER.isInfoEnabled()) {
//			LOGGER.info("Lancement de l'application.");
//		}

        ContactView vue = ViewFactory.fabriquerContactView();
        ContactFacade metier = FacadeModelFactory.fabriquerContactModelFacade();
        metier.init(metier);


        ContactPresenter presenter = new ContactPresenter(vue, metier);

        presenter.executer();

    }


}
