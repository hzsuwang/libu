package com.iterror.libu.common.dao.page;

/**
 * Created by tony.yan on 2017/10/12.
 */
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PageRequest {

    private final Map<String, Object> filters;
    private int                       pageNumber;
    private int                       pageSize;

    public PageRequest(){
        this(0, 0);
    }

    public PageRequest(int pageNumber, int pageSize){
        this(pageNumber, pageSize, new HashMap());
    }

    private PageRequest(int pageNumber, int pageSize, Map<String, Object> filters){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.filters = filters;
    }

    public static PageRequest newRequestWithoutPaging() {
        return new PageRequest(0, 2147483647);
    }

    public Map<String, Object> getFilters() {
        return this.filters != null ? Collections.unmodifiableMap(this.filters) : null;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNumberAndSize(int start, int limit) {
        this.pageSize = limit;
        this.pageNumber = start / limit;
    }

    public void putFilterIfNotNull(String key, Object value) {
        if (this.filters == null) {
            throw new IllegalArgumentException("Map filters could not be null");
        } else if (key == null) {
            throw new IllegalArgumentException("filter key could not be null");
        } else {
            if (value != null) {
                if (value instanceof String) {
                    String trimmed = ((String) value).trim();
                    if (!"".equals(trimmed)) {
                        this.filters.put(key, trimmed);
                    }
                } else if (value instanceof Collection) {
                    Collection coll = (Collection) value;
                    if (!coll.isEmpty()) {
                        this.filters.put(key, value);
                    }
                } else {
                    this.filters.put(key, value);
                }
            }

        }
    }

    public void removeFilter(String key) {
        if (this.filters == null) {
            throw new IllegalArgumentException("Map filters could not be null");
        } else if (key == null) {
            throw new IllegalArgumentException("filter key could not be null");
        } else {
            this.filters.remove(key);
        }
    }

    public Object getFilter(String key) {
        return this.filters != null ? this.filters.get(key) : null;
    }

    public boolean isFilterEmpty() {
        return this.getFilters().isEmpty();
    }

    public void lowerStringParam(String key) {
        Object object = this.getFilter(key);
        if (object instanceof String) {
            String value = (String) object;
            this.putFilterIfNotNull(key, value.toLowerCase());
        }

    }

    public void upperStringParam(String key) {
        Object object = this.getFilter(key);
        if (object instanceof String) {
            String value = (String) object;
            this.putFilterIfNotNull(key, value.toUpperCase());
        }

    }

    public String toString() {
        return "PageRequest{pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ", filters=" + this.filters + '}';
    }
}
