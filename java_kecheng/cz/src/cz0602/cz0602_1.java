package cz0602;

public class cz0602_1 {
	public static void main(String[] args) {
		Demo demo = new Demo();
		new Thread(demo, "��XX").start();
		new Thread(demo, "��X").start();
	}
}

class Demo implements Runnable {
	private Object obj = new Object();

	public void run() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName() + "����ϴ�ּ䣬������");
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "����ʹ��ϴ�ּ�" + i);
				if (i == 3) {
					System.out.println(Thread.currentThread().getName() + "���꣬׼����ȥ������");
					break;
				}
			}
		}
	}
}