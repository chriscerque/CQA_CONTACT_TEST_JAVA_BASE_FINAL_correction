package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.references.constantes.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactMemoireDao extends AbstractContactDao {

    private List<Contact> persistence = new ArrayList<>();

    protected ContactMemoireDao() {
    }


    @Override
    public void create(final Contact var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        if (exist(var1)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
        this.persistence.add(var1);
    }

    @Override
    public Contact read(String var1) throws DaoException {
        Contact c = null;
        for (Contact contact : this.persistence) {
            if (contact.getId().equals(var1)) {
                c = contact;
            }
        }
        return c;
    }

    @Override
    public void delete(Contact var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
        this.persistence.remove(var1);
    }

    @Override
    public void update(Contact var1) throws DaoException {
        try {
            this.persistence.remove(var1);
            this.persistence.add(var1);
        } catch (Exception e) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(Contact var1) throws DaoException {
        try {
            return this.persistence.contains(var1);
        } catch (Exception e) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
    }
}
