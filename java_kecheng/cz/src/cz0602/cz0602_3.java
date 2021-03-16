package cz0602;

class DieLock extends Thread {
	static Object objA = new Object();
	static Object objB = new Object();
	private boolean flag;

	public DieLock(boolean flag) {
		this.flag = flag;
	}

	public void run() {
		if (flag) {
			while (true) {
				synchronized (objA) {
					System.out.println("true -- objA");
					synchronized (objB) {
						System.out.println("true -- objB");
					}
				}
			}
		} else {
			while (true) {
				synchronized (objB) {
					System.out.println("false -- objB");
					synchronized (objA) {
						System.out.println("false -- objA");
					}
				}
			}
		}
	}
}

public class cz0602_3 {
	public static void main(String[] args) {
		DieLock d1 = new DieLock(true);
		DieLock d2 = new DieLock(false);
		d1.start();
		d2.start();
	}
}
