package net.ent.etrs.view.console;

/**
 * Fabrique les vues de l'application.
 * @author christophe.cerqueira
 *
 */
public final class ViewFactory {

	private ViewFactory() {
	}

	
	
	public static ContactViewImpl fabriquerContactView() {
		return new ContactViewImpl();
	}
	
	public static TelephoneViewImpl fabriquerTelephoneView() {
		return new TelephoneViewImpl();
	}
	
	public static MailViewImpl fabriquerMailView() {
		return new MailViewImpl();
	}
}
