package com.zq.commons.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class PageInfo implements Serializable {
	private static final long serialVersionUID = 6267193571245317064L;
	public static String ResourceApply = "resource_apply";
	private String id;
	private boolean paged = false;

	private int pageSize = 0;

	private int pageCount = 1;

	private int currentPage = 1;

	private int totalRows = 0;

	private int rowCount = 0;

	private int columnCount = 0;

	private Properties conditions = new Properties();

	private HashMap filters = new HashMap();

	private boolean ordered = false;

	private String orderType = "";

	private String orderBy = "";
	private List items;

	public PageInfo() {
	}

	public PageInfo(String id, int currentPage, String orderType, String orderBy, Properties conditions) {
		this.id = id;
		this.currentPage = currentPage;
		this.conditions = conditions;
		this.orderType = orderType;
		this.orderBy = orderBy;
	}

	public String getOrderBySQL() {
		if ((this.orderBy != null) && (this.orderBy.length() > 0)) {
			return " order by " + this.orderBy + " " + this.orderType;
		}
		return "";
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isPaged() {
		return this.paged;
	}

	public void setPaged(boolean paged) {
		this.paged = paged;
	}

	public boolean isOrdered() {
		return this.ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRows() {
		return this.totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getRowCount() {
		return this.rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColumnCount() {
		return this.columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public Properties getConditions() {
		return this.conditions;
	}

	public void setConditions(Properties conditions) {
		this.conditions = conditions;
	}

	public HashMap getFilters() {
		return this.filters;
	}

	public void setFilters(HashMap filters) {
		this.filters = filters;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		if (("desc".equalsIgnoreCase(orderType)) || ("asc".equalsIgnoreCase(orderType)))
			this.orderType = orderType;
		else
			this.orderType = "";
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List getItems() {
		return this.items;
	}

	public void setItems(List items) {
		this.items = items;
	}
}