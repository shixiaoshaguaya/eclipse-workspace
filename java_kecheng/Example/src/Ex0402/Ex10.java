package Ex0402;

import java.util.Random;

/*
 * Random���еĳ��÷���
 * 	public float nextFloat�����������0.0~1.0֮���floatС��
 * 	public int nextInt��int n���������0~n֮���int����������0��������n)
 * 	public double nextDouble�����������0.0~1.0֮���doubleС��
 */
public class Ex10 {
	public static void main(String[] args) {
		Random r1 = new Random();// ����Randomʵ������
		System.out.println("����float�����������" + r1.nextFloat());
		System.out.println("����0~100֮��int�����������" + r1.nextInt(100));
		System.out.println("����double���͵��������" + r1.nextDouble());
	}
}
