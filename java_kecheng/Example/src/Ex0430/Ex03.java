package Ex0430;

import java.awt.*;
import java.awt.event.*;

public class Ex03 {
	public static void main(String[] args) {
		Frame f = new Frame("�ҵĴ��壡");
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setVisible(true);
		Button btn = new Button("EXIT");// ������ť�������
		f.add(btn);// �Ѱ�ť������ص�������
		// ���ڲ���ķ���Ϊ��ť���ע�������
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
