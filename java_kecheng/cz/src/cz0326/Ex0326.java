package cz0326;

public class Ex0326 {
	public static void main(String[] args) {
		int a = 40;
		try {
			double r1 = divide(a, 2);
			System.out.println(r1);
		} catch (Exception e) {
			System.out.println("捕获的异常信息为：" + e.fillInStackTrace());
		}

		try {
			double r2 = divide(a, 0);
			System.out.println(r2);
		} catch (Exception e) {
			System.out.println("捕获的异常信息为：" + e.fillInStackTrace());
		}
	}

	public static double divide(int x, int y) throws Exception {
		double result = x / y;
		return result;
	}
}
