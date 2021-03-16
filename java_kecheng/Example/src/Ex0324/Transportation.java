package Ex0324;

/*
 * 交通工具类
 */
public abstract class Transportation {
	private String number;// 编号
	private String model;// 型号
	private String admin;// 运货负责人

	public Transportation() {
		super();// 可省略
	}

	public Transportation(String number, String model, String admin) {
		this.number = number;
		this.model = model;
		this.admin = admin;
	}

	// 运输方法
	public abstract void transport();

	// 编号
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	// 型号
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// 负责人
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

}
