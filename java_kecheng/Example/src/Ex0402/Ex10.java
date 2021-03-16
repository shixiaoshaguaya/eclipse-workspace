package Ex0402;

import java.util.Random;

/*
 * Random类中的常用方法
 * 	public float nextFloat（）随机生成0.0~1.0之间的float小数
 * 	public int nextInt（int n）随机生成0~n之间的int整数（包含0，不包含n)
 * 	public double nextDouble（）随机生成0.0~1.0之间的double小数
 */
public class Ex10 {
	public static void main(String[] args) {
		Random r1 = new Random();// 创建Random实例对象
		System.out.println("产生float类型随机数：" + r1.nextFloat());
		System.out.println("产生0~100之间int类型随机数：" + r1.nextInt(100));
		System.out.println("产生double类型的随机数：" + r1.nextDouble());
	}
}
