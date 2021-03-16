package Ex0324;

/*
 * 定义一个手机类，实现GPS接口，拥有定位功能
 */
public class Phone implements GPS {
	public Phone() {// 空参构造
		super();
	}

	// 定义方法
	public String showCoordinate() {
		String location = "193.485";
		return location;
	}

}
