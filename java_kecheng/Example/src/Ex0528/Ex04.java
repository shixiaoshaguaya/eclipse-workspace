package Ex0528;

public class Ex04 {
	public static void main(String[] args) {
		new TicketWindow01().start();
		new TicketWindow01().start();
		new TicketWindow01().start();
		new TicketWindow01().start();
	}
}

class TicketWindow01 extends Thread {
	private int tickets = 100;

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