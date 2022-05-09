package marine.etrs.start;
import marine.etrs.ihm_Vue.ContactView;
import marine.etrs.ihm_Vue.FabriqueFacadeVue;
import marine.etrs.ihm_Vue.FacadeVue;
import marine.etrs.ihm_Vue.console.ViewFactory;
import marine.etrs.ihm_Vue.ihm.exeception.VueException;
import marine.etrs.model_Metier.facade.FabriqueFacadeMetier;
import marine.etrs.model_Metier.facade.ContactFacade;
import marine.etrs.model_Metier.facade.exceptions_business.BusinessException;
import marine.etrs.presenteur.Presenter;
import marine.etrs.presenteur.PresenterException;


public class Lanceur_MVP {
	public static void main(String[] args) {

		try {
			ContactFacade fmetier = FabriqueFacadeMetier.fabriquerFacadeMetier();// METIER
			fmetier.init();

			//FacadeVue fvue = FabriqueFacadeVue.fabriquerVue(); //TYPE INTERFACE !
			ContactView fvue = ViewFactory.fabriquerContactView();

			Presenter presenter = new Presenter(fvue,fmetier);

			presenter.executer();
		} catch (PresenterException | VueException e) {
			e.printStackTrace();
		}
	}
}