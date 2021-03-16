package cz0528;

public class Ex0528_3 {
	public static void main(String[] args) {
		Ticket task = new Ticket();
		new Thread(task, "窗口1").start();
		new Thread(task, "窗口2").start();
		new Thread(task, "窗口3").start();
		new Thread(task, "窗口4").start();
	}
}

class Ticket implements Runnable {
	private int tickets = 10;
	Object lock = new Object();

	public void run() {
		while (true) {
			synchronized (lock) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tickets > 0) {
					System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets-- + "张票");
				} else {
					break;
				}
			}
		}
	}
}