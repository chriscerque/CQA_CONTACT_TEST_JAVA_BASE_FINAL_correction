package net.etrs.pdi.mcd.model.facades;


import net.etrs.pdi.mcd.model.commons.entities.Contact;
import net.etrs.pdi.mcd.model.commons.entities.exceptions.ContactException;
import net.etrs.pdi.mcd.model.commons.exceptions.BusinessException;
import net.etrs.pdi.mcd.model.dao.DaoFactory;
import net.etrs.pdi.mcd.model.dao.IContactMemoireDao;
import net.etrs.pdi.mcd.model.dao.exceptions.DaoExceptions;

import java.util.List;

public class ContactFacadeImpl implements ContactFacade {

    private final IContactMemoireDao contactDao;

    protected ContactFacadeImpl() {
        this.contactDao = DaoFactory.fabriquerContactDao();
    }

    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws BusinessException {
        try {
            this.contactDao.create(contact);
        } catch (DaoExceptions e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws BusinessException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoExceptions e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws BusinessException {
        try {
            this.contactDao.update(contact);
        } catch (DaoExceptions e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void init() {
       this.contactDao.init();
    }
}
