package Ex0528;

public class Ex07 {
	public static void main(String[] args) throws Exception {
		new Thread(new Task02()).start();
		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				Thread.sleep(2000);
			} else {
				Thread.sleep(500);
			}
			System.out.println("main主线程正在输出：" + i);
		}
	}
}

class Task02 implements Runnable {
	@Override
	public void run() {
		try {
			for (int i = 0; i <= 10; i++) {
				if (i == 3) {
					Thread.sleep(2000);
				} else {
					Thread.sleep(500);
				}
				System.out.println("线程一正在输出：" + i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}