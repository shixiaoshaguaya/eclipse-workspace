package Ex0402;

import java.util.Arrays;

/*
 * 字符串排序程序
 */
public class WrapperTest {
	private static final String SPACE_SEPARATOR = " ";

	public static void main(String[] args) {
		String numStr = "20 78 9 -7 88 36 29";
		System.out.println(numStr);
		// 调用方法，实现得到一个由小到大的字符串
		numStr = sortStringNumber(numStr);
		System.out.println(numStr.toString());
	}

	// 返回一个由小到大的字符串"-7 9 20 29 36 78 88"
	private static String sortStringNumber(String numStr) {
		// 1,将字符串变成字符数组
		String[] str_arr = stringToArray(numStr);
		// 2,将字符串数组变成int数组
		int[] num_arr = toIntArray(str_arr);
		// 3,对int数组排序
		mySorArray(num_arr);
		// 4,将排序后的int数组变成字符串
		String trmp = arrayToString(num_arr);
		return trmp;
	}

	// 将int数组转换成String
	public static String arrayToString(int[] num_arr) {
		StringBuffer sb = new StringBuffer();
		// 通过循环，得到每一个int元素
		for (int x = 0; x < num_arr.length; x++) {
			// 判断当前元素，是否为数组最后一个元素
			if (x != num_arr.length - 1) {
				sb.append(num_arr[x] + SPACE_SEPARATOR);
			} else {
				sb.append(num_arr[x]);
			}
		}
		return sb.toString();
	}

	public static void mySorArray(int[] num_arr) {
		Arrays.sort(num_arr);
	}

	// 将String数组转换成为int数组
	public static int[] toIntArray(String[] str_arr) {
		// 创建int数组
		int[] arr = new int[str_arr.length];
		// 把String数组元素转换成int元素，存储到int数组中
		for (int i = 0; i < arr.length; i++) {
			// 得到每一个字符串str_arr[i]
			// 把字符串数字转换成int类型Integer.parseInt（String str）
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		return arr;
	}

	public static String[] stringToArray(String numStr) {
		String[] str_arr = numStr.split(SPACE_SEPARATOR);
		return str_arr;
	}
}
