package Ex0402;

/*
 * public static long currentTimMillis（）
 * 	方法返回一个long类型的值，该值表示当前时间与1970年1月1日0点0分0秒之间的时间差，单位是毫秒，通常也将该值作时间数
 */
public class Ex02 {
	public static void main(String[] args) {
		// 计算程序在进行求和操作时所消耗的时间
		long startTime = System.currentTimeMillis();// 循环开始时的当前时间
		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long endTime = System.currentTimeMillis();// 循环结束的当前时间
		System.out.println("程序运行的时间为：" + (endTime - startTime) + "毫秒");
	}
}
