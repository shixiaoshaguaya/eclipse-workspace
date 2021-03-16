package Ex0430;

import java.awt.*;
import java.awt.event.*;

public class Ex05 {
	public static void main(String[] args) {
		final Frame f = new Frame("WindowEvent");
		// 为窗口设置布局
		f.setLayout(new FlowLayout());
		f.setSize(300, 200);
		f.setLocation(300, 200);
		f.setVisible(true);
		Button but = new Button("Button");// 创建按钮对象
		f.add(but);// 在窗口添加按钮组件
		// 为按钮添加鼠标事件监听器
		but.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {
				System.out.println("mouseReleased-鼠标放开事件");
			}

			public void mousePressed(MouseEvent e) {
				System.out.println("mouseReleased-鼠标按下事件");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("mouseReleased-鼠标移出按钮区域事件");
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("mouseReleased-鼠标加入按钮区域事件");
			}

			public void mouseClicked(MouseEvent e) {
				System.out.println("mouseReleased-鼠标完成单击事件");
			}
		});
	}
}
