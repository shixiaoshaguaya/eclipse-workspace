package Ex0507;

import java.awt.FlowLayout;
import javax.swing.*;

public class Ex02 extends JFrame {
	public Ex02() {
		this.setTitle("JFrameTest");
		this.setSize(250, 300);
		// 定义一个按钮组件
		JButton bt = new JButton("按钮");
		// 设置流式布局管理器
		this.setLayout(new FlowLayout());
		// 添加按钮组件
		this.add(bt);
		// 设置单击关闭按钮时的默认操作
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex02();
	}
}
