package marine.etrs.ihm_Vue.console;


import marine.etrs.ihm_Vue.TelephoneView;
import marine.etrs.model_Metier.entities_Class_Factory.Telephone;

public class TelephoneViewImpl implements TelephoneView {

	protected TelephoneViewImpl() {
	}

	public void afficherCoordonnee(final Telephone t) {

		AffichageConsole.afficherMessageAvecSautLigne(String.format("\t\tTelephone : %-15s %s",
				t.getNumero(),t.getTypeNumero()));
	}
}
