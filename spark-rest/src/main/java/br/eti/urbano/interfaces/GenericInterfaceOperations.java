package br.eti.urbano.interfaces;

import java.util.List;

/**
 * Created by bruno on 19/08/16.
 * http://docs.oracle.com/javase/specs/jls/se7/html/jls-9.html#jls-9.4
 */
public interface GenericInterfaceOperations<E> {


    void create(final E entity);
    E read(final Integer id);
    void update(final E entity);
    void delete(final Integer id);

    void create(final List<E> entities);
    List<E> read(final List<Integer> ids);
    void update(final List<E> entities);
    void delete(final List<Integer> ids);
}
