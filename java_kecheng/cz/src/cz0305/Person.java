package cz0305;

/*
 * ��������
 * �������������
 * �˵�����
 * ���﹦��
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
