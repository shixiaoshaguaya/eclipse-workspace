package cz0430;

import java.awt.*;
import java.awt.event.*;

public class cz0430 {
	public static void main(String[] args) {
		// 1�������´���
		Frame f1 = new Frame("��");
		// 2�����ò��ֹ�����ΪFlowLayout
		f1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		// 3�����ô���Ŀ�͸�
		f1.setSize(400, 300);
		// 4�����ô�����ʾ��λ��
		f1.setLocation(300, 200);
		// 5�����ô���ɼ�
		f1.setVisible(true);
		// 6���ô����add�������������뵽�ô�����
		Button btn = new Button("�˳�");
		f1.add(btn);
		// ���ڲ���ķ���Ϊ��ť���ע�������
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		TextField tf = new TextField(30);// �����ļ������
		f1.add(tf);// �ڴ���������ı������
		// Ϊ�ı�����Ӽ����¼�������
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
		// ʵ�ִ��ڴ���ر�
//		MyWindowListener mw = new MyWindowListener();
//		f1.addWindowListener(mw);
		// ���ô�����������ʵ�ֹرմ���
		f1.addWindowListener(new MyWindowListener());
	}
}

//�̳�WindowAdapter�࣬��дwindowClosing��������
class MyWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}

// ����MyWindowListener��ʵ��WindowListener�ӿ�
/*class MyWindowListener implements WindowListener {
	// �����������¼�������������
	public void windowClosing(WindowEvent e) {
		Window window = e.getWindow();
		window.setVisible(false);
		// �ͷŴ���
		window.dispose();
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

}*/