package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.AbstractContactDao;
import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade {


////////////////////////////////////////////////////////////////////////////////
//-----------------------------------ATTRIBUTS --------------------------------//
////////////////////////////////////////////////////////////////////////////////



    private AbstractContactDao contactDao = DaoFactory.fabriquerContactDao();

////////////////////////////////////////////////////////////////////////////////
//-----------------------------------METHODES --------------------------------//
////////////////////////////////////////////////////////////////////////////////


    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }


    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {

    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException, DaoException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage());
        }

    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException, DaoException {

        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public void init(ContactFacade metier) {

    }


    @Override
    public void init() {
        contactDao.init();
    }


}
