package Ex0528;

public class Ex03 {
	public static void main(String[] args) {
		MyThread03 myThread = new MyThread03();
		Thread thread = new Thread(myThread);
		thread.start();
		while (true) {
			System.out.println("mian()方法在运行");
		}
	}
}

class MyThread03 implements Runnable {
	public void run() {
		while (true) {
			System.out.println("MyThread类的run()方法在运行");
		}
	}
}