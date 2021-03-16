package com.wmsapp.view;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wmsapp.dao.GoodsDao;
import com.wmsapp.model.Goods;
import com.wmsapp.service.GoodsService;
import com.wmsapp.service.StaffService;


public class GetGoodsFrame extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetGoodsFrame frame = new GetGoodsFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void loadData() {
		GoodsDao goodsDao = new GoodsDao();
		List<Goods> staffList = null;
		try {
			staffList = goodsDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] stuTableData = new Object[staffList.size()][5];
		int i = 0;
		for (Goods goods: staffList) {
			stuTableData[i][0] = goods.getG_ID();
			stuTableData[i][1] = goods.getG_Name();
			stuTableData[i][2] = goods.getG_Price();
			stuTableData[i][3] = goods.getG_Number();
			stuTableData[i][4] = goods.getG_Factory();
			i++;
		}
		DefaultTableModel model = new DefaultTableModel(stuTableData, new String[] { "货号", "名称", "单价", "数量", "生产商" });
		table.setModel(model);// 将准备好的数据模型绑定显示到JTable控件
	}

	/**
	 * Create the frame.
	 */
	public GetGoodsFrame() {
		setTitle("\u8D27\u7269\u4FE1\u606F\u68C0\u7D22");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton btnNewButton = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 读取数据显示JTable
				GetGoodsFrame.loadData();
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u8D27\u7269\u8D44\u6599\u4FEE\u6539\u4E0E\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowIndex = table.getSelectedRow();
				if (rowIndex > -1) {
					String id = table.getValueAt(rowIndex, 0).toString();
					if (!id.equals("")) {
						GoodsService goodsService = new GoodsService();
						Goods goods = null;
						try {
							goods = goodsService.getById(id);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						GoodsFrame goodsFrame = new GoodsFrame(goods);
						goodsFrame.setVisible(true);
					}
				}
			}
		});
		panel.add(button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "货号", "名称", "单价", "数量", "生产商" }));
		scrollPane.setViewportView(table);
	}
}
