package Ex0430;

import java.awt.*;
import java.awt.event.*;

public class Ex05 {
	public static void main(String[] args) {
		final Frame f = new Frame("WindowEvent");
		// Ϊ�������ò���
		f.setLayout(new FlowLayout());
		f.setSize(300, 200);
		f.setLocation(300, 200);
		f.setVisible(true);
		Button but = new Button("Button");// ������ť����
		f.add(but);// �ڴ�����Ӱ�ť���
		// Ϊ��ť�������¼�������
		but.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased-���ſ��¼�");
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("mouseReleased-��갴���¼�");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("mouseReleased-����Ƴ���ť�����¼�");
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseReleased-�����밴ť�����¼�");
			}

			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseReleased-�����ɵ����¼�");
			}
		});
	}
}
