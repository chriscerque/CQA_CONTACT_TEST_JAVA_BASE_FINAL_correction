package net.ent.etrs.model.dao.common;

import net.ent.etrs.model.dao.exceptions.DaoException;
import net.ent.etrs.model.references.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Classe générique permettant de mettre en place un accès à une mémoire.
 *
 * L'objet gérer par cette classe doit implémenter l'interface {@link ID}
 *
 * @param <T> Objet gérer en mémoire
 * @param <K> Type de la clé permettant d'identifier, de façon unique, les objets en mémoire
 */
public class GenericMemDao<T extends ID<K>,K> implements  Dao<T, K> {
    protected List<T> persistence = new ArrayList<T>();

    @Override
    public void create(final T t) throws DaoException {
        if (Objects.isNull(t)) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_NULL);
        }
        if (exist(t)) {
            throw new DaoException(C.MSG_DAO_PERSITANCE_CONTACT_EXISTANT);
        }
        this.persistence.add(t);
    }

    @Override
    public void delete(final T t) throws DaoException {
        if (Objects.isNull(t)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_NULL);
        }
        if (!exist(t)) {
            throw new DaoException(C.MSG_DAO_SUPPRESSION_CONTACT_INEXISTANT);
        }
        this.persistence.remove(t);
    }

    @Override
    public boolean exist(final T t) throws DaoException {
        try {
            return this.persistence.contains(t);
        } catch (Exception e) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
    }

    @Override
    public T read(final K id) throws DaoException {
        T p = null;
        for (T t : this.persistence) {
            if (t.getId().equals(id)) {
                p = t;
            }
        }
        return p;
    }

    @Override
    public List<T> readAll() {
        return Collections.unmodifiableList(this.persistence);
    }


    @Override
    public void update(final T t) throws DaoException {

        int idx = this.persistence.indexOf(t);
        if (idx == -1) {
            throw new DaoException(C.MSG_DAO_MISE_A_JOUR_CONTACT_INEXISTANT);
        }
        this.persistence.set(idx, t);
    }



}
