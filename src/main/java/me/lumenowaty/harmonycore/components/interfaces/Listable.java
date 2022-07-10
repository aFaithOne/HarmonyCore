package me.lumenowaty.harmonycore.components.interfaces;

import java.util.List;
import java.util.Optional;

public interface Listable<T> {

    List<T> clone();

    void add(T t);

    void remove(T t);

    void setList(List<T> list);

    boolean contains(T t);

    Optional<T> getById(int id);

    List<T> getList();
}
