package cz0428;

import java.awt.*;

public class Ex0428 {
	public static void main(String[] args) {
		// FlowLayout����
		final Frame f1 = new Frame("Flowlayout");
		f1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		f1.setSize(220, 300);
		f1.setLocation(100, 200);
		f1.add(new Button("��ť1"));
		f1.add(new Button("��ť2"));
		f1.add(new Button("��ť3"));
		f1.add(new Button("��ť4"));
		f1.add(new Button("��ť5"));
		f1.add(new Button("��ť6"));
		f1.setVisible(true);
		// �߽粼��
		final Frame f2 = new Frame("BorderLayout");
		f2.setLayout(new BorderLayout());
		f2.setSize(300, 300);
		f2.setLocation(300, 200);
		f2.setVisible(true);
		Button but1 = new Button("����");
		Button but2 = new Button("����");
		Button but3 = new Button("�ϲ�");
		Button but4 = new Button("����");
		Button but5 = new Button("�в�");
		f2.add(but1, BorderLayout.EAST);
		f2.add(but2, BorderLayout.WEST);
		f2.add(but3, BorderLayout.SOUTH);
		f2.add(but4, BorderLayout.NORTH);
		f2.add(but5, BorderLayout.CENTER);
		// ���粼��
		// 1�������´������
		Frame f3 = new Frame("���񲼾�");
		// 2�����ò��ֹ�����ΪGridLayout
		f3.setLayout(new GridLayout(4, 3));
		// 3�����ô���Ŀ�͸�
		f3.setSize(300, 300);
		// 4�����ô�����ʾ��λ��
		f3.setLocation(400, 400);
		// 5���ô����add�������������뵽�ô�����
		for (int i = 1; i <= 12; i++) {
			Button btn = new Button("btn" + i);
			f3.add(btn);
		}
		// 6�����ô���ɼ�
		f3.setVisible(true);
		// GridBagLayout����������ֹ�������
		new Layout("GridBagLayout");
	}
}

class Layout extends Frame {
	public Layout(String title) {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(layout);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		this.addComponent("btn1", layout, c);
		this.addComponent("btn2", layout, c);
		this.addComponent("btn3", layout, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		this.addComponent("btn4", layout, c);
		c.weightx = 0;
		c.weighty = 0;
		this.addComponent("btn5", layout, c);
		c.gridwidth = 1;
		this.addComponent("btn6", layout, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		this.addComponent("btn7", layout, c);
		this.setTitle(title);
		this.pack();
		this.setVisible(true);
	}

	private void addComponent(String name, GridBagLayout layout, GridBagConstraints c) {
		Button bt = new Button(name);
		layout.setConstraints(bt, c);
		this.add(bt);
	}
}
