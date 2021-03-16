package Ex0331;

/*
 * String类的异常演示
 * 	String字符串在获取某个字符时，会用到字符的索引，当访问字符串中的字符时，
 * 	如果字符的索引不存在，则会发生StringIndeOutOfBoundsException（字符串角标越界异常）
 */
public class Ex07 {
	public static void main(String[] args) {
		//声明一个字符串
		String s = "abcdedcba";
		System.out.println(s.charAt(10));
	}
}
