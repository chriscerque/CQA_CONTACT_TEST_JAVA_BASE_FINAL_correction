package marine.etrs.dao;

import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.Contact;
import marine.etrs.model_Metier.entities_Class_Factory.Coordonnee;
import marine.etrs.model_Metier.entities_Class_Factory.FabriqueMetier;
import marine.etrs.model_Metier.entities_Class_Factory.exception.ContactException;
import marine.etrs.model_Metier.entities_Class_Factory.exception.CoordonneeException;
import marine.etrs.model_Metier.references_Constante_Enum.TypeMail;
import marine.etrs.model_Metier.references_Constante_Enum.TypeNumero;

import java.time.LocalDate;
import java.time.Month;

/**
 * CLASSE POUR UNE INSERTION DE DONNEE :
 */

public abstract class AbstractContactDao implements IContactMemoireDao { // CHANGER Xx par l'objet


    /*-------------------------------------------------
     * Initialisations dans la persistance mémoire.
     */

    public void init() {

        try {
            Contact miney = FabriqueMetier.fabriquerContact("Miney", "Bernard", LocalDate.of(1970, Month.DECEMBER, 12));


            Contact haddock = FabriqueMetier.fabriquerContact("HADDOCK", "Archibald", LocalDate.of(1970, Month.APRIL, 1));
            Contact tintin = FabriqueMetier.fabriquerContact("TINTIN", "Mar", LocalDate.of(1970, Month.FEBRUARY, 10));
            Contact tournesol = FabriqueMetier.fabriquerContact("TOURNESOL", "Tryphon", LocalDate.of(1970, Month.MAY, 20));


            Coordonnee ct1 = FabriqueMetier.fabriquerTelephone(miney, "0210101010", TypeNumero.DOMICILE);
            Coordonnee ct2 = FabriqueMetier.fabriquerTelephone(miney, "0610101010", TypeNumero.MOBILE);
            Coordonnee ct3 = FabriqueMetier.fabriquerTelephone(miney, "0600000000", TypeNumero.FAX);
            Coordonnee ct4 = FabriqueMetier.fabriquerTelephone(miney, "0666666660", TypeNumero.MOBILE);
            Coordonnee cm1 = FabriqueMetier.fabriquerMail(miney, "bernard.miney@dorothe.com", TypeMail.PERSONNEL);
            Coordonnee cm2 = FabriqueMetier.fabriquerMail(miney, "bernardm@free.fr", TypeMail.PERSONNEL);
            Coordonnee cm3 = FabriqueMetier.fabriquerMail(miney, "b.m@def.fr", TypeMail.PROFESSIONNEL);
            Coordonnee cm4 = FabriqueMetier.fabriquerMail(miney, "b.m1@def.fr", TypeMail.PROFESSIONNEL);


            miney.ajouterCoordonnees(ct1);
            miney.ajouterCoordonnees(ct2);
            miney.ajouterCoordonnees(ct3);
            miney.ajouterCoordonnees(ct4);
            miney.ajouterCoordonnees(cm1);
            miney.ajouterCoordonnees(cm2);
            miney.ajouterCoordonnees(cm3);
            miney.ajouterCoordonnees(cm4);


            Coordonnee c3 = FabriqueMetier.fabriquerTelephone(haddock, "0202020202", TypeNumero.DOMICILE);
            Coordonnee c4 = FabriqueMetier.fabriquerTelephone(haddock, "0606060606", TypeNumero.MOBILE);
            Coordonnee c5 = FabriqueMetier.fabriquerTelephone(tintin, "0203030303", TypeNumero.DOMICILE);
            Coordonnee c6 = FabriqueMetier.fabriquerTelephone(tournesol, "0607070707", TypeNumero.MOBILE);

            haddock.ajouterCoordonnees(c3);
            haddock.ajouterCoordonnees(c4);

            tintin.ajouterCoordonnees(c5);
            tournesol.ajouterCoordonnees(c6);

            this.create(miney);
            this.create(haddock);
            this.create(tintin);
            this.create(tournesol);


        } catch (ContactException | CoordonneeException | DaoException e) {
            e.printStackTrace();
        }

    }
    /* EXEMPLE DE METHODE PRESENTE DANS L'ABSTRACT :
    public abstract Article rechercherArticleParNom(String libelle);
    A CODER DANS XXXDaoImpl
    *  */



}
