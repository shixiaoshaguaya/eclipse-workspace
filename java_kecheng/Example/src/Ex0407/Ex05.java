package Ex0407;

public class Ex05 {
	static String[] strs = { "aaa", "bbb", "ccc" };

	public static void main(String[] args) {
		// foreachѭ����������
		for (String str : strs) {
			str = "ddd";
		}
		System.out.println("foreachѭ���޸ĺ�����飺" + strs[0] + "," + strs[1] + "," + strs[2]);
		// forѭ����������
		for (int i = 0; i < strs.length; i++) {
			strs[i] = "ddd";
		}
		System.out.println("��ͨforѭ���޸ĺ�����飺" + strs[0] + "," + strs[1] + "," + strs[2]);
	}
}