package net.ent.etrs.rbnm.model.facades;

import net.ent.etrs.rbnm.model.dao.DaoFactory;
import net.ent.etrs.rbnm.model.dao.IContactMemDao;
import net.ent.etrs.rbnm.model.dao.exceptions.DaoException;
import net.ent.etrs.rbnm.model.entities.Contact;
import net.ent.etrs.rbnm.model.exceptions.BusinessExceptions;


import java.util.List;

public class ContactFacadeImpl implements ContactFacade {

    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private final IContactMemDao contactDao;



    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    protected ContactFacadeImpl() {
        this.contactDao = DaoFactory.fabriquerContactDao();

    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public List<Contact> listerContacts() {
        return contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws BusinessExceptions {
        try {
            contactDao.create(contact);
        } catch (DaoException e) {
            throw new BusinessExceptions(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void supprimerContact(Contact contact) throws BusinessExceptions {
        try {
            if (contactDao.exist(contact)){
                contactDao.delete(contact);
            }
        } catch (DaoException e) {
            throw new BusinessExceptions(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void mettreAJourContact(Contact contact) throws BusinessExceptions {
        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new BusinessExceptions(e.getMessage(), e.getCause());
        }

    }

    @Override
    public void init(ContactFacade metier) {
        contactDao.init();

    }

}
