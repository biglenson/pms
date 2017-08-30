package com.zq.vo.process;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static final Integer PAGE_SIZE_10 = 10;
    public static final Integer PAGE_SIZE_100 = 100;

    private List<T> resultList;
    private int totalItems;
    private int totalPages;

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int size() {
        return resultList.size();
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

}
