package com.iterror.libu.common.dao.mapper;

/**
 * Created by tony.yan on 2017/10/12.
 */
public interface MapMapper<E, K, V> {
    K mapKey(E var1, int var2);

    V mapValue(E var1, int var2);
}
