package Ex0402;

/*
 * ͨ��һ����������ʾparseInt����������ʹ�ã��ð���ʵ��������Ļ�ϴ�ӡ��*�����Σ����п�͸߷ֱ���Ϊ20��10
 * 
 * Integer��ķ���
 * 	public static int parseInt��String a�����ַ���������������int����
 * StringBuffer��ķ���
 *  public String toSrting������ȡ�ַ����������е����ݣ����ַ�����ʽ����
 */
public class Ex13 {
	public static void main(String[] args) {
		int w = Integer.parseInt("20");
		int h = Integer.parseInt("10");
		for (int i = 0; i < h; i++) {// ����
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < w; j++) {
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
	}
}
