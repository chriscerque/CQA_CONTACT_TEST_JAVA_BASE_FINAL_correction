package marine.etrs.dao;

import marine.etrs.dao.excpetions.DaoException;
import marine.etrs.model_Metier.entities_Class_Factory.Contact;

import java.util.ArrayList;
import java.util.Collections;


import java.util.List;
import java.util.Objects;

public class ContactMemoireDaoImpl extends AbstractContactDao {
    private List<Contact> persistence = new ArrayList<>();

    @Override
    public void create(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {
            throw new DaoException();
        }
        if (exist(contact)) {
            throw new DaoException();
        }
        this.persistence.add(contact);
    }

    @Override
    public void delete(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {
            throw new DaoException();
        }
        if (!exist(contact)) {
            throw new DaoException();
        }
        this.persistence.remove(contact);
    }

    @Override
    public boolean exist(final Contact contact) throws DaoException {
        try {
            return this.persistence.contains(contact);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Contact read(final String id) throws DaoException {
        Contact p = null;
        for (Contact contact : this.persistence) {
            if(contact.getId().equals(id)) {
                p = contact;
            }
        }
        return p;
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }



    @Override
    public void update(final Contact contact) throws DaoException {

        try {
            this.persistence.remove(contact);
            this.persistence.add(contact);
        }catch (Exception e) {
            throw new DaoException();
        }
    }


//                             ICI CODER LES METODES CF AbstractContactDao !!





}
