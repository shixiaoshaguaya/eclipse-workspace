package Ex0602;

public class Ex12 {
	public static void main(String[] args) {
		TicketWindow03 task = new TicketWindow03();
		new Thread(task, "����1").start();
		new Thread(task, "����2").start();
		new Thread(task, "����3").start();
		new Thread(task, "����4").start();
	}
}

class TicketWindow03 implements Runnable {
	private int tickets = 10;

	@Override
	public void run() {
		while (true) {
			sendTicket();
		}
	}

	public synchronized void sendTicket() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (tickets > 0) {
			System.out.println(Thread.currentThread().getName() + "---������Ʊ" + tickets--);
		} else {
			System.exit(0);
		}
	}
}