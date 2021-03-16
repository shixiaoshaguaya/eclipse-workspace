package cz_JDBC.utils;

import java.util.List;

public class Page<T> {
	private int total; // 总条数
	private int page; // 当前页
	private int size; // 每页数
	private int pageTotal;// 共几页
	private List<T> rows; // 结果集
	private int start = 1;// 导航起始页
	private int end;// 导航截止页

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPageTotal() {
		if (total % size == 0) {
			// 说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
			this.pageTotal = total / size;
		} else {
			// 不整除，就要在加一页，来显示多余的数据。
			this.pageTotal = total / size + 1;
		}
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getStart() {
		// 显示5页，这里自己可以设置，想显示几页就自己通过下面算法修改
		this.start = 1;
		// 显示页数的算法
		// 总页数大于5，那么就要根据当前是第几页，来判断start和end为多少了，
		this.start = page - 2;
		if (start <= 0) {
			// 比如当前页是第1页，或者第2页，那么就不符合这个规则，
			this.start = 1;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		// 显示5页，这里自己可以设置，想显示几页就自己通过下面算法修改
		this.end = 5;
		// 显示页数的算法
		if (this.getPageTotal() <= 5) {
			// 总页数都小于5，那么end就为总页数的值了。
			this.end = this.getPageTotal();
		} else {
			// 总页数大于5，那么就要根据当前是第几页，来判断start和end为多少了，
			this.end = page + 2;
			if (end > this.getPageTotal()) {
				// 比如当前页是倒数第2页或者最后一页，也同样不符合上面这个规则
				this.end = this.getPageTotal();
			}
		}
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
