package Ex0528;

public class Ex05 {
	public static void main(String[] args) {
		TicketWindow02 task = new TicketWindow02();
		new Thread(task, "����1").start();
		new Thread(task, "����2").start();
		new Thread(task, "����3").start();
		new Thread(task, "����4").start();
	}
}

class TicketWindow02 implements Runnable {
	private int tickets = 100;

	@Override
	public void run() {
		while (true) {
			if (tickets > 0) {
				Thread th = Thread.currentThread();
				String th_name = th.getName();
				System.out.println(th_name + " ���ڷ��۵�" + tickets-- + "��Ʊ");
			}
		}
	}
}