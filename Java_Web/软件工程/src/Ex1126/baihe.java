package Ex1126;

import java.util.Scanner;

public class baihe {
	public static void main(String[] args) {
		Scanner i1 = new Scanner(System.in);
		System.out.print("X=");
		int X = i1.nextInt();
		Scanner i2 = new Scanner(System.in);
		System.out.print("Y=");
		int Y = i2.nextInt();
		aaa(X, Y);
		System.out.println("K=" + aaaReturn());
	}

	private static int K;

	public static void aaa(int X, int Y) {
		if (X >= 40 && Y >= 40) {
			K = 1;
		} else if ((X + Y) >= 70 && (X >= 50 || Y > 50)) {
			K = 2;
		} else {
			K = 3;
		}
	}
	
	public static int aaaReturn() {
		return K;
	}
}
