package cz0507;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cz0507 {
	public static void main(String[] args) {
		// �½�һ���Լ�����������JFrame���崰��f1��������ʽ���ֹ���FlowLayout���в���
		// 1�������´���
		JFrame f1 = new JFrame("��");
		// 2�����ò��ֹ�����ΪFlowLayout
		f1.setLayout(new FlowLayout());
		// 3�����ô���Ŀ�͸�
		f1.setSize(800, 500);
		// 4�����ô�����ʾ��λ��
		f1.setLocation(300, 200);
		// ����JFrame��setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)���������رմ���
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// дһ����ģʽ�Ի��򡱰�ť�������ť����ģʽ�Ի��򡣶���һ��JDialog�Ի����ڶԻ����ж���һ����ť�������ť�ر�ģʽ�Ի���
		JButton btn1 = new JButton("ģʽ�Ի���");
		// 5���ô����add�������������뵽�ô�����
		f1.add(btn1);
		final JDialog dialog = new JDialog(f1, "JDialog");
		dialog.setSize(220, 150);
		dialog.setLocation(350, 250);
		dialog.setLayout(new FlowLayout());
		final JButton btn2 = new JButton("�ر�");
		dialog.add(btn2);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		// �ڴ���������ı���(JTextField)���ı���(JTextArea)�齨
		JTextField btn3 = new JTextField(20);
		JTextArea btn4 = new JTextArea(12, 34);
		btn4.setEditable(false);
		f1.add(btn4);
		f1.add(btn3);
		// �ڴ�������Ӹ�ѡ��ťJCheckBox����ѡ��ťJRadioButton�����Ա�ѡ���л�Ů��
		JCheckBox btn5 = new JCheckBox("Java����");
		f1.add(btn5);
		JRadioButton btn6 = new JRadioButton("��");
		JRadioButton btn7 = new JRadioButton("Ů");
		ButtonGroup group = new ButtonGroup();
		group.add(btn6);
		group.add(btn7);
		f1.add(btn6);
		f1.add(btn7);
		// ����һ����Ͽ�Ϊ��Ͽ����ѡ��������������������硢������������
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("��ѡ��רҵ");
		comboBox.addItem("�������");
		comboBox.addItem("���缼��");
		comboBox.addItem("������");
		comboBox.addItem("��������");
		comboBox.addItem("Ӧ�õ���");
		f1.add(comboBox);
		// ����һ�����ơ����±����������ļ����������½����򿪡����桢���Ϊ��������ʽ�˵�
		JMenuBar menuBar = new JMenuBar();
		f1.setJMenuBar(menuBar);
		JMenu menu = new JMenu("�ļ�(F)");
		menuBar.add(menu);
		JMenuItem item1 = new JMenuItem("�½�");
		JMenuItem item2 = new JMenuItem("��");
		JMenuItem item3 = new JMenuItem("����");
		JMenuItem item4 = new JMenuItem("���Ϊ");
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		menu.addSeparator();
		menu.add(item3);
		menu.addSeparator();
		menu.add(item4);
		// 6�����ô���ɼ�
		f1.setVisible(true);
	}
}
