/**
 * 
 */
package marine.etrs.model_Metier.entities_Class_Factory.exception;

import marine.etrs.model_Metier.references_Constante_Enum.C;


/**
 * @author christophe.cerqueira
 *
 */
public class ContactException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ContactException() {
		super(C.MSG_CONTACT_EXCEPTION);
	}

	/**
	 * @param message
	 */
	public ContactException(String message) {
		super(message);
	}

	public ContactException(String format, Throwable cause) {
		super(format, cause);
	}
}
