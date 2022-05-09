/**
 * 
 */
package ent.etrs.pdi.pre.model.exceptions;


/**
 * @author christophe.cerqueira
 *
 */
public class TelephoneException extends Exception {
	/**
	 * @param message
	 */
	public TelephoneException(String message) {
		super(message);
	}

	public TelephoneException(String format, Throwable cause) {
		super(format, cause);
	}
}
