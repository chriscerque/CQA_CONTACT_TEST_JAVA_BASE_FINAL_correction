/**
 * 
 */
package net.ent.etrs.model.exceptions;

import net.ent.etrs.model.references.C;

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
