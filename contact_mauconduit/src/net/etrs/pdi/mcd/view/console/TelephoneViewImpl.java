package net.etrs.pdi.mcd.view.console;



import net.etrs.pdi.mcd.commons.utils.AffichageConsole;
import net.etrs.pdi.mcd.model.commons.entities.Telephone;
import net.etrs.pdi.mcd.view.facades.TelephoneView;

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
