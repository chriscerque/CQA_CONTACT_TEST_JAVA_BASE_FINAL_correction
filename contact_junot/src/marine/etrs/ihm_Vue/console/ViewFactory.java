package marine.etrs.ihm_Vue.console;

import marine.etrs.ihm_Vue.ContactView;
import marine.etrs.ihm_Vue.TelephoneView;

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
