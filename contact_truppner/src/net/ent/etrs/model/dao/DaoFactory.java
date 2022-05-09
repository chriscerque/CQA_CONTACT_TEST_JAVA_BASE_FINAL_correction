package net.ent.etrs.model.dao;

import java.util.Objects;

public class DaoFactory {
    //SINGLETON
    private static AbstractContactDao absContactInstance;

    /////CONSTRUCTEUR/////
    private DaoFactory() {
    }

    /////METHODES/////
    public static AbstractContactDao fabriquerContactDao()
    {
        //Singleton
        if(Objects.isNull(absContactInstance))
        {
            absContactInstance = new ContactMemDao();
        }
        return new ContactMemDao();
    }
}
