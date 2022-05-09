/**
 * 
 */
package net.etrs.pdi.mcd.model.commons.entities.exceptions;

import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;

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
		super(ConstantesModel.MSG_CONTACT_EXCEPTION);
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
