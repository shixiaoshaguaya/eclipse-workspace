package cz0227;

/*
 * 数组的越界异常
 */
public class Ex27 {
	public static void main(String[] args) {
		int[] arr = new int[4];
		System.out.println("arr[0]=" + arr[4]);// 通过索引4访问元素（数组越界）
	}
}
