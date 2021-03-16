package Ex0331;

/*
 * String类的转换操作
 * 	程序开发中，经常需要对字符串进行操作，例如将字符串转换成数组的形式，将字符串中的字符进行大小写转换等
 * 	public char[] toCharArry（）将此字符串转换成字符数组
 * 	public static String valueOf（int n）将指定int值转换成String类型
 *  public String toUpperCase（）将此字符串中的字符全部转换成大写字母，会返回一个新的字符串
 */
public class Ex03 {
	public static void main(String[] args) {
		// 声明一个字符串
		String str = "abcd";
		// 将此字符串转换成字符数组
		System.out.print("将字符串转换为字符数组后的结果：");
		char[] charArray = str.toCharArray();// 字符串转换为字符数组
		for (int i = 0; i < charArray.length; i++) {
			if (i != charArray.length - 1) {
				// 如果不是数组的最后一个元素，在元素后面加逗号
				System.out.print(charArray[i] + ",");
			} else {
				// 数组的最后一个元素后不加逗号
				System.out.println(charArray[i]);
			}
		}
		System.out.println("将int值转换为String类型之后的结果：" + String.valueOf(12));
		System.out.println("将字符串转换成大写之后的结果：" + str.toUpperCase());
	}
}
