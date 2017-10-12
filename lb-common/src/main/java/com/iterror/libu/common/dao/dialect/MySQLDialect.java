package com.iterror.libu.common.dao.dialect;

/**
 * Created by tony.yan on 2017/10/12.
 */
public class MySQLDialect extends Dialect {
    public MySQLDialect() {
    }

    public boolean supportsLimitOffset() {
        return true;
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String sql, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
        return offset > 0?sql + " limit " + offsetPlaceholder + "," + limitPlaceholder:sql + " limit " + limitPlaceholder;
    }
}
