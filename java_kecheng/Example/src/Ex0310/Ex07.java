package Ex0310;

/*
 * 垃圾回收
 */
class Per07 {
	// 下面定义的finalize方法会在对象垃圾被回收之前调用
	public void finalize() {
		System.out.println("对象作为垃圾回收...");
	}
}

public class Ex07 {
	public static void main(String[] args) throws Exception {
		// 下面是创建了两个Per07对象
		Per07 p1 = new Per07();
		Per07 p2 = new Per07();
		// 下面将变量置为null，让对象成为垃圾
		p1 = null;
		p2 = null;
		// 调用方法进行垃圾回收
		System.gc();
		Thread.sleep(5000);
	}
}
