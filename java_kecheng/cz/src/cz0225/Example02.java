package cz0225;

/*
 * 数据精度丢失
 */
public class Example02 {
	public static void main(String[] args) {
		byte a;
		int b = 298;
		a = (byte) b;
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
}
