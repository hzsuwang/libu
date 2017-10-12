package com.iterror.libu.common.dao.mapper;

/**
 * Created by tony.yan on 2017/10/12.
 */
public abstract class SimpleMapMapper<K, V> implements MapMapper<V, K, V> {
    public SimpleMapMapper() {
    }

    public V mapValue(V object, int rowNum) {
        return object;
    }
}
