package net.ent.etrs.model.dao;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.entities.Contact;
import net.ent.etrs.model.references.C;

public class ContactMemoireDao extends AbstractContactDao {

    protected ContactMemoireDao() {}

    @Override
    public Contact read(String var1) throws DaoException {
        for (Contact c : this.persistence) {
            if (c.getId().equals(var1)) {
                return c;
            }
        }
        throw new DaoException(C.MSG_CONTACT_INEXISTANT);
    }

    //TODO dao avec messages personnalisées
}
