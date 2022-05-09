package net.ent.etrs.rbnm.view.console;


import net.ent.etrs.rbnm.model.commons.outils.AffichageConsole;
import net.ent.etrs.rbnm.model.entities.Telephone;
import net.ent.etrs.rbnm.view.TelephoneView;


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
