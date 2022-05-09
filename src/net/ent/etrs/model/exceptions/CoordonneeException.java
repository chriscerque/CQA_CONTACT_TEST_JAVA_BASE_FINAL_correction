/**
 * 
 */
package net.ent.etrs.model.exceptions;

import net.ent.etrs.model.references.C;

/**
 * @author christophe.cerqueira
 *
 */
public class CoordonneeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CoordonneeException() {
		super(C.MSG_COORDONNEE_EXCEPTION);
	}

	/**
	 * @param message
	 */
	public CoordonneeException(String message) {
		super(message);
	}

	public CoordonneeException(String format, Throwable cause) {
		super(format, cause);
	}
}
