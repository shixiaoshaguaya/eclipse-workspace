package cz0225;

/*
 * &��&&��ʹ��
 */
public class Example06 {
	public static void main(String[] args) {
		int x = 0; // �������x����ֵΪ0
		int y = 0; // �������y����ֵΪ0
		int z = 0; // �������z����ֵΪ0
		boolean a, b; // ����a��b������������
		a = x > 0 & y++ > 1;
		System.out.println(a);
		System.out.println("y = " + y);
		b = x > 0 && z++ > 1;
		System.out.println(b);
		System.out.println("z = " + z);
	}
}
