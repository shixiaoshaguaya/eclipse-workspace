package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wmsapp.model.Goods;
import com.wmsapp.service.GoodsService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGoodsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtNumber;
	private JTextField txtFactory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddGoodsFrame frame = new AddGoodsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddGoodsFrame() {
		setTitle("\u8D27\u7269\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D27\u7269\u4FE1\u606F\u767B\u8BB0");
		lblNewLabel.setBounds(106, 10, 72, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u8D27  \u53F7");
		lblNewLabel_1.setBounds(50, 40, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u540D  \u79F0");
		lblNewLabel_2.setBounds(50, 80, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5355  \u4EF7");
		lblNewLabel_3.setBounds(50, 120, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u6570  \u91CF");
		lblNewLabel_4.setBounds(50, 160, 54, 15);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("\u751F\u4EA7\u5546");
		lblNewLabel_5.setBounds(50, 200, 54, 15);
		contentPane.add(lblNewLabel_5);

		txtID = new JTextField();
		txtID.setBounds(106, 35, 90, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(106, 77, 90, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setBounds(106, 117, 90, 21);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setText("0");
		txtNumber.setBounds(106, 157, 90, 21);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);

		txtFactory = new JTextField();
		txtFactory.setBounds(106, 197, 90, 21);
		contentPane.add(txtFactory);
		txtFactory.setColumns(10);

		JButton btnOK = new JButton("\u767B\u8BB0");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtID.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddGoodsFrame.this, "登记失败，货号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				}
				if (txtName.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddGoodsFrame.this, "登记失败，名称信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				}
				String id, name, factory;
				int number;
				float price;
				id = txtID.getText();
				name = txtName.getText();
				price = Float.parseFloat(txtPrice.getText());
				number = Integer.parseInt(txtNumber.getText());
				factory = txtFactory.getText();
				GoodsService goodsService = new GoodsService();
				Goods goods = new Goods(id, name, price, number, factory);
				boolean add = false;
				try {
					add = goodsService.add(goods);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (add != false) {
					JOptionPane.showMessageDialog(AddGoodsFrame.this, "登记成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(AddGoodsFrame.this, "登记失败！", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnOK.setBounds(134, 233, 62, 23);
		contentPane.add(btnOK);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setBounds(212, 233, 62, 23);
		contentPane.add(btnCancel);
	}
}
