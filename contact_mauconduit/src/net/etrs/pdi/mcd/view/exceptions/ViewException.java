package net.etrs.pdi.mcd.view.exceptions;

public class ViewException extends Exception{

    public ViewException() {
    }

    public ViewException(String message) {
        super(message);
    }

    public ViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ViewException(Throwable cause) {
        super(cause);
    }

}
