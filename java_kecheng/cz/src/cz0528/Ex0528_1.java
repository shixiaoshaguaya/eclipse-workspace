package cz0528;

class Mythread01 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("����Ƶ�MyThread���run()������������");
		}
	}
}

public class Ex0528_1 {
	public static void main(String[] args) {
		Mythread01 myThread = new Mythread01();
		myThread.start();
		while (true) {
			System.out.println("main()����������");
		}
	}
}
