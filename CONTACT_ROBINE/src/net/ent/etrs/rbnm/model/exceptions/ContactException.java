/**
 * 
 */
package net.ent.etrs.rbnm.model.exceptions;

import net.ent.etrs.rbnm.model.references.constantes.C;

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
