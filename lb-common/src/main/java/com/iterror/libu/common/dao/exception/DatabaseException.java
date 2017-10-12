package com.iterror.libu.common.dao.exception;

/**
 * Created by tony.yan on 2017/10/12.
 */
public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = -429474197368260403L;

    public DatabaseException() {
    }

    public DatabaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseException(String message) {
        super(message);
    }

    public DatabaseException(Throwable cause) {
        super(cause);
    }
}
