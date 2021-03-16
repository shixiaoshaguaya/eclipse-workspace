package Ex0602;

public class Ex11 {
	public static void main(String[] args) {
		TicketWindow02 task = new TicketWindow02();
		new Thread(task, "窗口1").start();
		new Thread(task, "窗口2").start();
		new Thread(task, "窗口3").start();
		new Thread(task, "窗口4").start();
	}
}

class TicketWindow02 implements Runnable {
	private int tickets = 10;
	Object lock = new Object();

	@Override
	public void run() {
		while (true) {
			synchronized (lock) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tickets > 0) {
					System.out.println(Thread.currentThread().getName() + "---卖出的票" + tickets--);
				} else {
					break;
				}
			}
		}
	}
}