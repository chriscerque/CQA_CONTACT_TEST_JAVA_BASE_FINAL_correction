package net.ent.etrs.model.dao.common;

/**
 * Interface permettant d'identifier, de façon unique, un objet.
 *
 * @param <K> type d'objet 
 */
public interface ID<K> {

    /**
     * Méthode retournant la clé identifaint un objet.
     *
     * @return valeur unique
     */
    K getId();
}
