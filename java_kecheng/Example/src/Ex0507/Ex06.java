package Ex0507;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex06 extends JFrame{
	private JCheckBox italic;
	private JCheckBox bold;
	private JLabel label;
	public Ex06() {
		// ����һ��JLabel��ǩ����ǩ�ı����ж���
		label = new JLabel("���ǲ��ͻ�ӭ�㣡", JLabel.CENTER);
		// ���ñ�ǩ�ı�������
		label.setFont(new Font("����", Font.PLAIN, 20));
		this.add(label);// ��CENTER����ӱ�ǩ
		JPanel panel = new JPanel();// ����һ��JPanel���
		// ��������JCheckBox��ѡ��
		italic = new JCheckBox("ITALTC");
		bold = new JCheckBox("BOLD");
		// Ϊ��ѡ����ActionListener������
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int mode = 0;
				if (bold.isSelected()) {
					mode += Font.BOLD;
				}
				if (italic.isSelected()) {
					mode += Font.ITALIC;
				}
				label.setFont(new Font("����", mode, 20));
			}
		};
		// Ϊ������ѡ����Ӽ�����
		italic.addActionListener(listener);
		bold.addActionListener(listener);
		// ��JPanel�����Ӹ�ѡ��
		panel.add(italic);
		panel.add(bold);
		// ��SOUTJH�����JPanel���
		this.add(panel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Ex06();
	}
}
