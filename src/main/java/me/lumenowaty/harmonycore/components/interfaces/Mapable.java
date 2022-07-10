package me.lumenowaty.harmonycore.components.interfaces;

import java.util.Map;
import java.util.Optional;

public interface Mapable<T, K> {

    Map<T, K> clone();

    void add(T t, K k);

    void remove(T t);

    void set(T t, K k);

    void setMap(Map<T, K> map);

    boolean containsKey(T t);

    boolean containsValue(K k);

    Map<T, K> getMap();

    Optional<K> getByKey(T t);
}
