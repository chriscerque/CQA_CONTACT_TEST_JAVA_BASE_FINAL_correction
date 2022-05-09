package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.AbstractContactDao;
import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.references.C;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade{
    private AbstractContactDao contactDao = DaoFactory.fabriquerContactDao();

    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            this.contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_CREATION_EXCEPTION);
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {
        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION);
        }
    }

    @Override
    public void init() {
        contactDao.init();
    }
}
