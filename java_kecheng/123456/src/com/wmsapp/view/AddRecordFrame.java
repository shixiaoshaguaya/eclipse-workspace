package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mkk.swing.JCalendarChooser;
import com.wmsapp.dao.GoodsDao;
import com.wmsapp.model.Goods;
import com.wmsapp.model.Record;
import com.wmsapp.service.RecordService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddRecordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDate;
	private JTextField txtG_ID;
	private JTextField txtNumber;
	private JTextField txtS_ID;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRecordFrame frame = new AddRecordFrame();
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
	public AddRecordFrame() {
		setTitle("\u51FA\u5165\u5E93");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u65E5    \u671F");
		lblNewLabel.setBounds(32, 14, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u8D27    \u53F7");
		lblNewLabel_1.setBounds(32, 50, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u6570    \u91CF");
		lblNewLabel_2.setBounds(32, 85, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u5458 \u5DE5 \u53F7");
		lblNewLabel_3.setBounds(32, 123, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u7C7B\u522B\uFF08\u51FA\u5E93/\u5165\u5E93\uFF09");
		lblNewLabel_4.setBounds(32, 161, 102, 15);
		contentPane.add(lblNewLabel_4);

		txtDate = new JTextField();
		txtDate.setBounds(96, 11, 98, 21);
		contentPane.add(txtDate);
		txtDate.setColumns(10);

		txtG_ID = new JTextField();
		txtG_ID.setBounds(96, 47, 118, 21);
		contentPane.add(txtG_ID);
		txtG_ID.setColumns(10);

		txtNumber = new JTextField();
		txtNumber.setBounds(96, 82, 118, 21);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);

		txtS_ID = new JTextField();
		txtS_ID.setBounds(96, 120, 118, 21);
		contentPane.add(txtS_ID);
		txtS_ID.setColumns(10);

		JButton btnNewButton = new JButton("\u5165\u5E93");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDate.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "入库失败，日期信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtG_ID.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "入库失败，货号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtNumber.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "入库失败，数量信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtS_ID.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "入库失败，员工号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String g_id, s_id, type = null;
				int r_number, g_number;
				SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
				Date date = null;
				try {
					date = sdf.parse(txtDate.getText());
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				g_id = txtG_ID.getText();
				r_number = Integer.parseInt(txtNumber.getText());
				s_id = txtS_ID.getText();
				if (comboBox.getSelectedIndex() > 0) {
					type = comboBox.getSelectedItem().toString();
				}
				if (type != "入库" ) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "入库失败，类别信息不是入库！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				RecordService recordService = new RecordService();
				Record record = new Record(date, g_id, r_number, s_id, type);
				boolean add = false;
				try {
					add = recordService.add(record);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				GoodsDao goodsDao = new GoodsDao();
				Goods goods = null;
				try {
					goods = goodsDao.getById(g_id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				g_number = goods.getG_Number();
				goods.setG_Number(g_number + r_number);
				try {
					goodsDao.update(goods);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				if (add != false) {
						JOptionPane.showMessageDialog(AddRecordFrame.this, "入库成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
						JOptionPane.showMessageDialog(AddRecordFrame.this, "入库失败！", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(130, 206, 64, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\u51FA\u5E93");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDate.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库失败，日期信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtG_ID.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库失败，货号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtNumber.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库失败，数量信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (txtS_ID.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库失败，员工号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String g_id, s_id, type = null;
				int r_number, g_number;
				SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
				Date date = null;
				try {
					date = sdf.parse(txtDate.getText());
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				g_id = txtG_ID.getText();
				r_number = Integer.parseInt(txtNumber.getText());
				s_id = txtS_ID.getText();
				if (comboBox.getSelectedIndex() > 0) {
					type = comboBox.getSelectedItem().toString();
				}
				if (type != "出库") {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库失败，类别信息不是出库！", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				RecordService recordService = new RecordService();
				Record record = new Record(date, g_id, r_number, s_id, type);
				boolean add = false;
				try {
					add = recordService.add(record);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				GoodsDao goodsDao = new GoodsDao();
				Goods goods = null;
				try {
					goods = goodsDao.getById(g_id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				g_number = goods.getG_Number();
				goods.setG_Number(g_number - r_number);
				try {
					goodsDao.update(goods);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (add != false) {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(AddRecordFrame.this, "出库失败！", "提示", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(210, 206, 64, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u9009\u62E9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point p = new Point(300, 200);
				JCalendarChooser chooser = new JCalendarChooser(AddRecordFrame.this, "选择日期", p, 60);
				Calendar d = chooser.showCalendarDialog();
				txtDate.setText(
						d.get(Calendar.YEAR) + "-" + (d.get(Calendar.MONTH) + 1) + "-" + d.get(Calendar.DAY_OF_MONTH));
			}
		});
		btnNewButton_2.setBounds(204, 10, 70, 23);
		contentPane.add(btnNewButton_2);

		comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "\u8BF7\u9009\u62E9", "\u5165\u5E93", "\u51FA\u5E93" }));
		comboBox.setBounds(144, 157, 70, 23);
		contentPane.add(comboBox);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
}
