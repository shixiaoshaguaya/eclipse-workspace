package cz_JDBC.utils;

import java.util.List;

public class Page<T> {
	private int total; // ������
	private int page; // ��ǰҳ
	private int size; // ÿҳ��
	private int pageTotal;// ����ҳ
	private List<T> rows; // �����
	private int start = 1;// ������ʼҳ
	private int end;// ������ֹҳ

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
			// ˵������������ÿҳ��ʾpageSize�����ݣ�û�ж���һҳҪ��ʾ����pageSize�����ݵ�
			this.pageTotal = total / size;
		} else {
			// ����������Ҫ�ڼ�һҳ������ʾ��������ݡ�
			this.pageTotal = total / size + 1;
		}
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getStart() {
		// ��ʾ5ҳ�������Լ��������ã�����ʾ��ҳ���Լ�ͨ�������㷨�޸�
		this.start = 1;
		// ��ʾҳ�����㷨
		// ��ҳ������5����ô��Ҫ���ݵ�ǰ�ǵڼ�ҳ�����ж�start��endΪ�����ˣ�
		this.start = page - 2;
		if (start <= 0) {
			// ���統ǰҳ�ǵ�1ҳ�����ߵ�2ҳ����ô�Ͳ������������
			this.start = 1;
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		// ��ʾ5ҳ�������Լ��������ã�����ʾ��ҳ���Լ�ͨ�������㷨�޸�
		this.end = 5;
		// ��ʾҳ�����㷨
		if (this.getPageTotal() <= 5) {
			// ��ҳ����С��5����ôend��Ϊ��ҳ����ֵ�ˡ�
			this.end = this.getPageTotal();
		} else {
			// ��ҳ������5����ô��Ҫ���ݵ�ǰ�ǵڼ�ҳ�����ж�start��endΪ�����ˣ�
			this.end = page + 2;
			if (end > this.getPageTotal()) {
				// ���統ǰҳ�ǵ�����2ҳ�������һҳ��Ҳͬ�������������������
				this.end = this.getPageTotal();
			}
		}
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
