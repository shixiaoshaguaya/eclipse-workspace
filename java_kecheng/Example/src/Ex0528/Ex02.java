package Ex0528;

public class Ex02 {
	public static void main(String[] args) {
		MyThread02 myThread = new MyThread02();
		myThread.start();
		while (true) {
			System.out.println("main()����������");
		}
	}
}

class MyThread02 extends Thread {
	public void run() {
		while (true) {
			System.out.println("MyThread���run()����������");
		}
	}
}