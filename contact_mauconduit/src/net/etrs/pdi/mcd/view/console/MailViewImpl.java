package net.etrs.pdi.mcd.view.console;



import net.etrs.pdi.mcd.commons.utils.AffichageConsole;
import net.etrs.pdi.mcd.model.commons.entities.Mail;
import net.etrs.pdi.mcd.view.facades.MailView;

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
