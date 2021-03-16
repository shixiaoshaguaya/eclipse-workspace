package cz0423;

import java.io.File;
import java.io.FilenameFilter;

public class Ex0423 {
	public static void main(String[] args) {
		// List方法的使用
		System.out.println("遍历目录下所有的文件：");
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\cz");
		if (file.isDirectory()) {
			String[] names = file.list();
			for (String name : names) {
				System.out.println(name);
			}
		}
		// 遍历目录下所有扩展名称为“*.txt”的文件
		System.out.println("遍历目录下所有扩展名为“*.txt”的文件：");
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
		// 遍历指定目录下的包含子目录下的所有文件
		System.out.println("遍历指定目录下的包含子目录下的所有文件：");
		File f_test = new File("E:\\.eclipse-workspace\\java_kecheng\\cz\\test");
		fileDir(f_test);
		// 删除包含子文件的目录
		System.out.println("删除cz0421文件夹后的结果：");
		File f_del = new File("E:\\.eclipse-workspace\\java_kecheng\\cz\\test\\cz0421");
		deleteDir(f_del);
		fileDir(f_del);
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
