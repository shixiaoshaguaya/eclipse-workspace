package Ex0507;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ex07 extends JFrame {
	private ButtonGroup group;// ��ѡ��ť�����
	private JPanel panel;// JPanel������3��JRadioButton��ť
	private JPanel pallet;// JPanel�����Ϊ��ɫ��

	public Ex07() {
		pallet = new JPanel();
		this.add(pallet, BorderLayout.CENTER);// ����ɫ����������CENTER����
		panel = new JPanel();
		group = new ButtonGroup();
		// ����addJRadioButton()����
		addJRadioButton("��");
		addJRadioButton("��");
		addJRadioButton("��");
		this.add(panel, BorderLayout.SOUTH);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * JRadioButtion��ť���ı���Ϣ ���ڴ���һ�������ı���Ϣ��JRadioButton��ť
	 * ����ť��ӵ�panel����ButtonGroup��ť���� ����Ӽ�����
	 */
	private void addJRadioButton(final String text) {
		JRadioButton radioButton = new JRadioButton(text);
		group.add(radioButton);
		panel.add(radioButton);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = null;
				if ("��".equals(text)) {
					color = color.GRAY;
				} else if ("��".equals(text)) {
					color = color.PINK;
				} else if ("��".equals(text)) {
					color = color.YELLOW;
				} else {
					color = color.WHITE;
				}
				pallet.setBackground(color);
			}
		});
	}

	public static void main(String[] args) {
		new Ex07();
	}
}
