package cz0528;

class Mythread01 extends Thread {
	@Override
	public void run() {
		while (true) {
			System.out.println("陈喆设计的MyThread类的run()方法正在运行");
		}
	}
}

public class Ex0528_1 {
	public static void main(String[] args) {
		Mythread01 myThread = new Mythread01();
		myThread.start();
		while (true) {
			System.out.println("main()方法在运行");
		}
	}
}
