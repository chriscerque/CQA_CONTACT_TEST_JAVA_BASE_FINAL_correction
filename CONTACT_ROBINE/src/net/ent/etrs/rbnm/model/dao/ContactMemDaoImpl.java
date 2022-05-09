package net.ent.etrs.rbnm.model.dao;

import net.ent.etrs.rbnm.model.dao.exceptions.DaoException;
import net.ent.etrs.rbnm.model.entities.Contact;
import net.ent.etrs.rbnm.model.references.constantes.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactMemDaoImpl extends AbstractContactMemDao {


    /* ********************* */
    /* ***** ATTRIBUTS ***** */
    private List<Contact> persistence = new ArrayList<>();

    /* ************************* */
    /* ***** CONSTRUCTEURS ***** */
    public ContactMemDaoImpl() {

    }

    /* *************************** */
    /* ***** AUTRES METHODES ***** */
    @Override
    public void create(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {

            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        if (exist(contact)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
        this.persistence.add(contact);
    }

    @Override
    public Contact read(final String str) throws DaoException {
        Contact c = null;
        for (Contact contact : this.persistence) {
            if (contact.getId().equals(str)) {
                c = contact;
            }
        }
        return c;
    }

    @Override
    public void delete(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }
        if (!exist(contact)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
        this.persistence.remove(contact);

    }

    @Override
    public void update(final Contact contact) throws DaoException {
        if (Objects.isNull(contact)) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }
        int index = this.persistence.indexOf(contact);
        this.persistence.set(index, contact);
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(final Contact contact) throws DaoException {
        try {
            return this.persistence.contains(contact);

        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}  

