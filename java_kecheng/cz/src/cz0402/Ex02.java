package cz0402;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();
		// ��ȡ��ǰ������������Ϣ
		System.out.println("�������ĸ�����" + rt.availableProcessors() + "��");
		System.out.println("�����ڴ�������" + rt.freeMemory() / 1024 / 1024 + "M");
		System.out.println("�������ڴ�������" + rt.maxMemory() / 1024 / 1024 + "M");
		// �򿪼��±������ҵȴ�5���Ӻ��Զ��ر�
		Process process = rt.exec("notepad.exe");
		Thread.sleep(5000);
		process.destroy();
	}
}
