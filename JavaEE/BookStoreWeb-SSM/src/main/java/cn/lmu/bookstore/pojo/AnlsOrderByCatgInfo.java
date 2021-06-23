package cn.lmu.bookstore.pojo;

public class AnlsOrderByCatgInfo {
	private String category_id;
	private String category_name;
	private Integer buyNum;
	private Integer buyMoney;

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public Integer getBuyMoney() {
		return buyMoney;
	}

	public void setBuyMoney(Integer buyMoney) {
		this.buyMoney = buyMoney;
	}

	public AnlsOrderByCatgInfo() {
		super();
	}

	public AnlsOrderByCatgInfo(String category_id, String category_name, Integer buyNum, Integer buyMoney) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.buyNum = buyNum;
		this.buyMoney = buyMoney;
	}
}
