package net.ent.etrs.presenter;

import net.ent.etrs.model.exceptions.BusinessException;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facades.ContactFacade;
import net.ent.etrs.presenter.exceptions.ExceptionPresenterGeneral;
import net.ent.etrs.view.ContactView;
import net.ent.etrs.vue.facades.IFacadeVue;

import java.util.Objects;

public class PresenterGeneral {
/*----------------------
Attributs +0+1
-----------------------*/
private ContactView vue;
private ContactFacade metier;

/*----------------------
CONSTRUCTEURS +1
-----------------------*/

	public PresenterGeneral(final ContactFacade unMetier, final ContactView uneVue) throws ExceptionPresenterGeneral {
		if (Objects.isNull(unMetier)) {
			throw new ExceptionPresenterGeneral(ExceptionPresenterGeneral.ERR_METIER_NULL);
		}
		if (Objects.isNull(uneVue)) {
			throw new ExceptionPresenterGeneral(ExceptionPresenterGeneral.ERR_VUE_NULL);
		}
		this.metier = unMetier;
		this.vue = uneVue;
	}

	public void init(){
		metier.init();
	}

	public void executer(){

		int choix = 0;
		do {
			// afficher le menu
			choix = this.vue.afficherMenu();
			// traiter les options du menu
			traiterOption(choix);

		} while (choix != 0);

	}


/*----------------------
AUTRES METHODES
-----------------------*/

		private void traiterOption(int choixMenu){

			switch (choixMenu) {
				case 1:
					listerLesContacts();
					break;
				case 2:
					creerUnContact();
					break;
				case 3:
					supprimerLesContact();
					break;
				case 4:
					listerLesCoordonneesContacts();
					break;
				case 5:
					ajouterUneCoordonneeContact();
					break;
				case 6:
					supprimerUneCoordonneeContact();
					break;

				default:
					break;
			}
		}

	public void listerLesContacts(){
			vue.afficherContacts(metier.listerContacts());
	}

	public void creerUnContact()  {
		try {
			metier.sauvegarderContact(vue.selectionnerContact(metier.listerContacts()));
		} catch (ContactException e) {
			System.out.println(e.getMessage());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	}

	public void supprimerLesContact(){
		try {
			metier.supprimerContact(vue.selectionnerContact(metier.listerContacts()));
		} catch (ContactException e) {
			System.out.println(e.getMessage());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
	};

	public void listerLesCoordonneesContacts(){
			vue.afficherContact(vue.selectionnerContact(metier.listerContacts()));

	};

	public void ajouterUneCoordonneeContact(){

		try {
			metier.mettreAJourContact(vue.saisirCoordonneesContact(vue.selectionnerContact(metier.listerContacts())));
		} catch (ContactException e) {
			System.out.println(e.getMessage());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} catch (CoordonneeException e) {
			System.out.println(e.getMessage());
		}


	};

	public void supprimerUneCoordonneeContact(){

		try {
			metier.mettreAJourContact(vue.supprimerCoordonneesContact(vue.selectionnerContact(metier.listerContacts())));
		} catch (ContactException e) {
			System.out.println(e.getMessage());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} catch (CoordonneeException e) {
			System.out.println(e.getMessage());
		}

	};

}  // fin de classe