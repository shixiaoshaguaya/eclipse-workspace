package Ex0507;

import java.awt.*;
import javax.swing.*;

public class Ex04 extends JFrame {
	public Ex04() {
		this.setTitle("PanelDemo");
		// �����������
		JScrollPane scrollPane = new JScrollPane();
		// ����ˮƽ����������--������һֱ��ʾ
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// ���ô�ֱ����������--��������Ҫʱ��ʾ
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// ����һ��JPanel���
		JPanel panel = new JPanel();
		// ��JPnel���������ĸ���ť
		panel.add(new JButton("��ť1"));
		panel.add(new JButton("��ť2"));
		panel.add(new JButton("��ť3"));
		panel.add(new JButton("��ť4"));
		// ����JPanel����ڹ����������ʾ
		scrollPane.setViewportView(panel);
		// �����������ӵ���������SOUTH����
		this.add(scrollPane, BorderLayout.CENTER);
		// ��һ����ť��ӵ���������SIOUTH����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 250);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Ex04();
	}
}
