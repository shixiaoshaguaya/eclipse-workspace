package cz0528;


public class Ex0528_2 {
	public static void main(String[] args) {
		MyThread02 myThread = new MyThread02();
		Thread thread = new Thread(myThread);
		thread.start();
		while (true) {
			System.out.println("mian()方法在运行");
		}
	}
}

class MyThread02 implements Runnable{
	@Override
	public void run() {
		while (true) {
			System.out.println("MyThread类的run()方法在运行");
		}
	}
}