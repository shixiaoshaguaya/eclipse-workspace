package cz0509;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cz0509 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("陈喆");
		jf.setSize(600, 400);
		jf.setLocation(300, 200);
		jf.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jf.add(jp1, BorderLayout.NORTH);
		jf.add(jp2, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);
		JLabel jl1 = new JLabel("黎明职业大学-陈喆");
		jp1.add(jl1);

		JTextArea chatContent = new JTextArea(12, 34);
		JTextField inputField = new JTextField(20);
		JButton sendBt = new JButton("发送");
		sendBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = inputField.getText();
				if (content != null && !content.trim().equals("")) {
					chatContent.append("本人：" + content + "\n");
				} else {
					chatContent.append("聊天信息不能为空" + "\n");
				}
				inputField.setText("");
			}
		});
		jp2.add(chatContent);
		jp2.add(inputField);
		jp2.add(sendBt);

		JCheckBox jcb = new JCheckBox("Java语言");
		jp3.add(jcb);
		JRadioButton jrb1 = new JRadioButton("男", true);
		JRadioButton jrb2 = new JRadioButton("女", true);
		ButtonGroup group = new ButtonGroup();
		group.add(jrb1);
		group.add(jrb2);
		jp3.add(jrb1);
		jp3.add(jrb2);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("请选择专业");
		comboBox.addItem("软件技术");
		comboBox.addItem("网络技术");
		comboBox.addItem("物联网");
		comboBox.addItem("汽车电子");
		comboBox.addItem("应用电子");
		jp3.add(comboBox);

		JButton exit = new JButton("关闭");
		jp3.add(exit);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);
		JMenu menu = new JMenu("文件(F)");
		menuBar.add(menu);
		JMenuItem item1 = new JMenuItem("新建");
		JMenuItem item2 = new JMenuItem("打开");
		JMenuItem item3 = new JMenuItem("关闭");
		menu.add(item1);
		menu.add(item2);
		menu.addSeparator();
		menu.add(item3);
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem jmi1 = new JMenuItem("刷新");
		JMenuItem jmi2 = new JMenuItem("创建");
		JMenuItem jmi3 = new JMenuItem("退出");
		jmi3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		popupMenu.add(jmi1);
		popupMenu.add(jmi2);
		popupMenu.addSeparator();
		popupMenu.add(jmi3);
		jf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == e.BUTTON3) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
