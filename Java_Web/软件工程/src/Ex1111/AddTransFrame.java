package Ex1111;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddTransFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtCardNumber;
	private JTextField txtTransType;
	private JTextField txtTransMoney;

	private static double Money;
	private static String cardNumber;
	private static double balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTransFrame frame = new AddTransFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void loadData() {
		Money = 0;
		TransDao transDao = new TransDao();
		CardDao cardDao = new CardDao();
		List<Trans> transList = null;
		List<Card> cardList = null;
		try {
			transList = transDao.getAll();
			cardList = cardDao.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Trans trans : transList) {
			Money += trans.getTransMoney();
		}
		for (Card card : cardList) {
			cardNumber = card.getCardNumber();
			balance = card.getBalance();		}
	}

	/**
	 * Create the frame.
	 */
	public AddTransFrame() {
		setTitle("\u8F6C\u8D26\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\u7F16   \u53F7");
		lblNewLabel_1.setBounds(75, 20, 54, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u5BF9\u65B9\u8D26\u53F7");
		lblNewLabel_2.setBounds(75, 76, 54, 15);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u4EA4\u6613\u7C7B\u578B");
		lblNewLabel_3.setBounds(75, 132, 54, 15);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u4EA4\u6613\u91D1\u989D");
		lblNewLabel_4.setBounds(75, 188, 54, 15);
		contentPane.add(lblNewLabel_4);

		txtID = new JTextField();
		txtID.setBounds(131, 17, 90, 21);
		contentPane.add(txtID);
		txtID.setColumns(10);

		txtCardNumber = new JTextField();
		txtCardNumber.setBounds(131, 73, 90, 21);
		contentPane.add(txtCardNumber);
		txtCardNumber.setColumns(10);

		txtTransType = new JTextField();
		txtTransType.setText("\u8F6C\u51FA");
		txtTransType.setBounds(131, 129, 90, 21);
		contentPane.add(txtTransType);
		txtTransType.setColumns(10);

		txtTransMoney = new JTextField();
		txtTransMoney.setBounds(131, 185, 90, 21);
		contentPane.add(txtTransMoney);
		txtTransMoney.setColumns(10);

		JButton btnOK = new JButton("\u8F6C\u8D26");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadData();
				if (txtID.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddTransFrame.this, "转账失败，编号信息不能为空！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtCardNumber.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddTransFrame.this, "转账失败，对方账号信息不能为空！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtTransType.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddTransFrame.this, "转账失败，交易类型信息不能为空！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtTransMoney.getText().length() == 0) {
					JOptionPane.showMessageDialog(AddTransFrame.this, "转账失败，交易金额信息不能为空！", "提示",
							JOptionPane.WARNING_MESSAGE);
				}
				if (Double.parseDouble(txtTransMoney.getText()) <= 0) {
					JOptionPane.showMessageDialog(AddTransFrame.this, "转账失败，转账金额不能为负", "提示",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					if (Double.parseDouble(txtTransMoney.getText()) > balance) {
						JOptionPane.showMessageDialog(AddTransFrame.this, "转账失败，账户余额不足", "提示",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (Double.parseDouble(txtTransMoney.getText()) > (50000.00 - Money)) {
							JOptionPane.showMessageDialog(AddTransFrame.this,
									"转账失败，转账金额达到上限！您还有" + (50000.00 - Money) + "额度。", "提示", JOptionPane.WARNING_MESSAGE);
						} else {
							int id;
							String CardNumber, TransType;
							double TransMoney;
							id = Integer.parseInt(txtID.getText());
							CardNumber = txtCardNumber.getText();
							TransType = txtTransType.getText();
							TransMoney = Double.parseDouble(txtTransMoney.getText());
							TransService transService = new TransService();
							Trans trans = new Trans(id, CardNumber, TransType, TransMoney);
							// 账户余额更新
							CardService cardService = new CardService();
							Card card = null;
							try {
								card = cardService.getById(cardNumber);
							} catch (Exception e3) {
								// TODO Auto-generated catch block
								e3.printStackTrace();
							}
							String CardNumber2, Password;
							double Balance;
							CardNumber2 = card.getCardNumber();
							Balance = balance - TransMoney;
							Password = card.getPassword();
							card.setCardNumber(CardNumber2);
							card.setBalance(Balance);
							card.setPassword(Password);
							try {
								if (cardService.update(card)) {
									boolean add = false;
									try {
										add = transService.add(trans);
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									if (add != false) {
										JOptionPane.showMessageDialog(AddTransFrame.this, "转账成功！", "提示",
												JOptionPane.INFORMATION_MESSAGE);
									} else {
										JOptionPane.showMessageDialog(AddTransFrame.this, "遗憾，转账失败！", "提示",
												JOptionPane.INFORMATION_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(AddTransFrame.this, "遗憾，转账失败！", "提示",
											JOptionPane.WARNING_MESSAGE);
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}
		});
		btnOK.setBounds(10, 233, 62, 23);
		contentPane.add(btnOK);

		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.setBounds(223, 233, 62, 23);
		contentPane.add(btnCancel);
	}
}
