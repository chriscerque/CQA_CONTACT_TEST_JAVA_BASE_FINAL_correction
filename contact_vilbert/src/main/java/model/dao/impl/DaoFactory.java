package model.dao.impl;

public final class DaoFactory {

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    private DaoFactory() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    public static IContactMemoireDao fabriquerContactDao() {
        return new ContactMemoireDao();
    }

}
