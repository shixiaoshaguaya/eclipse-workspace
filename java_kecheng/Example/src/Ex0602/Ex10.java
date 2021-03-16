package Ex0602;

public class Ex10 {
	public static void main(String[] args) {
		TicketWindow01 task = new TicketWindow01();
		new Thread(task, "����1").start();
		new Thread(task, "����2").start();
		new Thread(task, "����3").start();
		new Thread(task, "����4").start();
	}
}

class TicketWindow01 implements Runnable {
	private int tickets = 10;

	@Override
	public void run() {
		while (tickets > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "---������Ʊ" + tickets--);
		}
	}
}