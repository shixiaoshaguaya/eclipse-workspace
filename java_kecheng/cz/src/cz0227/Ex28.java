package cz0227;

/*
 * ��ָ���쳣
 */
public class Ex28 {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 5;
		System.out.println("arr[0]=" + arr[0]);
		arr = null;// ������arr��Ϊnull
		System.out.println("arr[0]=" + arr[0]);
	}
}
