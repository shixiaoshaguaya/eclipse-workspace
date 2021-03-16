package Ex0402;

/*
 * Math类中比较常见的方法
 * 	public static int abs（int a）返回参数的绝对值
 * 	public static double ceil（double a）返回大于参数的最小整数
 * 	public static double floor（double a)返回小于参数的最大整数
 * 	public static long round（dounle a）四舍五入
 * 	public static float max（float a, float b）返回两个数的较大值
 * 	public static double min（double a, double b）返回两个数的较小值
 * 	public static double random（）返回一个大于等于0.0小于1.0随机小数
 */
public class Ex07 {
	public static void main(String[] args) {
		System.out.println("计算绝对值的结果：" + Math.abs(-1));
		System.out.println("求大于参数的最小整数：" + Math.ceil(5.6));
		System.out.println("求小于参数的最大整数：" + Math.floor(-4.2));
		System.out.println("对小数进行四舍五入后的结果：" + Math.round(-4.6));
		System.out.println("求两个数的较大值：" + Math.max(2.1, -2.1));
		System.out.println("求两个数的较小值：" + Math.min(2.1, -2.1));
		System.out.println("生成一个大于等于0.0小于1.0随机值：" + Math.random());
	}
}
