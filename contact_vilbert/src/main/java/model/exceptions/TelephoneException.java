package model.exceptions;

import model.references.C;

public class TelephoneException extends Exception {

    public TelephoneException() {
        super(C.MSG_TELEPHONE_EXCEPTION);
    }

    public TelephoneException(String message) {
        super(message);
    }

    public TelephoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
