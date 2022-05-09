package view.console;


import commons.utils.AffichageConsole;
import model.entities.Mail;
import view.MailView;

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
