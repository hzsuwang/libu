package com.iterror.libu.common.dao.page;

/**
 * Created by tony.yan on 2017/10/12.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Page<T> implements Iterable<T> {
    protected List<T> result;
    protected int pageSize;
    protected int pageNumber;
    protected int totalCount;

    public Page() {
    }

    public Page(PageRequest p, int totalCount) {
        this(p.getPageSize(), p.getPageNumber(), totalCount);
    }

    public Page(int pageSize, int pageNumber, int totalCount) {
        this(pageSize, pageNumber, totalCount, new ArrayList());
    }

    public Page(int pageSize, int pageNumber, int totalCount, List<T> result) {
        if(pageSize <= 0) {
            throw new IllegalArgumentException("[pageSize] must great than zero");
        } else {
            this.pageSize = pageSize;
            this.pageNumber = PageUtil.normalizePageNumber(pageNumber, pageSize, totalCount);
            this.totalCount = totalCount;
            this.result = (List)(result != null?result:new ArrayList());
        }
    }

    public void setResult(List<T> result) {
        if(result == null) {
            throw new IllegalArgumentException("result must be not null");
        } else {
            this.result = result;
        }
    }

    public List<T> getResult() {
        return this.result;
    }

    public boolean isFirstPage() {
        return this.getPageNumber() == 1;
    }

    public boolean isLastPage() {
        return this.getPageNumber() >= this.getTotalPages();
    }

    public boolean hasNextPage() {
        return this.getTotalPages() > this.getPageNumber();
    }

    public boolean hasPreviousPage() {
        return this.getPageNumber() > 1;
    }

    public int getTotalPages() {
        return PageUtil.calcTotalPages(this.totalCount, this.pageSize);
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int firstItemNumberOfCurrentPage() {
        return (this.getPageNumber() - 1) * this.getPageSize() + 1;
    }

    public int lastItemNumberOfCurrentPage() {
        int fullPage = this.firstItemNumberOfCurrentPage() + this.getPageSize() - 1;
        int currentTotal = this.getTotalCount();
        return currentTotal < fullPage?currentTotal:fullPage;
    }

    public int getNextPageNumber() {
        return this.getPageNumber() + 1;
    }

    public int getPreviousPageNumber() {
        return this.getPageNumber() - 1;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public List<Integer> getLinkPageNumbers() {
        return PageUtil.generateLinkPageNumbers(this.getPageNumber(), this.getTotalPages(), 10);
    }

    public int getFirstResult() {
        return PageUtil.getFirstResult(this.pageNumber, this.pageSize);
    }

    public Iterator<T> iterator() {
        return this.result != null?this.result.iterator():Collections.emptyIterator();
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
