package Ex0602;

public class Ex11 {
	public static void main(String[] args) {
		TicketWindow02 task = new TicketWindow02();
		new Thread(task, "����1").start();
		new Thread(task, "����2").start();
		new Thread(task, "����3").start();
		new Thread(task, "����4").start();
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
					System.out.println(Thread.currentThread().getName() + "---������Ʊ" + tickets--);
				} else {
					break;
				}
			}
		}
	}
}