package Ex0528;

public class Ex01 {
	public static void main(String[] args) {
		MyThread01 myThread = new MyThread01();
		myThread.run();
		while (true) {
			System.out.println("Main����������");
		}
	}
}

class MyThread01 {
	public void run() {
		while (true) {
			System.out.println("MyThread���run��������������");
		}
	}
}
