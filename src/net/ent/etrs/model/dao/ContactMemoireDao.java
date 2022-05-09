package net.ent.etrs.model.dao;

import net.ent.etrs.model.comparator.ContactComparator;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.references.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Simule une persistance des formations en mémoire.
 *
 * @author christophe.cerqueira
 */
public class ContactMemoireDao extends AbstractContactDao {

    private final List<Contact> persistanceContact = new ArrayList<>();

//	private static final Log LOGGER_DAO = LogFactory.getLog("logger_contact_dao");
//	private static final Log LOGGER = LogFactory.getLog(ContactMemoireDao.class);

    /**
     *
     */
    protected ContactMemoireDao() {
    }

    /**
     * Opération de création d'un contact.
     *
     * @param c Contact a créer
     * @throws DaoException Exception levée si le contact est non attachée ou que le contact existe déjà.
     */
    @Override
    public void create(final Contact c) throws DaoException {
        if (Objects.isNull(c)) {
//			if(LOGGER_DAO.isWarnEnabled()) {
//				LOGGER_DAO.warn(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
//			}
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        if (this.exist(c)) {
//			if(LOGGER_DAO.isWarnEnabled()) {
//				LOGGER_DAO.warn(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
//			}
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
//		if(LOGGER.isInfoEnabled()) {
//			LOGGER.info(C.MSG_DAO_PERSITANCE_CONTACT);
//		}
        this.persistanceContact.add(c);
    }

    @Override
    public void delete(final Contact c) throws DaoException {
        if (Objects.isNull(c)) {
//			if(LOGGER_DAO.isWarnEnabled()) {
//				LOGGER_DAO.warn(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
//			}
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }
        if (!this.exist(c)) {
//			if(LOGGER_DAO.isWarnEnabled()) {
//				LOGGER_DAO.warn(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
//			}
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
//		if(LOGGER.isInfoEnabled()) {
//			LOGGER.info(C.MSG_DAO_SUPPRESSION_CONTACT);
//		}
        this.persistanceContact.remove(c);

    }

    @Override
    public boolean exist(final Contact c) {

        return this.persistanceContact.contains(c);
    }

    @Override
    public Contact read(final String id) {
        Contact retour = null;

        for (Contact contact : persistanceContact) {
            if (id.equals(contact.getId())) {
                retour = contact;
            }
        }

        return retour;
    }

    @Override
    public List<Contact> readAll() {
        Collections.sort(this.persistanceContact, new ContactComparator());
        return Collections.unmodifiableList(this.persistanceContact);
    }

    @Override
    public void update(final Contact c) throws DaoException {
        if (Objects.isNull(c)) {
//			if(LOGGER_DAO.isWarnEnabled()) {
//				LOGGER_DAO.warn(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
//			}
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }
        if (!this.exist(c)) {
//			if(LOGGER_DAO.isWarnEnabled()) {
//				LOGGER_DAO.warn(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
//			}
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }

//		this.delete(c);
//		this.create(c);
        this.persistanceContact.set(this.persistanceContact.indexOf(c), c);
    }

}
