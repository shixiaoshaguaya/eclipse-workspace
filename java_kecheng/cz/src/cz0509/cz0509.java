package cz0509;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cz0509 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("��");
		jf.setSize(600, 400);
		jf.setLocation(300, 200);
		jf.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jf.add(jp1, BorderLayout.NORTH);
		jf.add(jp2, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);
		JLabel jl1 = new JLabel("����ְҵ��ѧ-��");
		jp1.add(jl1);

		JTextArea chatContent = new JTextArea(12, 34);
		JTextField inputField = new JTextField(20);
		JButton sendBt = new JButton("����");
		sendBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String content = inputField.getText();
				if (content != null && !content.trim().equals("")) {
					chatContent.append("���ˣ�" + content + "\n");
				} else {
					chatContent.append("������Ϣ����Ϊ��" + "\n");
				}
				inputField.setText("");
			}
		});
		jp2.add(chatContent);
		jp2.add(inputField);
		jp2.add(sendBt);

		JCheckBox jcb = new JCheckBox("Java����");
		jp3.add(jcb);
		JRadioButton jrb1 = new JRadioButton("��", true);
		JRadioButton jrb2 = new JRadioButton("Ů", true);
		ButtonGroup group = new ButtonGroup();
		group.add(jrb1);
		group.add(jrb2);
		jp3.add(jrb1);
		jp3.add(jrb2);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("��ѡ��רҵ");
		comboBox.addItem("�������");
		comboBox.addItem("���缼��");
		comboBox.addItem("������");
		comboBox.addItem("��������");
		comboBox.addItem("Ӧ�õ���");
		jp3.add(comboBox);

		JButton exit = new JButton("�ر�");
		jp3.add(exit);
		exit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		JMenuBar menuBar = new JMenuBar();
		jf.setJMenuBar(menuBar);
		JMenu menu = new JMenu("�ļ�(F)");
		menuBar.add(menu);
		JMenuItem item1 = new JMenuItem("�½�");
		JMenuItem item2 = new JMenuItem("��");
		JMenuItem item3 = new JMenuItem("�ر�");
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
		JMenuItem jmi1 = new JMenuItem("ˢ��");
		JMenuItem jmi2 = new JMenuItem("����");
		JMenuItem jmi3 = new JMenuItem("�˳�");
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
