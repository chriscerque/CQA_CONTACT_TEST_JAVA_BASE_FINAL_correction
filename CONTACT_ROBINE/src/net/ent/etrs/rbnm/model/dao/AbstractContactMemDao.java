package net.ent.etrs.rbnm.model.dao;


import net.ent.etrs.rbnm.model.dao.exceptions.DaoException;
import net.ent.etrs.rbnm.model.entities.Contact;
import net.ent.etrs.rbnm.model.entities.Coordonnee;
import net.ent.etrs.rbnm.model.entities.FactoryMetier;
import net.ent.etrs.rbnm.model.exceptions.ContactException;
import net.ent.etrs.rbnm.model.exceptions.CoordonneeException;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeMail;
import net.ent.etrs.rbnm.model.references.enumerateds.TypeNumero;


import java.time.LocalDate;
import java.time.Month;

public abstract class AbstractContactMemDao implements IContactMemDao {

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public AbstractContactMemDao() {

    }


    /* *************************** */
    /* ***** AUTRES METHODES ***** */

    /**
     * Méthode permettant l'initialisation de l'implémentation Dao.
     */
    public void init() {
        try {
            Contact miney = FactoryMetier.fabriquerContact("Miney", "Bernard", LocalDate.of(1970, Month.DECEMBER, 12));


            Contact haddock = FactoryMetier.fabriquerContact("HADDOCK", "Archibald", LocalDate.of(1970, Month.APRIL, 1));
            Contact tintin = FactoryMetier.fabriquerContact("TINTIN", "Mar", LocalDate.of(1970, Month.FEBRUARY, 10));
            Contact tournesol = FactoryMetier.fabriquerContact("TOURNESOL", "Tryphon", LocalDate.of(1970, Month.MAY, 20));


            Coordonnee ct1 = FactoryMetier.fabriquerTelephone(miney, "0210101010", TypeNumero.DOMICILE);
            Coordonnee ct2 = FactoryMetier.fabriquerTelephone(miney, "0610101010", TypeNumero.MOBILE);
            Coordonnee ct3 = FactoryMetier.fabriquerTelephone(miney, "0600000000", TypeNumero.FAX);
            Coordonnee ct4 = FactoryMetier.fabriquerTelephone(miney, "0666666660", TypeNumero.MOBILE);
            Coordonnee cm1 = FactoryMetier.fabriquerMail(miney, "bernard.miney@dorothe.com", TypeMail.PERSONNEL);
            Coordonnee cm2 = FactoryMetier.fabriquerMail(miney, "bernardm@free.fr", TypeMail.PERSONNEL);
            Coordonnee cm3 = FactoryMetier.fabriquerMail(miney, "b.m@def.fr", TypeMail.PROFESSIONNEL);
            Coordonnee cm4 = FactoryMetier.fabriquerMail(miney, "b.m1@def.fr", TypeMail.PROFESSIONNEL);


            miney.ajouterCoordonnees(ct1);
            miney.ajouterCoordonnees(ct2);
            miney.ajouterCoordonnees(ct3);
            miney.ajouterCoordonnees(ct4);
            miney.ajouterCoordonnees(cm1);
            miney.ajouterCoordonnees(cm2);
            miney.ajouterCoordonnees(cm3);
            miney.ajouterCoordonnees(cm4);


            Coordonnee c3 = FactoryMetier.fabriquerTelephone(haddock, "0202020202", TypeNumero.DOMICILE);
            Coordonnee c4 = FactoryMetier.fabriquerTelephone(haddock, "0606060606", TypeNumero.MOBILE);
            Coordonnee c5 = FactoryMetier.fabriquerTelephone(tintin, "0203030303", TypeNumero.DOMICILE);
            Coordonnee c6 = FactoryMetier.fabriquerTelephone(tournesol, "0607070707", TypeNumero.MOBILE);

            haddock.ajouterCoordonnees(c3);
            haddock.ajouterCoordonnees(c4);

            tintin.ajouterCoordonnees(c5);
            tournesol.ajouterCoordonnees(c6);

            this.create(miney);
            this.create(haddock);
            this.create(tintin);
            this.create(tournesol);


        } catch (ContactException | CoordonneeException | DaoException e) {
            System.err.println(e.getMessage());
        }

    }


} 

