package Ex0310;

/*
 * ���췽��������
 */
class Per03 {
	private String name;
	private int age;

	// �������������Ĺ��췽��
	public Per03(String con_name, int con_age) {
		name = con_name;
		age = con_age;
	}

	// ����һ�������Ĺ��췽��
	public Per03(String con_name) {
		name = con_name;
	}

	public void speak() {
		// ��ӡname��age��ֵ
		System.out.println("��Һã��ҽ�" + name + ",�ҽ���" + age + "��");
	}
}

public class Ex03 {
	public static void main(String[] args) {
		// �ֱ𴴽���������p1��p2
		Per03 p1 = new Per03("С��");
		Per03 p2 = new Per03("С��", 20);
		// ͨ������p1��p2����speak����
		p1.speak();
		p2.speak();
	}
}
