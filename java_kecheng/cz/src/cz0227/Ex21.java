package cz0227;

/*
 * ʹ���з���ֵ�ķ���
 */
public class Ex21 {
	public static void main(String[] args) {
		int area = getArea(3, 5);
		System.out.println("The area is " + area);
	}

	// ���������ķ���
	public static int getArea(int x, int y) {
		int temp = x * y;
		return temp;
	}
}
