package ent.etrs.pdi.pre.view.console;

import ent.etrs.pdi.pre.view.ContactView;
import ent.etrs.pdi.pre.view.TelephoneView;

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
