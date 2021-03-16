package Ex0331;

/*
 * String类的基本操作
 * 	在程序中，需要字符串进行一些基本操作，如果获得字符串长度、获得指定位置的字符等
 * 	public int length（）获取字符串的长度
 * 	public char charAt（int index）获取字符串中指定位置上的字符
 * 	public int indexOf（char ch）获取指定字符在字符串中第一次出现的位置
 * 	public int lastIndexOf（char ch）获取指定字符在字符串中最后一次出现的位置
 * 	public int indexOf（Sting str）获取指定子串在字符串中第一次出现的位置
 * 	public int lastIndexOf（String str）获取指定子串在字符串中最后一次出现的位置
*/
public class Ex02 {
	public static void main(String[] args) {
		String s = "ababcdedcba";// 声明字符串
		System.out.println("字符串的长度为：" + s.length());// 获取字符串长度，即字符个数
		System.out.println("字符串中第一次字符：" + s.charAt(0));
		System.out.println("字符c第一次出现的位置：" + s.indexOf('c'));
		System.out.println("字符c最后一次出现的位置：" + s.lastIndexOf('c'));
		System.out.println("子字符串第一次出现的位置：" + s.indexOf("ab"));
		System.out.println("子字符串最后一次出现的位置：" + s.lastIndexOf("ab"));
	}
}
