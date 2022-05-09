package net.etrs.pdi.mcd.view.console;


import net.etrs.pdi.mcd.view.facades.ContactView;
import net.etrs.pdi.mcd.view.facades.TelephoneView;

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
