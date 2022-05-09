package marine.etrs.ihm_Vue.console;


import marine.etrs.ihm_Vue.MailView;
import marine.etrs.model_Metier.entities_Class_Factory.Mail;


public class MailViewImpl implements MailView {

	
	/**
	 * 
	 */
	protected MailViewImpl() {
	}

	public void afficherCoordonnee(final Mail m) {
		AffichageConsole.afficherMessageAvecSautLigne(String.format("\t\tMail(%s) : %s",
				m.getTypeMail(), m.getAdresseMail()));
	}
}
