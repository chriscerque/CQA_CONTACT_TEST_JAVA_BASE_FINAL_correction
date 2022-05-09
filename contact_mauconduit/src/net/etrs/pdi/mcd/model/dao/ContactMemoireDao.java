package net.etrs.pdi.mcd.model.dao;

import net.etrs.pdi.mcd.model.commons.entities.Contact;
import net.etrs.pdi.mcd.model.commons.references.ConstantesModel;
import net.etrs.pdi.mcd.model.dao.exceptions.DaoExceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ContactMemoireDao extends AbstractContactDao {
// ***** ATTRIBUTS ***** \\
    private final List<Contact> persistanceContact;

// ***** CONSTRUCTEUR ***** \\
    protected ContactMemoireDao(){
        this.persistanceContact = new ArrayList<>();
    }


    @Override
    public void create(final Contact var1) throws DaoExceptions {
        if (Objects.isNull(var1)) {
            throw new DaoExceptions(ConstantesModel.MSG_DAO_PERSITANCE_CONTACT);
        }

        if (exist(var1)) {
            throw new DaoExceptions(ConstantesModel.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }

        this.persistanceContact.add(var1);
    }

    @Override
    public Contact read(final String id) throws DaoExceptions {
        Contact contact = null;

        for (Contact c : this.persistanceContact) {
            if (contact.getId().equals(id)) {
               contact = c;
           }
        }

        return contact;
    }

    @Override
    public void delete(final Contact var1) throws DaoExceptions {
        if (Objects.isNull(var1)) {
            throw new DaoExceptions(ConstantesModel.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }

        if (!exist(var1)) {
            throw new DaoExceptions(ConstantesModel.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }

        this.persistanceContact.remove(var1);
    }

    @Override
    public void update(final Contact var1) throws DaoExceptions {
        int idx = this.persistanceContact.indexOf(var1);
        if (idx == -1) {
            throw new DaoExceptions(ConstantesModel.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }

        this.persistanceContact.set(idx, var1);
    }

    @Override
    public List<Contact> readAll() {
        return Collections.unmodifiableList(this.persistanceContact);
    }

    @Override
    public boolean exist(final Contact var1) {
        return this.persistanceContact.contains(var1);
    }
}
