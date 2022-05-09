package ent.etrs.pdi.pre.view.console;


import ent.etrs.pdi.pre.commons.utils.AffichageConsole;
import ent.etrs.pdi.pre.model.entities.Telephone;
import ent.etrs.pdi.pre.view.TelephoneView;

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
