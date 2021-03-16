package Ex0402;

/*
 * Runtime类中提供一个exec（）方法，该方法用于z'x一个dos命令，从而实现和命令窗口中输入dos命令同样的效果
 */
import java.io.IOException;

public class Ex05 {
	public static void main(String[] args) throws IOException {
		Runtime rt = Runtime.getRuntime();// 创建Runtime实例对象
		rt.exec("notepad.exe");// 调用exec（）方法
	}
}
