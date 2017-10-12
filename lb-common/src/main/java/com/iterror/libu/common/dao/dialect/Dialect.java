package com.iterror.libu.common.dao.dialect;

/**
 * Created by tony.yan on 2017/10/12.
 */
public class Dialect {
    public Dialect() {
    }

    public boolean supportsLimit() {
        return false;
    }

    public boolean supportsLimitOffset() {
        return this.supportsLimit();
    }

    public String getLimitString(String sql, int offset, int limit) {
        return this.getLimitString(sql, offset, Integer.toString(offset), limit, Integer.toString(limit));
    }

    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        throw new UnsupportedOperationException("paged queries not supported");
    }
}
