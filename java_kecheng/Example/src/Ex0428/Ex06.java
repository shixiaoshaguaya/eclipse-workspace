package Ex0428;

import java.awt.*;
import java.awt.event.*;

//����Cardlayout�̳�Frame�࣬ʵ��ActionListener�ӿ�
class Cardlayout extends Frame implements ActionListener{
	Panel cardPanel = new Panel();//����Panel�����ÿ�Ƭ
	Panel controlPanel = new Panel();//����Panel�����ð�ť
	Button nextbutton, preButton;
	CardLayout cardLayout = new CardLayout();//���忨Ƭ���ֶ���
	//���幹�췽�������ÿ�Ƭ���ֹ�����������
	public Cardlayout() {
		setSize(300, 200);
		setVisible(true);
		// Ϊ������ӹر��¼�������
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Cardlayout.this.dispose();
			}
		});
		cardPanel.setLayout(cardLayout);
		//��cardPanel�����������3���ı���ǩ
		cardPanel.add(new Label("��1������",Label.CENTER));
		cardPanel.add(new Label("��2������",Label.CENTER));
		cardPanel.add(new Label("��3������",Label.CENTER));
		//����������ť����
		nextbutton = new Button("��һ�ſ�Ƭ");
		preButton = new Button("��һ�ſ�Ƭ");
		//Ϊ��ť����ע�������
		nextbutton.addActionListener(this);
		preButton.addActionListener(this);
		//����ť��ӵ�controlpaPanl��
		controlPanel.add(preButton);
		controlPanel.add(nextbutton);
		// ��cardPanel�������ڴ��ڱ߽粼�ֵ��м䣬����Ĭ��Ϊ�߽粼��
		this.add(cardPanel, BorderLayout.CENTER);
		//��controlpaPanel�������ڴ��ڱ߽粼�ֵ�����
		this.add(controlPanel, BorderLayout.SOUTH);
	}
	// ����Ĵ���ʵ���˰�ť�ļ������������Դ����¼�������Ӧ�Ĵ���
	public void actionPerformed(ActionEvent e) {
		//����û�����nextbutton��ִ�е����
		if (e.getSource()==nextbutton) {
			//�л�����е����������ǰ���Ϊ���һ�����������ʾ��һ�����
			cardLayout.next(cardPanel);
		}
		if (e.getSource()==preButton) {
			//�л�����е����������ǰ���Ϊ��һ�����������ʾ���һ�����
			cardLayout.previous(cardPanel);
		}
	}
}
public class Ex06 {
	public static void main(String[] args) {
		Cardlayout cardlayout = new Cardlayout();
	}
}
