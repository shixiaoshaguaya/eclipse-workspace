package cz0428;

import java.awt.*;

public class Ex0428 {
	public static void main(String[] args) {
		// FlowLayout布局
		final Frame f1 = new Frame("Flowlayout");
		f1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		f1.setSize(220, 300);
		f1.setLocation(100, 200);
		f1.add(new Button("按钮1"));
		f1.add(new Button("按钮2"));
		f1.add(new Button("按钮3"));
		f1.add(new Button("按钮4"));
		f1.add(new Button("按钮5"));
		f1.add(new Button("按钮6"));
		f1.setVisible(true);
		// 边界布局
		final Frame f2 = new Frame("BorderLayout");
		f2.setLayout(new BorderLayout());
		f2.setSize(300, 300);
		f2.setLocation(300, 200);
		f2.setVisible(true);
		Button but1 = new Button("东部");
		Button but2 = new Button("西部");
		Button but3 = new Button("南部");
		Button but4 = new Button("北部");
		Button but5 = new Button("中部");
		f2.add(but1, BorderLayout.EAST);
		f2.add(but2, BorderLayout.WEST);
		f2.add(but3, BorderLayout.SOUTH);
		f2.add(but4, BorderLayout.NORTH);
		f2.add(but5, BorderLayout.CENTER);
		// 网络布局
		// 1、建立新窗体对象
		Frame f3 = new Frame("网格布局");
		// 2、设置布局管理器为GridLayout
		f3.setLayout(new GridLayout(4, 3));
		// 3、设置窗体的宽和高
		f3.setSize(300, 300);
		// 4、设置窗体显示的位置
		f3.setLocation(400, 400);
		// 5、用窗体的add方法将部件加入到该窗体中
		for (int i = 1; i <= 12; i++) {
			Button btn = new Button("btn" + i);
			f3.add(btn);
		}
		// 6、设置窗体可见
		f3.setVisible(true);
		// GridBagLayout（网格包布局管理器）
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
