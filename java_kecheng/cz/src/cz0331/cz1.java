package cz0331;

public class cz1 {
	public static void main(String[] args) {
		String str1 = new String();// �������ַ���
		String str2 = "chenzhe";// �����Լ�����ƴ����ĸ���ַ���
		// ����������ĸΪ�ַ�������ַ���
		char[] char1 = new char[] {'C','Z'};
		String str3 = new String(char1);
		//���
		System.out.println("�ڣ�1���⣺");
		System.out.println("a"+str1+"b");
		System.out.println(str2);
		System.out.println(str3);
		System.out.println("�ڣ�2���⣺");
		System.out.println("�ַ����ĳ���Ϊ��" + str2.length());
		System.out.println("�ַ����е�һ���ַ���" + str2.charAt(0));
		System.out.println("�ַ�c��һ�γ��ֵ�λ�ã�" + str2.indexOf('e'));
		System.out.println("�ַ�c���һ�γ��ֵ�λ�ã�" + str2.lastIndexOf('e'));
		System.out.println("���ַ�����һ�γ��ֵ�λ�ã�" + str2.indexOf("he"));
		System.out.println("���ַ������һ�γ��ֵ�λ�ã�" + str2.lastIndexOf("he"));
		System.out.println("�ڣ�3���⣺");
		System.out.print("���ַ���ת��Ϊ�ַ������Ľ����");
		char[] char2 = str2.toCharArray();// �ַ���ת��Ϊ�ַ�����
		for (int i = 0; i < char2.length; i++) {
			if (i != char2.length - 1) {
				System.out.print(char2[i] + ",");
			} else {
				System.out.println(char2[i]);
			}
		}
		System.out.println("��intֵת��ΪString����֮��Ľ����" + String.valueOf(12));
		System.out.println("���ַ���ת���ɴ�д֮��Ľ����" + str2.toUpperCase());
		System.out.println("�ڣ�4���⣺");
		String str4 = "chen";
		System.out.println("�ж��Ƿ����ַ���chen��ͷ��" + str2.startsWith(str4));
		System.out.println("�ж��Ƿ�����ַ���chen��" + str2.contains(str4));
		System.out.println("�ж������ַ����Ƿ���ȣ�" + str2.equals(str4));
		System.out.println("�ڣ�5���⣺");
		String str5 = "chen-zhe";
		System.out.println("���֣�" + str5.substring(5));
		System.out.print("�ָ����ַ��������е�Ԫ������Ϊ��");
		String[] char3 = str5.split("-");
		for (int i = 0; i < char3.length; i++) {
			if (i != char3.length - 1) {
				System.out.print(char3[i] + ",");
			} else {
				System.out.println(char3[i]);
			}
		}
		System.out.println("�ڣ�6���⣺");
		String str6 = "chen zhe is learning object-oriented programming";
		String key = "ing";
		int count = getKeyStringCount(str6, key);
		System.out.println("count=" +count);
	}
	//��ȡ�ִ��������г��ֵĴ���
	public static int getKeyStringCount(String str, String Key) {
		int count = 0;
		if(!str.contains(Key)) {
			return count;
		}
		int index = 0;
		while((index=str.indexOf(Key))!=-1) {
			str =str.substring(index + Key.length());
			count++;
		}
		return count;
	}
}
