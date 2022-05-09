/**
 * 
 */
package net.etrs.pdi.mcd.model.commons.entities.exceptions;


import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;

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
		super(ConstantesModel.MSG_COORDONNEE_EXCEPTION);
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
