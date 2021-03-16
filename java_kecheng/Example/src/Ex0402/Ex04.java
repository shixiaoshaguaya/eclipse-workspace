package Ex0402;

/*
 * Runtime类的基本使用
 * 	public int availableProcessors（）向Java虚拟机返回可用处理器的数目
 *  public long freeMemory()返回Java虚拟机中的空闲内存量
 *  public long maxMemory()返回Java虚拟机试图使用的最大内存量
 * 	public static Runtime getRuntime（）返回与当前Java应用程序相关的运行时对象
 */
public class Ex04 {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();// 获取Runtime类对象
		System.out.println("处理器的个数：" + rt.availableProcessors() + "个");
		System.out.println("闲置内存数量：" + rt.freeMemory() / 1024 / 1024 + "M");
		System.out.println("最大可用内存数量：" + rt.maxMemory() / 1024 / 1024 + "M");
	}
}
