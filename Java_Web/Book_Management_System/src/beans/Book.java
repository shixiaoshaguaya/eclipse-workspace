package beans;

public class Book {
	private String b_id;// 图书编号
	private String b_name;// 书名
	private String writer;// 作者
	private String sort_id;// 类别ID
	private float price;// 单价
	private int total_number;// 总数量
	private int current_number;// 当前数量
	private int borrow_number;// 借阅次数
	private String picturePath;// 图片
	
	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSort_id() {
		return sort_id;
	}

	public void setSort_id(String sort_id) {
		this.sort_id = sort_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTotal_number() {
		return total_number;
	}

	public void setTotal_number(int total_number) {
		this.total_number = total_number;
	}

	public int getCurrent_number() {
		return current_number;
	}

	public void setCurrent_number(int current_number) {
		this.current_number = current_number;
	}

	public int getBorrow_number() {
		return borrow_number;
	}

	public void setBorrow_number(int borrow_number) {
		this.borrow_number = borrow_number;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Book() {
		super();
	}

	public Book(String b_id, String b_name, String writer, String sort_id, float price, int total_number,
			int current_number, int borrow_number) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.writer = writer;
		this.sort_id = sort_id;
		this.price = price;
		this.total_number = total_number;
		this.current_number = current_number;
		this.borrow_number = borrow_number;
	}

	public Book(String b_id, String b_name, String writer, String sort_id, float price, int total_number,
			int current_number, int borrow_number, String picturePath) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.writer = writer;
		this.sort_id = sort_id;
		this.price = price;
		this.total_number = total_number;
		this.current_number = current_number;
		this.borrow_number = borrow_number;
		this.picturePath = picturePath;
	}
}
