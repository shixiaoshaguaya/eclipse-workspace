package cz0430;

import java.awt.*;
import java.awt.event.*;

public class cz0430 {
	public static void main(String[] args) {
		// 1、建立新窗体
		Frame f1 = new Frame("陈喆");
		// 2、设置布局管理器为FlowLayout
		f1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		// 3、设置窗体的宽和高
		f1.setSize(400, 300);
		// 4、设置窗体显示的位置
		f1.setLocation(300, 200);
		// 5、设置窗体可见
		f1.setVisible(true);
		// 6、用窗体的add方法将部件加入到该窗体中
		Button btn = new Button("退出");
		f1.add(btn);
		// 用内部类的方法为按钮组件注册监听器
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		TextField tf = new TextField(30);// 创建文件框对象
		f1.add(tf);// 在窗口中添加文本框组件
		// 为文本框添加键盘事件监听器
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				System.exit(0);
			}
		});
		// 实现窗口打×关闭
//		MyWindowListener mw = new MyWindowListener();
//		f1.addWindowListener(mw);
		// 利用窗口适配器类实现关闭窗体
		f1.addWindowListener(new MyWindowListener());
	}
}

//继承WindowAdapter类，重写windowClosing（）方法
class MyWindowListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Window window = (Window) e.getComponent();
		window.dispose();
	}
}

// 创建MyWindowListener类实现WindowListener接口
/*class MyWindowListener implements WindowListener {
	// 监听器监听事件对象作出处理
	public void windowClosing(WindowEvent e) {
		Window window = e.getWindow();
		window.setVisible(false);
		// 释放窗口
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