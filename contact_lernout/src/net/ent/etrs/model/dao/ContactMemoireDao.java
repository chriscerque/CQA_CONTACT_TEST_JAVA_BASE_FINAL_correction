package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactMemoireDao extends AbstractContactDao{
    private List<Contact> persistence = new ArrayList<>();

    protected ContactMemoireDao() {}

    @Override
    public void create(final Contact var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException();
        }
        if (exist(var1)) {
            throw new DaoException();
        }
        this.persistence.add(var1);

    }

    @Override
    public Contact read(final String var1) throws DaoException {
        Contact p = null;
        for (Contact materielInformatique : this.persistence) {
            if (materielInformatique.getId().equals(var1)) {
                p = materielInformatique;
            }
        }
        return p;
    }


    @Override
    public void delete(final Contact var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException();
        }
        if (!exist(var1)) {
            throw new DaoException();
        }
        this.persistence.remove(var1);

    }

    @Override
    public void update(final Contact var1) throws DaoException {
        try {
            this.persistence.remove(var1);
            this.persistence.add(var1);
        } catch (Exception e) {
            throw new DaoException();
        }
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(Contact var1) throws DaoException {
        return false;
    }
}
