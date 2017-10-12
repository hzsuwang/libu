package com.iterror.libu.common.dao.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by tony.yan on 2017/10/12.
 */
public class PageUtil {
    private PageUtil() {
    }

    public static int getFirstResult(int pageNumber, int pageSize) {
        if(pageSize <= 0) {
            throw new IllegalArgumentException("[pageSize] must great than zero");
        } else {
            return (pageNumber - 1) * pageSize;
        }
    }

    public static List<Integer> generateLinkPageNumbers(int currentPageNumber, int lastPageNumber, int count) {
        int avg = count / 2;
        int startPageNumber = currentPageNumber - avg;
        if(startPageNumber <= 0) {
            startPageNumber = 1;
        }

        int endPageNumber = startPageNumber + count - 1;
        if(endPageNumber > lastPageNumber) {
            endPageNumber = lastPageNumber;
        }

        if(endPageNumber - startPageNumber < count) {
            startPageNumber = endPageNumber - count;
            if(startPageNumber <= 0) {
                startPageNumber = 1;
            }
        }

        List<Integer> result = new ArrayList();

        for(int i = startPageNumber; i <= endPageNumber; ++i) {
            result.add(Integer.valueOf(i));
        }

        return result;
    }

    public static int calcTotalPages(int totalCount, int pageSize) {
        return totalCount > 0 && totalCount > pageSize?(totalCount % pageSize == 0?totalCount / pageSize:totalCount / pageSize + 1):1;
    }

    public static int normalizePageNumber(int pageNumber, int pageSize, int totalCount) {
        return pageNumber <= 1?1:Math.min(pageNumber, calcTotalPages(totalCount, pageSize));
    }

    public static List<?> getPageResult(int pageNumber, int pageSize, List<?> dataList) {
        if(dataList != null && !dataList.isEmpty()) {
            List<Object> result = new ArrayList();
            int len = dataList.size();
            int minValue = (pageNumber - 1) * pageSize;
            int maxValue = (pageNumber - 1) * pageSize + pageSize;
            if(maxValue > len) {
                maxValue = len;
            }

            for(int i = minValue; i < maxValue; ++i) {
                result.add(dataList.get(i));
            }

            return result;
        } else {
            return Collections.EMPTY_LIST;
        }
    }
}
