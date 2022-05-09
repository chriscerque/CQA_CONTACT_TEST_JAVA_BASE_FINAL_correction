package net.ent.etrs.rbnm.model.exceptions;

public class BusinessExceptions extends Exception{


    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public BusinessExceptions(){}

    public BusinessExceptions(String message){
        super(message);
    }

    public BusinessExceptions(String message, Throwable cause){
        super(message, cause);
    }



}
