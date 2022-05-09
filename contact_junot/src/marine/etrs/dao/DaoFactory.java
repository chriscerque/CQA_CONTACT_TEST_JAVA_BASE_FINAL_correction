package marine.etrs.dao;

//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;

//@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DaoFactory {

    private DaoFactory() {}

    /**
     * Fabrique une DAO pour la gestion des entités.
     */
                                // CHANGER Xx par
    public static AbstractContactDao fabriquerContactDao() {
        return new ContactMemoireDaoImpl();
    }


}
