package guiapp.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import guiapp.data.StudentDao;
import guiapp.pojo.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class StudentEditDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtBirthday;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboxCollage;
	private JRadioButton radbtFemale;
	private JRadioButton radbtMale;

	private Student student;

	/**
	 * 初始化要编辑的学生资料至窗体编辑控件
	 */
	public void initData(Student student) {
		if (student != null) {
			txtId.setText(student.getId().toString());
			txtName.setText(student.getName());
			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
			txtBirthday.setText(sdf.format(student.getBirthday()).toString());
			if ("男".equals(student.getSex())) {
				radbtMale.setSelected(true);
			} else {
				radbtFemale.setSelected(true);
			}
			comboxCollage.setSelectedItem(student.getCollage());
			this.student = student;
		}
	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			StudentEditDialog dialog = new StudentEditDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public StudentEditDialog(Student student) {
		setModal(true);
		setTitle("\u5B66\u751F\u8D44\u6599\u7F16\u8F91");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u7F16    \u53F7");
		lblNewLabel.setBounds(44, 21, 54, 15);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u59D3    \u540D");
		lblNewLabel_1.setBounds(44, 60, 54, 15);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\u6027    \u522B");
		lblNewLabel_2.setBounds(44, 98, 54, 15);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\u51FA\u751F\u65E5\u671F");
		lblNewLabel_3.setBounds(44, 133, 54, 15);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\u6240\u5C5E\u5B66\u9662");
		lblNewLabel_4.setBounds(44, 173, 54, 15);
		contentPanel.add(lblNewLabel_4);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(117, 18, 105, 21);
		contentPanel.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(117, 57, 105, 21);
		contentPanel.add(txtName);
		txtName.setColumns(10);

		txtBirthday = new JTextField();
		txtBirthday.setBounds(117, 130, 105, 21);
		contentPanel.add(txtBirthday);
		txtBirthday.setColumns(10);

		radbtMale = new JRadioButton("\u7537");
		buttonGroup.add(radbtMale);
		radbtMale.setSelected(true);
		radbtMale.setBounds(117, 94, 37, 23);
		contentPanel.add(radbtMale);

		radbtFemale = new JRadioButton("\u5973");
		buttonGroup.add(radbtFemale);
		radbtFemale.setBounds(167, 94, 37, 23);
		contentPanel.add(radbtFemale);

		comboxCollage = new JComboBox();
		comboxCollage.setModel(new DefaultComboBoxModel(
				new String[] { "\u8BF7\u9009\u62E9", "\u4FE1\u606F\u4E0E\u7535\u5B50\u5DE5\u7A0B\u5B66\u9662",
						"\u5546\u5B66\u9662", "\u667A\u80FD\u5236\u9020\u5B66\u9662" }));
		comboxCollage.setBounds(117, 169, 105, 23);
		contentPanel.add(comboxCollage);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u786E\u5B9A");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String name, sex, collage;
						Date birthday = null;
						name = txtName.getText();
						if (radbtMale.isSelected()) {
							sex = "男";
						} else {
							sex = "女";
						}
						if (comboxCollage.getSelectedIndex() > 0) {
							collage = comboxCollage.getSelectedItem().toString();
						} else {
							collage = "";
						}
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							birthday = sdf.parse(txtBirthday.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						//获得编辑结果，设置学生记录对象
					    student.setName(name);
					    student.setSex(sex);
					    student.setBirthday(birthday);
					    student.setCollage(collage);
						StudentDao stuDao=new StudentDao();				
						if (stuDao.update(student)) {								
							JOptionPane.showMessageDialog(null,"恭喜，修改成功！","信息", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,"遗憾，修改失败！","信息", JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u53D6\u6D88");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		initData(student);
	}

	public JComboBox getComboxCollage() {
		return comboxCollage;
	}

	public JRadioButton getRadbtFemale() {
		return radbtFemale;
	}

	public JRadioButton getRadbtMale() {
		return radbtMale;
	}
}
