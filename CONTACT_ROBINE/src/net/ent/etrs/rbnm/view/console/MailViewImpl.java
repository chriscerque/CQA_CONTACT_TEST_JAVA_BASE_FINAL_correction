package net.ent.etrs.rbnm.view.console;


import net.ent.etrs.rbnm.model.commons.outils.AffichageConsole;
import net.ent.etrs.rbnm.model.entities.Mail;
import net.ent.etrs.rbnm.view.MailView;


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
