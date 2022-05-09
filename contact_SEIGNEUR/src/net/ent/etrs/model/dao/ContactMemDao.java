package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.references.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactMemDao extends AbstractContactDao{
    
    private List<Contact> persistanceContact = new ArrayList<>();

    protected ContactMemDao() {
    }

    @Override
    public void create(Contact var1) throws DaoException {
        System.out.println(C.MSG_DAO_PERSITANCE_CONTACT);
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        if (exist(var1)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
        this.persistanceContact.add(var1);
    }

    @Override
    public Contact read(String var1) throws DaoException {
        if (Objects.isNull(var1)){
            throw new DaoException(C.MSG_ID_NULL);
        }
        Contact p = null;
        for (Contact var1i : this.persistanceContact) {
            if (var1i.getId().equals(var1)) {
                p = var1i;
            }
        }
        return p;
    }

    @Override
    public void delete(final Contact var1) throws DaoException {
        System.out.println(C.MSG_DAO_SUPPRESSION_CONTACT);
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
        this.persistanceContact.remove(var1);
    }

    @Override
    public void update(final Contact var1) throws DaoException {
        System.out.println(C.MSG_DAO_MISE_A_JOUR_CONTACT);
        if (Objects.isNull(var1)){
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }

        int idx = this.persistanceContact.indexOf(var1);
        if (idx == -1) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
        this.persistanceContact.set(idx, var1);

    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistanceContact);
    }

    @Override
    public boolean exist(final Contact var1) throws DaoException {

        if (Objects.isNull(var1)){
            throw new DaoException(C.MSG_DAO_CONTACT_NULL);
        }
        try {
            return this.persistanceContact.contains(var1);
        } catch (Exception e) {
            throw new DaoException(C.MSG_AUCUN_CONTACT);
        }
    }
}
