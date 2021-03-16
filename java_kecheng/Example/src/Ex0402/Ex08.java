package Ex0402;

import java.util.Random;

/*
 * 使用构造方法Random（）产生随机数
 * 	public int nextInt（int n）0~n之间的随机整数，包含0，不包含n
 */
public class Ex08 {
	public static void main(String[] args) {
		Random r = new Random();// 不传入种子
		// 随机产生10个[0,100)之间的整数
		for (int x = 0; x < 10; x++) {
			System.out.println(r.nextInt(100));
		}
	}
}
