package Ex0402;

/*
 * �򿪼��±�����3����Զ��ر�
 * 	public Process exec��String command���ڵ����Ľ�����ִ��ָ�����ַ�������
 */
public class Ex06 {
	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();// ����һ��Runtimeʵ������
		Process process = rt.exec("notepad.exe");// �õ���ʾ���̵�process����
		Thread.sleep(3000);// ��������3��
		process.destroy();// ɱ������
	}
}
