package Ex0331;

/*
 * String类的截取与分割操作
 * 	在String类中针对字符串的截取和分割操作提供了两个方法，
 * 	其中，substring（）方法用于截取字符串的一部分
 * 	split（）方法可以将字符串按照某个字符进行分割
 * 	
 * 	public String substring（int start）返回一个新字符串，指定位置开始截取，到字符串末尾结束
 * 	public String substring（int start， int end）返回一个新字符串，它从原有字符串指定位置开始截取，到指定位置结束
 * 	public String[] split（String regex）按照指定的字符串进行分割返回一个字符串数组
 */
public class Ex06 {
	public static void main(String[] args) {
		String str = "羽毛球-篮球-乒乓球";
		// 下面是字符串截取操作
		System.out.println("从第5个字符截取到末尾的结果：" + str.substring(4));
		System.out.println("从第5个字符截取到第6个字符的结果：" + str.substring(4, 6));// 不包含结尾位置的字符
		// 下面是字符串分割操作
		System.out.println("分割后的字符串数组中的元素依次为：");
		String[] strArray = str.split("-");// 将字符串转换为字符串数组
		for (int i = 0; i < strArray.length; i++) {
			if (i != strArray.length - 1) {
				// 如果不是数组的最后一个元素，在元素后面加逗号
				System.out.print(strArray[i] + ",");
			} else {
				// 数组的最后一个元素后面不加逗号
				System.out.println(strArray[i]);
			}
		}
	}
}
