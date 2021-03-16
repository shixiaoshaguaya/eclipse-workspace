package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.wmsapp.dao.StaffDao;
import com.wmsapp.model.Goods;
import com.wmsapp.model.Staff;
import com.wmsapp.service.GoodsService;
import com.wmsapp.service.StaffService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdataGoodsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtNumber;
	private JTextField txtFactory;

	private Goods goods = null;

	/**
	 * 初始化要编辑的货物资料至窗体编辑控件
	 */
	public void initData(Goods goods) {
		if (goods != null) {
			txtID.setText(goods.getG_ID());
			txtName.setText(goods.getG_Name());
			txtPrice.setText(goods.getG_Price());
			txtNumber.setText(goods.getG_Number());
			txtFactory.setText(goods.getG_Factory());
			this.goods = goods;
		}
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdataStaffFrame frame = new UpdataStaffFrame(staff);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UpdataGoodsFrame() {

		setTitle("\u8D27\u7269\u8D44\u6599");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D27    \u53F7");
		lblNewLabel.setBounds(32, 14, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u540D    \u79F0");
		lblNewLabel_1.setBounds(32, 50, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5355    \u4EF7");
		lblNewLabel_2.setBounds(32, 85, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u6570    \u91CF");
		lblNewLabel_3.setBounds(32, 123, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u751F \u4EA7 \u5546");
		lblNewLabel_4.setBounds(32, 161, 54, 15);
		contentPane.add(lblNewLabel_4);

		txtID = new JTextField();
		txtID.setBounds(96, 11, 83, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(96, 47, 118, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setBounds(96, 82, 118, 21);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setBounds(96, 120, 118, 21);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);

		txtFactory = new JTextField();
		txtFactory.setBounds(96, 158, 118, 21);
		contentPane.add(txtFactory);
		txtFactory.setColumns(10);

		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, price, number, name, factory;
				id = txtID.getText();
				name = txtName.getText();
				price = txtPrice.getText();
				number = txtNumber.getText();
				factory = txtFactory.getText();
				goods.setG_ID(id);
				goods.setG_Name(name);
				goods.setG_Price(price);
				goods.setG_Number(number);
				goods.setG_Factory(factory);
				GoodsService goodsService = new GoodsService();
				try {
					if (goodsService.update(goods)) {
						JOptionPane.showMessageDialog(null, "恭喜，修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "遗憾，修改失败！", "提示", JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(130, 206, 64, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				id = txtID.getText();
				if (!id.equals("")) {
					if (JOptionPane.showConfirmDialog(null, "您确定要删除货号为" + id + "的货物信息？(是/否)", "提示",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						GoodsService goodsService = new GoodsService();
						try {
							goodsService.delete(id);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton_1.setBounds(210, 206, 64, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u67E5\u8BE2");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				id = txtID.getText();
				GoodsService goodsService = new GoodsService();
				Goods goods = null;
				try {
					goods = goodsService.getById(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtName.setText(goods.getG_Name());
				txtPrice.setText(goods.getG_Price());
				txtNumber.setText(goods.getG_Number());
				txtFactory.setText(goods.getG_Factory());
			}
		});
		btnNewButton_2.setBounds(189, 10, 64, 23);
		contentPane.add(btnNewButton_2);
//		initData(goods);
	}
}
