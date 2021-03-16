package cz0227;

/*
 * 空指针异常
 */
public class Ex28 {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 5;
		System.out.println("arr[0]=" + arr[0]);
		arr = null;// 将变量arr置为null
		System.out.println("arr[0]=" + arr[0]);
	}
}
