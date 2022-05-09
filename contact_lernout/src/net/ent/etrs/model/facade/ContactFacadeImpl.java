package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IContactMemoireDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.references.C;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade{

    protected ContactFacadeImpl() {}

    private IContactMemoireDao contactMemoireDao = DaoFactory.fabriquerContactDao();

    @Override
    public List<Contact> listerContacts() {
        return this.contactMemoireDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            this.contactMemoireDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_CREATION_EXCEPTION);
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {
        try {
            this.contactMemoireDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {
        try {
            this.contactMemoireDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION);
        }
    }

    @Override
    public void init(ContactFacade metier) {
        this.contactMemoireDao.init();
    }
}
