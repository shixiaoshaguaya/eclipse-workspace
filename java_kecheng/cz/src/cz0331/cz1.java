package cz0331;

public class cz1 {
	public static void main(String[] args) {
		String str1 = new String();// 创建空字符串
		String str2 = "chenzhe";// 创建自己姓名拼音字母的字符串
		// 创建姓名字母为字符数组的字符串
		char[] char1 = new char[] {'C','Z'};
		String str3 = new String(char1);
		//输出
		System.out.println("第（1）题：");
		System.out.println("a"+str1+"b");
		System.out.println(str2);
		System.out.println(str3);
		System.out.println("第（2）题：");
		System.out.println("字符串的长度为：" + str2.length());
		System.out.println("字符串中第一次字符：" + str2.charAt(0));
		System.out.println("字符c第一次出现的位置：" + str2.indexOf('e'));
		System.out.println("字符c最后一次出现的位置：" + str2.lastIndexOf('e'));
		System.out.println("子字符串第一次出现的位置：" + str2.indexOf("he"));
		System.out.println("子字符串最后一次出现的位置：" + str2.lastIndexOf("he"));
		System.out.println("第（3）题：");
		System.out.print("将字符串转换为字符数组后的结果：");
		char[] char2 = str2.toCharArray();// 字符串转换为字符数组
		for (int i = 0; i < char2.length; i++) {
			if (i != char2.length - 1) {
				System.out.print(char2[i] + ",");
			} else {
				System.out.println(char2[i]);
			}
		}
		System.out.println("将int值转换为String类型之后的结果：" + String.valueOf(12));
		System.out.println("将字符串转换成大写之后的结果：" + str2.toUpperCase());
		System.out.println("第（4）题：");
		String str4 = "chen";
		System.out.println("判断是否以字符串chen开头：" + str2.startsWith(str4));
		System.out.println("判断是否包含字符串chen：" + str2.contains(str4));
		System.out.println("判断两个字符串是否相等：" + str2.equals(str4));
		System.out.println("第（5）题：");
		String str5 = "chen-zhe";
		System.out.println("名字：" + str5.substring(5));
		System.out.print("分割后的字符串数组中的元素依次为：");
		String[] char3 = str5.split("-");
		for (int i = 0; i < char3.length; i++) {
			if (i != char3.length - 1) {
				System.out.print(char3[i] + ",");
			} else {
				System.out.println(char3[i]);
			}
		}
		System.out.println("第（6）题：");
		String str6 = "chen zhe is learning object-oriented programming";
		String key = "ing";
		int count = getKeyStringCount(str6, key);
		System.out.println("count=" +count);
	}
	//获取字串在整串中出现的次数
	public static int getKeyStringCount(String str, String Key) {
		int count = 0;
		if(!str.contains(Key)) {
			return count;
		}
		int index = 0;
		while((index=str.indexOf(Key))!=-1) {
			str =str.substring(index + Key.length());
			count++;
		}
		return count;
	}
}
