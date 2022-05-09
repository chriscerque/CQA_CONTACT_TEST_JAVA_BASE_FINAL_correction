package view.console;


import commons.utils.AffichageConsole;
import model.entities.Telephone;
import view.TelephoneView;

public class TelephoneViewImpl implements TelephoneView {

	/**
	 * 
	 */
	protected TelephoneViewImpl() {
	}

	public void afficherCoordonnee(final Telephone t) {

		AffichageConsole.afficherMessageAvecSautLigne(String.format("\t\tTelephone : %-15s %s",
				t.getNumero(),t.getTypeNumero()));
	}
}
