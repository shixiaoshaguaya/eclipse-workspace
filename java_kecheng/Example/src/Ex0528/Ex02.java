package Ex0528;

public class Ex02 {
	public static void main(String[] args) {
		MyThread02 myThread = new MyThread02();
		myThread.start();
		while (true) {
			System.out.println("main()方法在运行");
		}
	}
}

class MyThread02 extends Thread {
	public void run() {
		while (true) {
			System.out.println("MyThread类的run()方法在运行");
		}
	}
}