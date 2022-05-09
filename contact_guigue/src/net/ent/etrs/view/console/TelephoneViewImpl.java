package net.ent.etrs.view.console;


import net.ent.etrs.commons.utils.AffichageConsole;
import net.ent.etrs.model.entities.Telephone;
import net.ent.etrs.view.TelephoneView;

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
