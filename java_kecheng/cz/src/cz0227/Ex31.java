package cz0227;

/*
 * ð������
 */
public class Ex31 {
	public static void main(String[] args) {
		int[] arr = { 9, 8, 3, 5, 2 };
		System.out.print("ð������ǰ��");
		printArray(arr);
		bubbleSort(arr);
		System.out.print("ð�������");
		printArray(arr);
	}

	// �����ӡ����Ԫ�صķ���
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}

	// �������������ķ���
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.print("��" + (i + 1) + "�������");
			printArray(arr);
		}
	}
}
