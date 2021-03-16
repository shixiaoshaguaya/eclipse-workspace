package beans;

public class Sort {
	private String sort_id;// 类别ID
	private String sort_name;// 类别名

	public String getSort_id() {
		return sort_id;
	}

	public void setSort_id(String sort_id) {
		this.sort_id = sort_id;
	}

	public String getSort_name() {
		return sort_name;
	}

	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}

	public Sort() {
		super();
	}

	public Sort(String sort_id, String sort_name) {
		super();
		this.sort_id = sort_id;
		this.sort_name = sort_name;
	}
}
