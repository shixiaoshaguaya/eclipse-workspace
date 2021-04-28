package cn.lmu.utils;

/*
* 工具类
* 获取文件路径
*/
public class StringUtil {
	/*
	 * 获取文件路径名
	 */
	public static String getShortPath(String filePath) {
		if (filePath.length() == 0) {
			return filePath;
		}
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}

	/*
	 * 根据regex分割str，并返回index位置的值
	 */
	public static String getSplitByIndex(String str, String regex, int index) {
		String[] splits = str.split(regex);
		if (splits.length < index) {
			return "";
		}
		return splits[index];
	}
}
