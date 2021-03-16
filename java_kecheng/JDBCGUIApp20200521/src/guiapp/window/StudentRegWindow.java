package guiapp.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import guiapp.data.DataSource;
import guiapp.data.StudentDao;
import guiapp.pojo.Student;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class StudentRegWindow {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtBirthday;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton radBtMale;
	private JRadioButton radBtFemale;
	private JComboBox comBoxCollage;
	private List<Student> studentLst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegWindow window = new StudentRegWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void show() {
		this.frame.setAlwaysOnTop(true);
		this.frame.setVisible(true);
	}

	public void close() {
		this.frame.dispose();
	}

	/**
	 * Create the application.
	 */
	public StudentRegWindow() {
		initialize();
		this.studentLst = new ArrayList<Student>();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("学生注册");
		frame.setBounds(100, 100, 333, 353);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("新生信息登记");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		panel.add(label);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, sex, collage;
				Date birthday = null;
				name = txtName.getText();
				if (radBtMale.isSelected()) {
					sex = "男";
				} else {
					sex = "女";
				}
				if (comBoxCollage.getSelectedIndex() > 0) {
					collage = comBoxCollage.getSelectedItem().toString();
				} else {
					collage = "";
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					birthday = sdf.parse(txtBirthday.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Student student = new Student(null, name, sex, collage, birthday);
				StudentDao stuDao=new StudentDao();
				if (stuDao.add(student)) {
					int count = DataSource.getAll().size();
					JOptionPane.showMessageDialog(null, "恭喜，注册成功！","信息",JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "恭喜，注册失败！","信息",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 14));
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("您单击取消了，程序将退出！");
				// System.exit(0);
				StudentRegWindow.this.close();
			}
		});
		btnNewButton_1.setFont(new Font("SimSun", Font.PLAIN, 14));
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel label_1 = new JLabel("姓    名");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 14));
		label_1.setBounds(28, 21, 61, 16);
		panel_2.add(label_1);

		txtName = new JTextField();
		txtName.setBounds(99, 20, 147, 20);
		panel_2.add(txtName);
		txtName.setColumns(10);

		JLabel label_2 = new JLabel("性    别");
		label_2.setFont(new Font("SimSun", Font.PLAIN, 14));
		label_2.setBounds(28, 79, 61, 16);
		panel_2.add(label_2);

		JLabel label_3 = new JLabel("出生日期");
		label_3.setFont(new Font("SimSun", Font.PLAIN, 14));
		label_3.setBounds(28, 136, 65, 16);
		panel_2.add(label_3);

		txtBirthday = new JTextField();
		txtBirthday.setBounds(100, 135, 141, 20);
		panel_2.add(txtBirthday);
		txtBirthday.setColumns(10);

		JLabel label_4 = new JLabel("所属学院");
		label_4.setFont(new Font("SimSun", Font.PLAIN, 14));
		label_4.setBounds(24, 185, 65, 16);
		panel_2.add(label_4);

		comBoxCollage = new JComboBox();
		comBoxCollage.setFont(new Font("宋体", Font.PLAIN, 14));
		comBoxCollage.setModel(new DefaultComboBoxModel(new String[] { "请选择", "信息与电子工程学院", "商学院", "智能制造学院" }));
		comBoxCollage.setBounds(99, 184, 141, 20);
		panel_2.add(comBoxCollage);

		radBtMale = new JRadioButton("男");
		buttonGroup_1.add(radBtMale);
		radBtMale.setFont(new Font("宋体", Font.PLAIN, 14));
		radBtMale.setBounds(99, 77, 53, 23);
		panel_2.add(radBtMale);
		radBtMale.setSelected(true);

		radBtFemale = new JRadioButton("女");
		buttonGroup_1.add(radBtFemale);
		radBtFemale.setFont(new Font("宋体", Font.PLAIN, 14));
		radBtFemale.setBounds(154, 76, 53, 23);
		panel_2.add(radBtFemale);

	}

	public JRadioButton getRadBtMale() {
		return radBtMale;
	}

	public JRadioButton getRadBtFemale() {
		return radBtFemale;
	}

	public JComboBox getComBoxCollage() {
		return comBoxCollage;
	}
}
