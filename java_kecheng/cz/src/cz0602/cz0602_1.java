package cz0602;

public class cz0602_1 {
	public static void main(String[] args) {
		Demo demo = new Demo();
		new Thread(demo, "李XX").start();
		new Thread(demo, "张X").start();
	}
}

class Demo implements Runnable {
	private Object obj = new Object();

	public void run() {
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName() + "进入洗手间，门锁上");
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "正在使用洗手间" + i);
				if (i == 3) {
					System.out.println(Thread.currentThread().getName() + "用完，准备出去，锁打开");
					break;
				}
			}
		}
	}
}