package cz0225;

/*
 * &与&&的使用
 */
public class Example06 {
	public static void main(String[] args) {
		int x = 0; // 定义变量x，赋值为0
		int y = 0; // 定义变量y，赋值为0
		int z = 0; // 定义变量z，赋值为0
		boolean a, b; // 定义a和b两个布尔变量
		a = x > 0 & y++ > 1;
		System.out.println(a);
		System.out.println("y = " + y);
		b = x > 0 && z++ > 1;
		System.out.println(b);
		System.out.println("z = " + z);
	}
}
