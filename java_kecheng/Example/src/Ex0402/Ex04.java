package Ex0402;

/*
 * Runtime��Ļ���ʹ��
 * 	public int availableProcessors������Java��������ؿ��ô���������Ŀ
 *  public long freeMemory()����Java������еĿ����ڴ���
 *  public long maxMemory()����Java�������ͼʹ�õ�����ڴ���
 * 	public static Runtime getRuntime���������뵱ǰJavaӦ�ó�����ص�����ʱ����
 */
public class Ex04 {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();// ��ȡRuntime�����
		System.out.println("�������ĸ�����" + rt.availableProcessors() + "��");
		System.out.println("�����ڴ�������" + rt.freeMemory() / 1024 / 1024 + "M");
		System.out.println("�������ڴ�������" + rt.maxMemory() / 1024 / 1024 + "M");
	}
}
