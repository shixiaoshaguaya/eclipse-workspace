package Ex0402;

/*
 * 通过一个案例来演示parseInt（）方法的使用，该案例实现了在屏幕上打印“*”矩形，其中宽和高分别设为20和10
 * 
 * Integer类的方法
 * 	public static int parseInt（String a）将字符串整数，解析成int类型
 * StringBuffer类的方法
 *  public String toSrting（）获取字符串缓冲区中的内容，以字符串形式返回
 */
public class Ex13 {
	public static void main(String[] args) {
		int w = Integer.parseInt("20");
		int h = Integer.parseInt("10");
		for (int i = 0; i < h; i++) {// 行数
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < w; j++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
	}
}
