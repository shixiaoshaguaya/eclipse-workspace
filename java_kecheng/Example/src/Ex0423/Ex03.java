package Ex0423;

import java.io.File;
import java.io.FilenameFilter;

public class Ex03 {
	public static void main(String[] args) {
		// 创建File对象
		File file = new File("E:\\.eclipse-workspace\\java_kecheng\\Example");
		// 创建过滤器对象
		FilenameFilter filter = new FilenameFilter() {
			// 实现accept（）方法
			public boolean accept(File dir, String name) {
				File currFile = new File(dir, name);
				// 如果文件名以.txt结尾返回true，否则返回false
				if (currFile.isFile() && name.endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		};
		if (file.exists()) {// 判断File对象对应的目录是否存在
			String[] lists = file.list(filter);// 获取过滤后的所以文件名数组
			for (String name : lists) {
				System.out.println(name);
			}
		}
	}
}
