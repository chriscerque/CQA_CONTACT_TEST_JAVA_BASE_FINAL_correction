/**
 *
 */
package net.ent.etrs.model.facade;

import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IContactMemoireDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;
import net.ent.etrs.model.references.C;

import java.util.Collections;
import java.util.List;

/**
 * @author christophe.cerqueira
 */
public class ContactFacadeImpl implements ContactFacade {

    //	private static final Log LOGGER = LogFactory.getLog(ContactFacadeImpl.class);
    private final IContactMemoireDao contactDao;

    /**
     *
     */
    protected ContactFacadeImpl() {
        contactDao = DaoFactory.fabriquerContactDao();
    }


    @Override
    public List<Contact> listerContacts() {
        return Collections.unmodifiableList(contactDao.readAll());
    }


    @Override
    public void sauvegarderContact(final Contact contact) throws ContactException {
        try {
//			if(LOGGER.isInfoEnabled()) {
//				LOGGER.info(String.format("Sauvegarde du contact : %s", c.toString()));
//			}
            contactDao.create(contact);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_CREATION_EXCEPTION, contact.getNom(), contact.getPrenom()), e);
        }
    }


    @Override
    public void supprimerContact(final Contact c) throws ContactException {
        try {
//			if(LOGGER.isInfoEnabled()) {
//				LOGGER.info(String.format("Suppression du contact : %s", c.toString()));
//			}
            contactDao.delete(c);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_SUPPRESSION_EXCEPTION, c.getNom(), c.getPrenom()), e);
        }

    }

    @Override
    public void mettreAJourContact(final Contact c) throws ContactException {
        try {
//			if(LOGGER.isInfoEnabled()) {
//				LOGGER.info(String.format("Mise à jour du contact : %s", c.toString()));
//			}
            contactDao.update(c);
        } catch (DaoException e) {
            throw new ContactException(String.format(C.MSG_CONTACT_MISE_A_JOUR_EXCEPTION, c.getNom(), c.getPrenom()), e);
        }
    }

    @Override
    public void init(ContactFacade metier) {
        this.contactDao.init();
    }

}
