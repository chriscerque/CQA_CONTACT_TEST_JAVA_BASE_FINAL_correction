package net.etrs.pdi.mcd.model.commons.entities.exceptions;

import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;

public class MailException extends Exception {


    public MailException() {
        super(ConstantesModel.MSG_MAIL_EXCEPTION);
    }

    public MailException(String message) {
        super(message);
    }

    public MailException(String format, Throwable cause) {
        super(format, cause);
    }
}
