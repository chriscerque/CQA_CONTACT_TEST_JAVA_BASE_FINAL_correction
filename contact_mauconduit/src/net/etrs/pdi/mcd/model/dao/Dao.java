package net.etrs.pdi.mcd.model.dao;

import net.etrs.pdi.mcd.model.dao.exceptions.DaoExceptions;

import java.util.List;

public interface Dao<T, K> {
    void create(final T var1) throws DaoExceptions;

    T read(final K var1) throws DaoExceptions;

    void delete(final T var1) throws DaoExceptions;

    void update(final T var1) throws DaoExceptions;

    List<T> readAll();

    boolean exist(final T var1) throws DaoExceptions;

    default void init() {
        throw new UnsupportedOperationException();
    }
}
