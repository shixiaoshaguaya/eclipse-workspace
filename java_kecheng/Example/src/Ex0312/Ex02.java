package Ex0312;

/*
 * �ⲿ������ڲ���
 */
class Outer02 {
	private int num = 4;// ����ĳ�Ա����

	// ����Ĵ��붨��һ����Ա�����������з����ڲ���
	public void test() {
		Inner inner = new Inner();
		inner.show();
	}

	// ����Ĵ��붨����һ����Ա�ڲ���
	class Inner {
		public void show() {
			System.out.println("num = " + num);
		}
	}
}

public class Ex02 {
	public static void main(String[] args) {
		Outer02.Inner inner = new Outer02().new Inner();
		inner.show();
	}
}
