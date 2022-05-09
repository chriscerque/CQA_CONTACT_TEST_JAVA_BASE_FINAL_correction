package ent.etrs.pdi.pre.model.dao;

import ent.etrs.pdi.pre.model.dao.exceptions.DaoException;
import ent.etrs.pdi.pre.model.entities.Contact;
import ent.etrs.pdi.pre.model.references.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactDaoImpl extends AbstractIContactDao {
    /*------- ATTRIBUTS -------*/
    private List<Contact> persistence = new ArrayList<>();

    /*------- CONSTRUCTEUR(S) -------*/
    protected ContactDaoImpl(){
        init();
    }

    /*------- AUTRES METHODES -------*/
    // INTERFACE DAO
    @Override
    public void create(final Contact model) throws DaoException {
        if (Objects.isNull(model)){
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        if (exist(model)){
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
        this.persistence.add(model);
    }

    @Override
    public Contact read(final String id) throws DaoException {
        Contact m = null;
        for (Contact model : this.persistence) {
            if (model.getId().equals(id)) {
                m = model;
            }
        }
        return m;
    }

    @Override
    public void delete(final Contact model) throws DaoException {
        if (Objects.isNull(model)){
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }
        if (!exist(model)){
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
    }

    @Override
    public void update(final Contact model) throws DaoException {
        if (Objects.isNull(model)){
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
        try {
            this.persistence.remove(model);
            this.persistence.add(model);
        } catch (Exception e) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }

    @Override
    public boolean exist(final Contact model) throws DaoException {
        try {
            return this.persistence.contains(model);
        } catch (Exception e) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
    }

    // ABSTRACT MODEL DAO
}
