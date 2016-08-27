package com.pump.ia.domain.web;
import java.util.List;
public class Page<T> implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private int perPageSize = 10; // 一页显示多少条

	private int page = 1; //json中代表当前页码的数据

	private List<T> rows; // // json中代表实际模型数据的入口

	private long records = 0; // 一共有几条信息
	
	private Object condition; // 查询条件
	private int total = 0;
	public Page() {
	};

	public Page(int pageNum, int pageSize, Integer countNum, List<T> list) {
	
		countNum = countNum == null ? new Integer(0) : countNum;
		if ((countNum % pageSize) == 0) {
			total = countNum / pageSize;
		} else {
			total = countNum / pageSize + 1;
		}
		pageNum = pageNum > total ? total : pageNum;

		setRows(list);
		setRecords(countNum);
		setPage(pageNum);
		setPerPageSize(pageSize);

	}

	public int getPage() {
		return page;
	}

	public void setPage(int currentPage) {
		this.page = currentPage;
	}

	public int getPageNum() {
		if (records % perPageSize > 0) {
			return (int) (records / perPageSize) + 1;
		} else {
			return (int) (records / perPageSize);
		}
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> result) {
		this.rows = result;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long totalRowSize) {
		this.records = totalRowSize;
	}

	public boolean haveNextPage() {
		if ((page - 1) * perPageSize + rows.size() < records) {
			return true;
		} else {
			return false;
		}
	}

	public boolean havePreviousPage() {
		if (page > 1) {
			return true;
		} else {
			return false;
		}
	}

	public void setPerPageSize(int perPageSize) {
		this.perPageSize = perPageSize;
	}

	public int getPerPageSize() {
		return perPageSize;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Page<?> emptyPage(int pageSize) {
		return new Page(1, pageSize, 0, null);
	}
	
	public int getFirstResult() {
		return (page - 1) * perPageSize;
	}

	public Object getCondition() {
		return condition;
	}

	public void setCondition(Object condition) {
		this.condition = condition;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
