package Ex0331;

/*
 * ��¼һ���ַ������������ֵĴ���
 * ˼·��
 * 	1.����һ������������һ��zi��
 * 	2.��ȡ�Ӵ��������г��ֵĴ���
 */
public class StringTest {
	public static void main(String[] args) {
		String str = "nbaernbatnbaynbauinbaopnba";// ����
		String key = "nba";// �Ӵ�
		int count = getKeyStringCount(str, key);
		System.out.println("count=" + count);
	}
	/*
	 * ��ȡ�ִ��������г��ֵĴ���
	 */
	public static int getKeyStringCount(String str, String Key) {
		// �������������¼���ֵĴ���
		int count = 0;
		// ��������в������Ӵ�����ֱ�ӷ���count
		if (!str.contains(Key)) {
			return count;
		}
		// ���������¼key���ֵ�λ��
		int index = 0;
		/*
		 * 1.�����Ӵ��������г��ֵ�λ��
		 * 2.�����ֵ�λ�ü�¼��index������
		 */
		while ((index = str.indexOf(Key)) != -1) {
			//��ȡ���������Ӵ�����λ�ú��濪ʼ��������ĩβ
			str = str.substring(index + Key.length());
			count++;
		}
		return count;
	}
}