package Ex0430;

import java.awt.*;
import java.awt.event.*;

public class Ex01 {
	public static void main(String[] args) {
		// �����´���
		Frame f = new Frame("�ҵĴ��壡");
		// ���ô���Ŀ�͸�
		f.setSize(400, 300);
		// ���ô���ɼ�
		f.setVisible(true);
		// Ϊ�������ע�������
		MyWindowListener mw = new MyWindowListener();
		f.addWindowListener(mw);
	}
}

// ����MyWindowListener��ʵ��WindowListener�ӿ�
class MyWindowListener implements WindowListener {
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

}
