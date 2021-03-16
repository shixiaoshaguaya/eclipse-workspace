package Ex0507;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex08 extends JFrame {
	private JComboBox comboBox;// ����һ��JComboBox��Ͽ�
	private JTextField field;// ����һ��JTextField�ı���

	public Ex08() {
		JPanel panel = new JPanel();// ����JPanel���
		comboBox = new JComboBox();
		// Ϊ��Ͽ����ѡ��
		comboBox.addItem("��ѡ�����");
		comboBox.addItem("����");
		comboBox.addItem("���");
		comboBox.addItem("�Ͼ�");
		comboBox.addItem("�Ϻ�");
		comboBox.addItem("����");
		// Ϊ��Ͽ�����¼�������
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox.getSelectedItem();
				if ("��ѡ�����".equals(item)) {
					field.setText("");
				} else {
					field.setText("��ѡ��ĳ����ǣ�" + item);
				}
			}
		});
		field = new JTextField(20);
		panel.add(comboBox);// ������������Ͽ�
		panel.add(field);// �����������ı���
		// ��������������JPanel���
		this.add(panel, BorderLayout.NORTH);
		this.setSize(350, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex08();
	}
}
