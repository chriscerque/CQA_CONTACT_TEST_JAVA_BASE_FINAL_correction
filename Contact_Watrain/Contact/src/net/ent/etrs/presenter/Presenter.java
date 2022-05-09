package net.ent.etrs.presenter;

import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.facade.ContactFacade;
import net.ent.etrs.presenter.exceptions.PresenterException;
import net.ent.etrs.view.ContactView;

import java.util.Objects;

public class Presenter {

	private final ContactView vue;
	private final ContactFacade metier;

	public Presenter(ContactFacade metier, ContactView vue) throws PresenterException {
		if (Objects.isNull(metier)) {
			throw new PresenterException("FacadeMetier is null");
		}
		if (Objects.isNull(vue)) {
			throw new PresenterException("FacadeVue is null");
		}
		this.vue = vue;
		this.metier = metier;
	}


	public void executer() {

		metier.init();
		int choixMenu;
		do {
			choixMenu = vue.afficherMenu();
			switch (choixMenu) {
				case 1: // Lister les contacts
					vue.afficherContacts(metier.listerContacts());
					break;
				case 2: // Ajouter un contact
					try {
						metier.sauvegarderContact(vue.saisirContact());
					} catch (ContactException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3: // Supprimer un contact
					try {
						metier.supprimerContact(vue.selectionnerContact(metier.listerContacts()));
					} catch (ContactException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4: // Lister les coordonnées d'un contact
					vue.afficherCoordonnees(vue.selectionnerContact(metier.listerContacts()));
					break;
				case 5: // Ajouter une coordonnée à un contact
					try {
						metier.mettreAJourContact(vue.saisirCoordonneesContact(vue.selectionnerContact(metier.listerContacts())));
					} catch (ContactException | CoordonneeException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 6: // Supprimer une coordonnée à un contact
					try {
						metier.mettreAJourContact(vue.supprimerCoordonneesContact(vue.selectionnerContact(metier.listerContacts())));

					} catch (CoordonneeException | ContactException e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
					break;
			}
		} while (choixMenu != 0);
	}
}
