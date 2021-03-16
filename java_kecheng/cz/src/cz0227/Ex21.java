package cz0227;

/*
 * 使用有返回值的方法
 */
public class Ex21 {
	public static void main(String[] args) {
		int area = getArea(3, 5);
		System.out.println("The area is " + area);
	}

	// 求矩形面积的方法
	public static int getArea(int x, int y) {
		int temp = x * y;
		return temp;
	}
}
