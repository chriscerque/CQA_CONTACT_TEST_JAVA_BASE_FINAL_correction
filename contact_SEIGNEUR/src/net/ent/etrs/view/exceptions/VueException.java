package net.ent.etrs.view.exceptions;

import net.ent.etrs.model.references.C;

public class VueException extends Exception{

    public VueException() {
        super(C.MSG_ERREUR_VUE);
    }

    /**
     * @param message
     */
    public VueException(String message) {
        super(message);
    }

    public VueException(String format, Throwable cause) {
        super(format, cause);
    }
}
