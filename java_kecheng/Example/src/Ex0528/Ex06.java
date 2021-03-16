package Ex0528;

public class Ex06 {
	public static void main(String[] args) {
		Thread minPriority = new Thread(new Task01(), "���ȼ��ϵ͵��߳� ");
		Thread maxPriority = new Thread(new Task01(), "���ȼ��ϸߵ��߳�");
		minPriority.setPriority(Thread.MIN_PRIORITY);
		maxPriority.setPriority(Thread.MAX_PRIORITY);
		minPriority.start();
		maxPriority.start();
	}
}

class Task01 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "�������" + i);
		}
	}
}