package Ex0428;

import java.awt.*;

public class Ex02 {
	public static void main(String[] args) {
		final Frame f = new Frame("Flowlayout");// ������ΪFlowlayout�Ĵ���
		// ���ò��ֹ�����ΪFlowLayout�������������룬ˮƽ���Ϊ20����ֱ���Ϊ30
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
		f.setSize(220, 300);// ���ô����С
		f.setLocation(300, 200);// ���ô�����ʾ��λ��
		f.add(new Button("��1����ť"));// �ѡ���1����ť����ӵ�f����
		f.add(new Button("��2����ť"));
		f.add(new Button("��3����ť"));
		f.add(new Button("��4����ť"));
		f.add(new Button("��5����ť"));
		f.add(new Button("��6����ť"));
		f.setVisible(true);// ���ô���ɼ�
	}
}
