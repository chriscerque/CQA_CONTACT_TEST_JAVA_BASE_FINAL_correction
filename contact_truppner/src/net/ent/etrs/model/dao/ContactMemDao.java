package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;

import java.util.*;

public class ContactMemDao extends AbstractContactDao implements IContactMemDao {

    private List<Contact> persistenceContact = new ArrayList<>();

    /////CONSTRUCTEUR/////
    protected ContactMemDao() {
    }

    @Override
    public void create(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {
            throw new DaoException();
        }
        if (exist(contact)) {
            throw new DaoException();
        }
        this.persistenceContact.add(contact);
    }

    @Override
    public void delete(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {
            throw new DaoException();
        }
        if (!exist(contact)) {
            throw new DaoException();
        }
        this.persistenceContact.remove(contact);
    }

    @Override
    public boolean exist(final Contact contact) throws DaoException {
        try {
            return this.persistenceContact.contains(contact);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Contact read(String id) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistenceContact);
    }

    @Override
    public void update(final Contact contact) throws DaoException {
        try {
            this.persistenceContact.remove(contact);
            this.persistenceContact.add(contact);
        } catch (Exception e) {
            throw new DaoException();
        }
    }
}
