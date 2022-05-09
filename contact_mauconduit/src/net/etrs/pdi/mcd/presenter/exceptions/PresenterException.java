package net.etrs.pdi.mcd.presenter.exceptions;

public class PresenterException extends Exception {
    public PresenterException() {}

    public PresenterException(final String msg) {
        super(msg);
    }

    public PresenterException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

    public PresenterException(final Throwable cause) {
        super(cause);
    }

}
