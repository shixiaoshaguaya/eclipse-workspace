package Ex0331;

/*
 * String类的替换与去除空格操作
 * 	程序开发中，用户输入数据时经常会有一些错误和空格，这时可以使用String类的replace（）和trim（）方法，进行字符串的替换和去除空格操作
 * 	public String replace（String oldStr， String newStr）
 * 		将原有字符串中oldStr字符串内容用newStr字符串所替代，返回一个新的字符串
 * 	public String trim（）返回一个新字符串，它去除了原有字符串的两端空格
 */
public class Ex04 {
	public static void main(String[] args) {
		String s = "itcast";
		// 字符串替换操作
		System.out.println("将it替换成cn.it的结果" + s.replace("it", "cn.it"));
		// 字符串去除空格操作
		String s1 = "   i t c a s t   ";
		System.out.println("去除字符串两端空格后的结果：" + s1.trim());
		System.out.println("去除字符串中所有空格的结果：" + s1.replace(" ", ""));
	}
}
