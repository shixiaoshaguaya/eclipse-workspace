package Ex0423;

import java.io.File;

public class Ex04 {
	public static void main(String[] args) {
		// ����һ����Ŀ¼��File����
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example\\test");
		fileDir(file);// ����FileDir����
	}

	private static void fileDir(File dir) {
		File[] files = dir.listFiles();// ��ȡ��ʾĿ¼�������ļ�������
		for (File file : files) {// �������е���Ŀ¼���ļ�
			if (file.isDirectory()) {
				fileDir(file);// �����Ŀ¼���ݹ����fileDir()
			}
			System.out.println(file.getAbsolutePath());
		}
	}
}
