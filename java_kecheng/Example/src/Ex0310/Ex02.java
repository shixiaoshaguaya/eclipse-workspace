package Ex0310;

/*
 * �вι��췽��
 */
class Per02 {
	private int age;

	// �����вι��췽��
	public Per02(int a) {
		age = a;
	}

	public void speak() {
		System.out.println("�ҽ����Ѿ�" + age + "���ˣ�");
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Per02 p = new Per02(20);// ʵ����Per���󣬴��ݹ��췽��ʵ�ʲ���
		p.speak();
	}
}
