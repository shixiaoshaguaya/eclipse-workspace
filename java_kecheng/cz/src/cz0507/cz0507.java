package cz0507;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cz0507 {
	public static void main(String[] args) {
		// 新建一个自己姓名命名的JFrame窗体窗口f1，利用流式布局管理FlowLayout进行布局
		// 1、建立新窗体
		JFrame f1 = new JFrame("陈喆");
		// 2、设置布局管理器为FlowLayout
		f1.setLayout(new FlowLayout());
		// 3、设置窗体的宽和高
		f1.setSize(800, 500);
		// 4、设置窗体显示的位置
		f1.setLocation(300, 200);
		// 利用JFrame的setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)方法，来关闭窗体
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 写一个“模式对话框”按钮，点击按钮弹出模式对话框。定义一个JDialog对话框，在对话框中定义一个按钮，点击按钮关闭模式对话框
		JButton btn1 = new JButton("模式对话框");
		// 5、用窗体的add方法将部件加入到该窗体中
		f1.add(btn1);
		final JDialog dialog = new JDialog(f1, "JDialog");
		dialog.setSize(220, 150);
		dialog.setLocation(350, 250);
		dialog.setLayout(new FlowLayout());
		final JButton btn2 = new JButton("关闭");
		dialog.add(btn2);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		// 在窗体中添加文本框(JTextField)、文本域(JTextArea)组建
		JTextField btn3 = new JTextField(20);
		JTextArea btn4 = new JTextArea(12, 34);
		btn4.setEditable(false);
		f1.add(btn4);
		f1.add(btn3);
		// 在窗体中添加复选按钮JCheckBox、单选按钮JRadioButton（如性别选择男或女）
		JCheckBox btn5 = new JCheckBox("Java语言");
		f1.add(btn5);
		JRadioButton btn6 = new JRadioButton("男");
		JRadioButton btn7 = new JRadioButton("女");
		ButtonGroup group = new ButtonGroup();
		group.add(btn6);
		group.add(btn7);
		f1.add(btn6);
		f1.add(btn7);
		// 创建一个组合框并为组合框添加选项（如软件技术、计算机网络、物联网……）
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("请选择专业");
		comboBox.addItem("软件技术");
		comboBox.addItem("网络技术");
		comboBox.addItem("物联网");
		comboBox.addItem("汽车电子");
		comboBox.addItem("应用电子");
		f1.add(comboBox);
		// 创建一个类似“记事本”——“文件”——“新建、打开、保存、另存为”的下拉式菜单
		JMenuBar menuBar = new JMenuBar();
		f1.setJMenuBar(menuBar);
		JMenu menu = new JMenu("文件(F)");
		menuBar.add(menu);
		JMenuItem item1 = new JMenuItem("新建");
		JMenuItem item2 = new JMenuItem("打开");
		JMenuItem item3 = new JMenuItem("保存");
		JMenuItem item4 = new JMenuItem("另存为");
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		menu.addSeparator();
		menu.add(item3);
		menu.addSeparator();
		menu.add(item4);
		// 6、设置窗体可见
		f1.setVisible(true);
	}
}
