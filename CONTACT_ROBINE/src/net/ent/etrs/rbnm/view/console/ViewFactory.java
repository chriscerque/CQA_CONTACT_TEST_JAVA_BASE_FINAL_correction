package net.ent.etrs.rbnm.view.console;

import net.ent.etrs.rbnm.view.ContactView;
import net.ent.etrs.rbnm.view.TelephoneView;


/**
 * Fabrique les vues de l'application.
 * @author christophe.cerqueira
 *
 */
public final class ViewFactory {

	private ViewFactory() {
	}

	
	
	public static ContactView fabriquerContactView() {
		return new ContactViewImpl();
	}
	
	public static TelephoneView fabriquerTelephoneView() {
		return new TelephoneViewImpl();
	}
	
	public static MailViewImpl fabriquerMailView() {
		return new MailViewImpl();
	}
}
