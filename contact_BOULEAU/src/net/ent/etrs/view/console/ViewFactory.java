package net.ent.etrs.view.console;

import net.ent.etrs.view.ContactView;
import net.ent.etrs.view.TelephoneView;

/**
 * Fabrique les vues de l'application.
 * @author christophe.cerqueira
 *
 */
public final class ViewFactory {

	//CONS PRIVE
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
