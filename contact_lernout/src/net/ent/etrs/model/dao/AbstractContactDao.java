package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.entities.Coordonnee;
import net.ent.etrs.model.entities.EntitiesFactory;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.exceptions.CoordonneeException;
import net.ent.etrs.model.references.TypeMail;
import net.ent.etrs.model.references.TypeNumero;

import java.time.LocalDate;
import java.time.Month;

public abstract class AbstractContactDao implements IContactMemoireDao{

    public void init() {
        try {
            Contact miney = EntitiesFactory.fabriquerContact("Miney", "Bernard", LocalDate.of(1970, Month.DECEMBER, 12));


            Contact haddock = EntitiesFactory.fabriquerContact("HADDOCK", "Archibald", LocalDate.of(1970, Month.APRIL, 1));
            Contact tintin = EntitiesFactory.fabriquerContact("TINTIN", "Mar", LocalDate.of(1970, Month.FEBRUARY, 10));
            Contact tournesol = EntitiesFactory.fabriquerContact("TOURNESOL", "Tryphon", LocalDate.of(1970, Month.MAY, 20));


            Coordonnee ct1 = EntitiesFactory.fabriquerTelephone(miney, "0210101010", TypeNumero.DOMICILE);
            Coordonnee ct2 = EntitiesFactory.fabriquerTelephone(miney, "0610101010", TypeNumero.MOBILE);
            Coordonnee ct3 = EntitiesFactory.fabriquerTelephone(miney, "0600000000", TypeNumero.FAX);
            Coordonnee ct4 = EntitiesFactory.fabriquerTelephone(miney, "0666666660", TypeNumero.MOBILE);
            Coordonnee cm1 = EntitiesFactory.fabriquerMail(miney, "bernard.miney@dorothe.com", TypeMail.PERSONNEL);
            Coordonnee cm2 = EntitiesFactory.fabriquerMail(miney, "bernardm@free.fr", TypeMail.PERSONNEL);
            Coordonnee cm3 = EntitiesFactory.fabriquerMail(miney, "b.m@def.fr", TypeMail.PROFESSIONNEL);
            Coordonnee cm4 = EntitiesFactory.fabriquerMail(miney, "b.m1@def.fr", TypeMail.PROFESSIONNEL);


            miney.ajouterCoordonnees(ct1);
            miney.ajouterCoordonnees(ct2);
            miney.ajouterCoordonnees(ct3);
            miney.ajouterCoordonnees(ct4);
            miney.ajouterCoordonnees(cm1);
            miney.ajouterCoordonnees(cm2);
            miney.ajouterCoordonnees(cm3);
            miney.ajouterCoordonnees(cm4);


            Coordonnee c3 = EntitiesFactory.fabriquerTelephone(haddock, "0202020202", TypeNumero.DOMICILE);
            Coordonnee c4 = EntitiesFactory.fabriquerTelephone(haddock, "0606060606", TypeNumero.MOBILE);
            Coordonnee c5 = EntitiesFactory.fabriquerTelephone(tintin, "0203030303", TypeNumero.DOMICILE);
            Coordonnee c6 = EntitiesFactory.fabriquerTelephone(tournesol, "0607070707", TypeNumero.MOBILE);

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
