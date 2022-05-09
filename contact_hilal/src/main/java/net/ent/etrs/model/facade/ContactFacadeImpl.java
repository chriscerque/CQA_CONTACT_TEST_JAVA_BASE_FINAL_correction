package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IContactMemoireDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade
{
    //attributs
    private IContactMemoireDao contactDao;

    //constructeurs
    public ContactFacadeImpl()
    {
        this.contactDao = DaoFactory.fabriquerContactDao();
    }

    //methodes
    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            this.contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(e.getMessage());
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(e.getMessage());
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {
        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException();
        }
    }

    @Override
    public void init() {
        this.contactDao.init();
    }
}
