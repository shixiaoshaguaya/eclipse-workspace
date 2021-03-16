package cz0402;

public class Ex02 {
	public static void main(String[] args) throws Exception {
		Runtime rt = Runtime.getRuntime();
		// 获取当前虚拟机的相关信息
		System.out.println("处理器的个数：" + rt.availableProcessors() + "个");
		System.out.println("闲置内存数量：" + rt.freeMemory() / 1024 / 1024 + "M");
		System.out.println("最大可用内存数量：" + rt.maxMemory() / 1024 / 1024 + "M");
		// 打开记事本程序并且等待5秒钟后自动关闭
		Process process = rt.exec("notepad.exe");
		Thread.sleep(5000);
		process.destroy();
	}
}
