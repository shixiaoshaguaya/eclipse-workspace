package Ex0402;

/*
 * 打开记事本并在3秒后自动关闭
 * 	public Process exec（String command）在单独的进程中执行指定的字符串命令
 */
public class Ex06 {
	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();// 创建一个Runtime实例对象
		Process process = rt.exec("notepad.exe");// 得到表示进程的process对象
		Thread.sleep(3000);// 程序休眠3秒
		process.destroy();// 杀掉进程
	}
}
