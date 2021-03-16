package cz0227;

/*
 * 不使用方法时打印三个长宽不同的矩形
 */
public class Ex19 {
	public static void main(String[] args) {
		// 用*打印宽为3，高为5的长方形
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		// 用*打印宽为2，高为4的长方形
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		// 用*打印宽为6，高为10的长方形
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
}
