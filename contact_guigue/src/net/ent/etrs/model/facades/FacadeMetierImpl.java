package net.ent.etrs.model.facades;

import net.ent.etrs.model.dao.AbstractContactDao;
import net.ent.etrs.model.dao.ContactMemoireDao;
import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.BusinessException;
import net.ent.etrs.model.exceptions.ContactException;

import java.util.List;

public class FacadeMetierImpl implements ContactFacade{
/*----------------------
Attributs +0+1
-----------------------*/

private AbstractContactDao contactDao = DaoFactory.fabriquerContactDao();

/*----------------------
AUTRES METHODES
-----------------------*/
protected FacadeMetierImpl() {

}

    @Override
    public List<Contact> listerContacts() {
        return this.contactDao.readAll();
    }

    @Override
    public void sauvegarderContact(Contact contact) throws ContactException, BusinessException {
        try {
            this.contactDao.create(contact);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void supprimerContact(Contact contact) throws ContactException, BusinessException {
        try {
            this.contactDao.delete(contact);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void mettreAJourContact(Contact contact) throws ContactException, BusinessException {
        try {
            this.contactDao.update(contact);
        } catch (DaoException e) {
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void init() {
    contactDao.init();
    }



}  // fin de classe

//TODO: Création Class FacadeMetierImpl
// 1-Attributs
// 2-GETTERS
// 3-SETTERS + REGLES DE GESTION
// 4-CONSTRUCTEUR - utiliser les SETTERS
// 5-EQUALS&HASHCODE
// 6-TOSTRING() - avec StringBuilder