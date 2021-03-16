package Ex0423;

import java.io.File;

public class Ex04 {
	public static void main(String[] args) {
		// 创建一个代目录的File对象
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example\\test");
		fileDir(file);// 调用FileDir方法
	}

	private static void fileDir(File dir) {
		File[] files = dir.listFiles();// 获取表示目录下所有文件的数组
		for (File file : files) {// 遍历所有的子目录和文件
			if (file.isDirectory()) {
				fileDir(file);// 如果是目录，递归调用fileDir()
			}
			System.out.println(file.getAbsolutePath());
		}
	}
}
