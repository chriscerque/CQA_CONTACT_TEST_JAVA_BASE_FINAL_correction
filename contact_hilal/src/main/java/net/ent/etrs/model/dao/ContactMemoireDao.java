package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.references.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContactMemoireDao extends AbstractContactDao
{
    //attributs de la class DAO
    private List<Contact> persistanceContact;

    //constructeurs
    public ContactMemoireDao() {
        this.persistanceContact = new ArrayList<>();
    }

    //methodes
    @Override
    public void create(Contact var1) throws DaoException {
        if(this.exist(var1))
        {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
        persistanceContact.add(var1);
    }

    @Override
    public Contact read(String var1) throws DaoException {
        Contact retour = null;
        for (Contact c:persistanceContact) {
            if(var1.equals(c.getId()))
            {
                retour = c;
            }
        }
        if(Objects.isNull(retour))
        {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_NULL);
        }
        return retour;
    }

    @Override
    public void delete(Contact var1) throws DaoException {
        if(!this.exist(var1))
        {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
        persistanceContact.remove(var1);
    }

    @Override
    public void update(Contact var1) throws DaoException {
        if(!persistanceContact.contains(var1))
        {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
        if(Objects.isNull(var1))
        {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }
        persistanceContact.set(persistanceContact.indexOf(var1), var1);
    }

    @Override
    public List<Contact> readAll() {
        return persistanceContact;
    }

    @Override
    public boolean exist(Contact var1) throws DaoException {
        return persistanceContact.contains(var1);
    }
}
