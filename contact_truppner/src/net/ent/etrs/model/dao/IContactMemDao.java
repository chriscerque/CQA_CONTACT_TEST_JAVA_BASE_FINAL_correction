package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;

import java.util.List;

public interface IContactMemDao extends IDao<Contact, String> {
    void create(Contact contact) throws DaoException;

    void delete(Contact contact) throws DaoException;

    boolean exist(Contact contact) throws DaoException;

    Contact read(String id) throws DaoException;

    List<Contact> readAll();

    void update(Contact contact) throws DaoException;
}
