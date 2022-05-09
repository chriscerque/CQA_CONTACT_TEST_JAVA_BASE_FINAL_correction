package ent.etrs.pdi.pre.model.facade;

import ent.etrs.pdi.pre.model.dao.AbstractIContactDao;
import ent.etrs.pdi.pre.model.dao.DaoFactory;
import ent.etrs.pdi.pre.model.dao.exceptions.DaoException;
import ent.etrs.pdi.pre.model.entities.Contact;
import ent.etrs.pdi.pre.model.exceptions.ContactException;
import ent.etrs.pdi.pre.model.references.C;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade {
    /*------- ATTRIBUTS -------*/
    private AbstractIContactDao contactDao = DaoFactory.fabriquerContactDao();

    /*------- CONSTRUCTEUR(S) -------*/
    protected ContactFacadeImpl(){}

    /*------- METHODES IMPLEMENTEES -------*/

    @Override
    public List<Contact> listerContacts() {
        return contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException {
        try {
            contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_CREATION_EXCEPTION);
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException {
        try {
            contactDao.delete(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_SUPPRESSION_EXCEPTION);
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException {
        try {
            contactDao.update(contact);
        } catch (DaoException e) {
            throw new ContactException(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION);
        }
    }

    @Override
    public void init(ContactFacade metier) {
        contactDao.init();
    }
}
