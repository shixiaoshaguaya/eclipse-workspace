package Ex0312;

/*
 * ��Ա�ڲ���
 */
class Outer01 {
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

public class Ex01 {
	public static void main(String[] args) {
		Outer01 outer = new Outer01();
		outer.test();
	}
}
