package Ex0423;

import java.io.File;

public class Ex06 {
	public static void main(String[] args) {
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example\\test\\cz0421");// ����һ������Ŀ¼��File����
		deleteDir(file);// ����deleteDirɾ������
	}

	private static void deleteDir(File dir) {
		if (dir.exists()) {// �жϴ����File�����Ƿ����
			File[] files = dir.listFiles();// �õ�File����
			for (File file : files) {// �������е���Ŀ¼���ļ�
				if (file.isDirectory()) {
					deleteDir(file);// �����Ŀ¼���ݹ����deleteDir()
				} else {
					// ������ļ���ֱ��ɾ��
					file.delete();
				}
			}
			// ɾ����һ��Ŀ¼��������ļ���ɾ�����Ŀ¼
			dir.delete();
		}
	}
}
