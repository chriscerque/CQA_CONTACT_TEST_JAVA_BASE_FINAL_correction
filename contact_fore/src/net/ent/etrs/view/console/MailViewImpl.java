package net.ent.etrs.view.console;


import net.ent.etrs.commons.utils.AffichageConsole;
import net.ent.etrs.model.entities.Mail;
import net.ent.etrs.view.MailView;

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
