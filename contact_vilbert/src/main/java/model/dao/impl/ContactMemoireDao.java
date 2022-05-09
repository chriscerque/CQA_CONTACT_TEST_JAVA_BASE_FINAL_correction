package model.dao.impl;

import model.dao.exceptions.DaoException;
import model.entities.Contact;
import model.references.C;

import java.security.cert.CertificateParsingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactMemoireDao extends AbstractContactDao {

    //////////////////////////////////////////////////////////////////////////////////////////
    //                                     ATTRIBUTES                                       //
    //////////////////////////////////////////////////////////////////////////////////////////

    private List<Contact> persistanceContact = new ArrayList<>();

    //////////////////////////////////////////////////////////////////////////////////////////
    //				                      CONSTRUCTORS				                        //
    //////////////////////////////////////////////////////////////////////////////////////////

    protected ContactMemoireDao() {
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    //					                    METHODS				                         	//
    //////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void create(Contact var1) throws DaoException {
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
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        for (Contact contact : this.persistanceContact) {
            if (contact.getId().equals(var1))
                return contact;
        }
        throw new DaoException(C.MSG_DAO_LECTURE_CONTACT_INEXISTANT );
    }

    @Override
    public void delete(Contact var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
        this.persistanceContact.remove(var1);
    }

    @Override
    public void update(Contact var1) throws DaoException {
        if (Objects.isNull(var1)) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }
        if (!exist(var1)) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
        int indexObject = this.persistanceContact.indexOf(var1);
        this.persistanceContact.set(indexObject, var1);
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistanceContact);
    }

    @Override
    public boolean exist(Contact var1) throws DaoException {
        try {
            return this.persistanceContact.contains(var1);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

}
