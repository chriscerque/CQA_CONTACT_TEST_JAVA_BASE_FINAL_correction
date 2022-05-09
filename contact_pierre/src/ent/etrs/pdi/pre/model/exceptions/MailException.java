/**
 * 
 */
package ent.etrs.pdi.pre.model.exceptions;

/**
 * @author christophe.cerqueira
 *
 */
public class MailException extends Exception {
	/**
	 * @param message
	 */
	public MailException(String message) {
		super(message);
	}

	public MailException(String format, Throwable cause) {
		super(format, cause);
	}
}
