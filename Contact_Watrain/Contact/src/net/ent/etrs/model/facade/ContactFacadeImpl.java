package net.ent.etrs.model.facade;

import net.ent.etrs.model.comparator.ContactComparator;
import net.ent.etrs.model.dao.DaoFactory;
import net.ent.etrs.model.dao.IContactMemDao;
import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.exceptions.ContactException;

import java.util.Collections;
import java.util.List;

public class ContactFacadeImpl implements ContactFacade {
	//<editor-fold desc="Attributs">
	private IContactMemDao contactDao = DaoFactory.fabriquerContactDao();
	//</editor-fold>

	protected ContactFacadeImpl() {
	}

	@Override
	public List<Contact> listerContacts() {
		//contactDao.readAll().sort(new ContactComparator());
		return contactDao.readAll();

	}

	@Override
	public void sauvegarderContact(Contact contact) throws ContactException {
		try {
			contactDao.create(contact);
		} catch (DaoException e) {
			throw new ContactException(e.getMessage());
		}
	}

	@Override
	public void supprimerContact(Contact contact) throws ContactException {
		try {
			contactDao.delete(contact);
		} catch (DaoException e) {
			throw new ContactException(e.getMessage());
		}
	}

	@Override
	public void mettreAJourContact(Contact contact) throws ContactException {
		try {
			contactDao.update(contact);
		} catch (DaoException e) {
			throw new ContactException(e.getMessage());
		}
	}

	@Override
	public void init() {
		contactDao.init();
	}
} 