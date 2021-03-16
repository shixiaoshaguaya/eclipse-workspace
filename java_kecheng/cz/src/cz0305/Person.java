package cz0305;

/*
 * 定义人类
 * 描述人这个事物
 * 人的名字
 * 购物功能
 */
public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	Product shooping(Market market, String name) {
		return market.sell(name);
	}
}
