package cz0602;

public class cz0602_2 {
	public static void main(String[] args) {
		Customer c = new Customer();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}

class Customer implements Runnable {
	private Bank b = new Bank();

	public void run() {
		for (int i = 0; i < 3; i++) {
			b.add(100);
		}
	}
}

class Bank {
	private int sum;

	public void add(int num) {
		synchronized (this) {
			sum = sum + num;
			System.out.println("ÕË»§µÄÓà¶îÎª£º" + sum);
		}
	}
}