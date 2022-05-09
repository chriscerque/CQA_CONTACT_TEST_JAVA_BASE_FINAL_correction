package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IContactDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade{

    private IContactDao contactDao;

    protected ContactFacadeImpl() {
        this.contactDao = DaoFactory.fabriquerContactDao();
    }

    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            this.contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(e.getMessage(), e);
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(e.getMessage(), e);
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {
        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException(e.getMessage(), e);
        }
    }

    @Override
    public void init(ContactFacade metier) {
        contactDao.init();
    }
}
