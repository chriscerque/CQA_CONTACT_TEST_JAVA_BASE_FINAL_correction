package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IContactMemoireDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.references.C;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade{
    private IContactMemoireDao contactDao;

    protected ContactFacadeImpl(){
        contactDao = DaoFactory.fabriquerContactDao();
    }

    @Override
    public List<Contact> listerContacts() {
        return contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(final Contact contact) throws ContactException {
        try {
            contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_CREATION_EXCEPTION, contact.getNom(), contact.getPrenom()));
        }
    }

    @Override
    public void supprimerContact(final Contact contact) throws ContactException {
        try {
            contactDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_SUPPRESSION_EXCEPTION, contact.getNom(), contact.getPrenom()));
        }
    }

    @Override
    public void mettreAJourContact(final Contact contact) throws ContactException {
        try {
            contactDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION, contact.getNom(), contact.getPrenom()));
        }
    }

    @Override
    public void init() {
        this.contactDao.init();
    }
}
