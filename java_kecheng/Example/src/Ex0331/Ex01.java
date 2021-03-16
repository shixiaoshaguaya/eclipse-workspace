package Ex0331;

/*
 * String类的初始化操作
 * 	1.字符串常量直接赋值
 * 	2.String类的构造方法
 * 		String（）空参数构造方法，创建一个String类对象，内容为空
 * 		String（String s）创建一个String类对象，指定一个字符串内容
 * 		String（Char[] chs）创建一个String类对象，指定一个字符数组作为内容
 */
public class Ex01 {
	public static void main(String[] args) throws Exception {
		// 字符串常量直接赋值
		String str1 = "abc";
		// String（String s）创建一个String类对象，指定一个字符串内容
		String str2 = new String();
		// String（String s）创建一个String类对象，指定一个字符串内容
		String str3 = new String("abcd");
		// String（String s）创建一个String类对象，指定一个字符串内容
		char[] charArray = new char[] { 'E', 'F', 'G' };
		String str4 = new String(charArray);
		System.out.println(str1);
		System.out.println("a" + str2 + "b");
		System.out.println(str3);
		System.out.println(str4);
	}
}