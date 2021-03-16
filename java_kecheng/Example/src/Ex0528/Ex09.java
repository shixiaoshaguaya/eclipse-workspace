package Ex0528;

public class Ex09 {
	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new EmergencyThread(), "�߳�һ");
		t.start();
		for (int i = 0; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + "�����" + i);
			if (i == 2) {
				t.join();
			}
			Thread.sleep(500);
		}
	}
}

class EmergencyThread implements Runnable {
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + "�����" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
