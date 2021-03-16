package Ex0331;

/*
 * 记录一个字符串在整串出现的次数
 * 思路：
 * 	1.定义一个整串，定义一个zi串
 * 	2.获取子串在整串中出现的次数
 */
public class StringTest {
	public static void main(String[] args) {
		String str = "nbaernbatnbaynbauinbaopnba";// 整串
		String key = "nba";// 子串
		int count = getKeyStringCount(str, key);
		System.out.println("count=" + count);
	}
	/*
	 * 获取字串在整串中出现的次数
	 */
	public static int getKeyStringCount(String str, String Key) {
		// 定义计数器，记录出现的次数
		int count = 0;
		// 如果整串中不包含子串，则直接返回count
		if (!str.contains(Key)) {
			return count;
		}
		// 定义变量记录key出现的位置
		int index = 0;
		/*
		 * 1.查找子串在整串中出现的位置
		 * 2.将出现的位置记录在index变量中
		 */
		while ((index = str.indexOf(Key)) != -1) {
			//截取整串，从子串出现位置后面开始，到整串末尾
			str = str.substring(index + Key.length());
			count++;
		}
		return count;
	}
}