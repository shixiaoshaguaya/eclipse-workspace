package cz0227;

/*
 * 冒泡排序
 */
public class Ex31 {
	public static void main(String[] args) {
		int[] arr = { 9, 8, 3, 5, 2 };
		System.out.print("冒泡排序前：");
		printArray(arr);
		bubbleSort(arr);
		System.out.print("冒泡排序后：");
		printArray(arr);
	}

	// 定义打印数组元素的方法
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	// 定义对数组排序的方法
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.print("第" + (i + 1) + "轮排序后：");
			printArray(arr);
		}
	}
}
