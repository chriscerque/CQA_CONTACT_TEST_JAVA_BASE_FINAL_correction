package model.facade.impl;

import model.dao.exceptions.DaoException;
import model.dao.impl.DaoFactory;
import model.dao.impl.IContactMemoireDao;
import model.entities.Contact;
import model.exceptions.ContactException;
import model.facade.ContactFacade;
import model.references.C;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private IContactMemoireDao contactDao;

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected ContactFacadeImpl() {
        this.contactDao = DaoFactory.fabriquerContactDao();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            this.contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_CREATION_EXCEPTION, contact.getNom(), contact.getPrenom()));
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_SUPPRESSION_EXCEPTION, contact.getPrenom(), contact.getPrenom()));
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {
        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION, contact.getNom(), contact.getPrenom()));
        }
    }

    @Override
    public void init() {
        this.contactDao.init();
    }

}
