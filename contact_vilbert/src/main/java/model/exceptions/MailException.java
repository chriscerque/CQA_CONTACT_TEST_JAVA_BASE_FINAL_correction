package model.exceptions;

import model.references.C;

public class MailException extends Exception {

    public MailException() {
        super(C.MSG_MAIL_EXCEPTION);
    }

    public MailException(String message) {
        super(message);
    }

    public MailException(String message, Throwable cause) {
        super(message, cause);
    }
}
