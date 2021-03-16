package cz0227;

/*
 * 获取数组中的最大值
 */
public class Ex30 {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 6, 3, 9, 8 };
		int max = getMax(arr);
		System.out.println("max=" + max);
	}

	// 获取最大值的方法
	public static int getMax(int[] arr) {
		int max = arr[0];
		for (int x = 1; x < arr.length; x++) {
			if (arr[x] > max) {
				max = arr[x];
			}
		}
		return max;
	}
}
