package net.etrs.pdi.mcd.model.commons.entities.exceptions;

import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;

public class TelephoneException extends Exception {


    public TelephoneException() {
        super(ConstantesModel.MSG_TELEPHONE_EXCEPTION);
    }

    public TelephoneException(String message) {
        super(message);
    }

    public TelephoneException(String format, Throwable cause) {
        super(format, cause);
    }
}
