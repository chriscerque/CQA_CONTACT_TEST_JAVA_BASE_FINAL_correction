package ent.etrs.pdi.pre.view.console;


import ent.etrs.pdi.pre.commons.utils.AffichageConsole;
import ent.etrs.pdi.pre.model.entities.Mail;
import ent.etrs.pdi.pre.view.MailView;

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
