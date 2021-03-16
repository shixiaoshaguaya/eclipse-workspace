package Ex0423;

import java.io.File;

public class Ex02 {
	public static void main(String[] args) {
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example");
		if (file.isDirectory()) {// 判断File对象对应的目录是否存在
			String[] names = file.list();// 获取目录下的所有文件的文件名
			for (String name : names) {
				System.out.println(name);// 输出文件名
			}
		}
	}

}
