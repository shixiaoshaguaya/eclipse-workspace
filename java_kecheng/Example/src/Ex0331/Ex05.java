package Ex0331;

/*
 * String类的判断操作
 * 	操作字符串时，经常需要对字符串进行一些判断，如判断字符函数是否以指定的字符串开始、结束，是否包含指定的字符串，字符串是否为空等
 * 	public boolean startsWith（String str）判断字符串是否以字符串Str开头
 * 	public boolean endsWith（String str）判断是否以字符串ng结尾
 * 	public boolean contains（String str）判断是否包含字符串tri
 * 	public boolean isEmpty（）判断字符串是否为空
 * 	public boolean equals（String str）判断两个字符串是否相等
 */
public class Ex05 {
	public static void main(String[] args) {
		String s1 = "String";// 声明一个字符串
		String s2 = "Str";
		System.out.println("判断是否以字符串Str开头：" + s1.startsWith("Str"));
		System.out.println("判断是否以字符串ng结尾：" + s1.endsWith("ng"));
		System.out.println("判断是否包含字符串tri：" + s1.contains("tri"));
		System.out.println("判断字符串是否为空：" + s1.isEmpty());
		System.out.println("判断两个字符串是否相等：" + s2.equals(s2));
	}
}
