package Ex0310;

/*
 * this�ؼ���
 * ������������
 * �ڹ��췽���е����������췽��
 */
class Per06 {
	private String name;

	public Per06() {
		this("Ĭ������");
	}

	public Per06(String name) {
		this.name = name;
	}

	public void speak() {
		System.out.println("��Һã��ҽ�" + name);
	}
}

public class Ex06 {
	public static void main(String[] args) {
		Per06 p = new Per06();
		p.speak();
	}
}
