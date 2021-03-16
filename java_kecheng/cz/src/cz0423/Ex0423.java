package cz0423;

import java.io.File;
import java.io.FilenameFilter;

public class Ex0423 {
	public static void main(String[] args) {
		// List������ʹ��
		System.out.println("����Ŀ¼�����е��ļ���");
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\cz");
		if (file.isDirectory()) {
			String[] names = file.list();
			for (String name : names) {
				System.out.println(name);
			}
		}
		// ����Ŀ¼��������չ����Ϊ��*.txt�����ļ�
		System.out.println("����Ŀ¼��������չ��Ϊ��*.txt�����ļ���");
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				File currFile = new File(dir, name);
				if (currFile.isFile() && name.endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		};
		if (file.exists()) {
			String[] lists = file.list(filter);
			for (String name : lists) {
				System.out.println(name);
			}
		}
		// ����ָ��Ŀ¼�µİ�����Ŀ¼�µ������ļ�
		System.out.println("����ָ��Ŀ¼�µİ�����Ŀ¼�µ������ļ���");
		File f_test = new File("E:\\.eclipse-workspace\\java_kecheng\\cz\\test");
		fileDir(f_test);
		// ɾ���������ļ���Ŀ¼
		System.out.println("ɾ��cz0421�ļ��к�Ľ����");
		File f_del = new File("E:\\.eclipse-workspace\\java_kecheng\\cz\\test\\cz0421");
		deleteDir(f_del);
		fileDir(f_test);
	}

	private static void fileDir(File dir) {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				fileDir(file);
			}
			System.out.println(file.getAbsolutePath());
		}
	}

	private static void deleteDir(File dir) {
		if (dir.exists()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					deleteDir(file);
				} else {
					file.delete();
				}
			}
			dir.delete();
		}
	}
}
