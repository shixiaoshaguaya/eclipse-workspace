package Ex0428;

import java.awt.Frame;

public class Ex01 {
	public static void main(String[] args) {
		// 创建新窗体对象
		Frame f = new Frame("我的窗体！");
		// 设置窗体的宽和高
		f.setSize(400, 300);
		// 设置窗体在屏幕中所处的位置（参考是左上角坐标）
		f.setLocation(300, 200);
		// 设置窗体可见
		f.setVisible(true);
	}
}
