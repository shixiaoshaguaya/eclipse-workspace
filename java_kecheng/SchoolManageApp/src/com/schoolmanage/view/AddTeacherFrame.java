package com.schoolmanage.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mkk.swing.JCalendarChooser;
import com.schoolmanage.service.TeacherService;
import com.schoolmanageapp.dao.TeacherDao;
import com.schoolmanageapp.dao.TeacherLessonDao;
import com.schoolmanageapp.model.Teacher;
import com.schoolmanageapp.model.TeacherLesson;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AddTeacherFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtBirthDate;
private Teacher oldTeacher;
private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrame frame = new AddTeacherFrame(null);
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
	public AddTeacherFrame(Teacher t) {
		this.oldTeacher=t;
		setResizable(false);
		setTitle("\u6559\u5E08\u767B\u8BB0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 318, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D");
		lblNewLabel.setBounds(54, 51, 54, 15);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(107, 48, 147, 21);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel label = new JLabel("\u6027    \u522B");
		label.setBounds(54, 86, 54, 15);
		contentPane.add(label);
		
		JRadioButton radbtMale = new JRadioButton("\u7537");
		radbtMale.setSelected(true);
		radbtMale.setBounds(109, 82, 42, 23);
		contentPane.add(radbtMale);
		
		JRadioButton radbtFemale = new JRadioButton("\u5973");
		radbtFemale.setBounds(174, 82, 42, 23);
		contentPane.add(radbtFemale);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(radbtFemale);
		bg.add(radbtMale);
		
		JLabel label_1 = new JLabel("\u51FA\u751F\u65E5\u671F");
		label_1.setBounds(54, 121, 54, 15);
		contentPane.add(label_1);
		
		txtBirthDate = new JTextField();
		txtBirthDate.setEditable(false);
		txtBirthDate.setBounds(107, 118, 81, 21);
		contentPane.add(txtBirthDate);
		txtBirthDate.setColumns(10);
		
		JButton button = new JButton("\u9009\u62E9");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Point p=new Point(300,200);
				JCalendarChooser chooser = new JCalendarChooser(AddTeacherFrame.this,"选择日期",p,60);
				Calendar d = chooser.showCalendarDialog();
				txtBirthDate.setText(d.get(Calendar.YEAR) + "-"
						+ (d.get(Calendar.MONTH) + 1) + "-"
						+ d.get(Calendar.DAY_OF_MONTH));
			}
		});
		button.setBounds(192, 117, 62, 23);
		contentPane.add(button);
		
		JComboBox combProfessional = new JComboBox();
		combProfessional.setModel(new DefaultComboBoxModel(new String[] {"\u52A9\u6559", "\u8BB2\u5E08", "\u526F\u6559\u6388", "\u6559\u6388"}));
		combProfessional.setBounds(107, 162, 147, 21);
		contentPane.add(combProfessional);
		
		JLabel label_2 = new JLabel("\u804C    \u79F0");
		label_2.setBounds(54, 165, 62, 15);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66    \u9662");
		lblNewLabel_1.setBounds(54, 207, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JComboBox combDepartment = new JComboBox();
		combDepartment.setModel(new DefaultComboBoxModel(new String[] {"\u4FE1\u7535\u5B66\u9662", "\u5916\u8BED\u5B66\u9662", "\u571F\u5EFA\u5B66\u9662", "\u7ECF\u7BA1\u5B66\u9662", "\u673A\u7535\u5B66\u9662", "\u6750\u5316\u5B66\u9662"}));
		combDepartment.setBounds(106, 204, 148, 21);
		contentPane.add(combDepartment);
		
		JLabel lblNewLabel_2 = new JLabel("\u57FA\u672C\u5DE5\u8D44");
		lblNewLabel_2.setBounds(54, 245, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JSpinner numSalary = new JSpinner();
		numSalary.setModel(new SpinnerNumberModel(new Double(0), new Double(0), null, new Double(1)));
		numSalary.setBounds(106, 242, 113, 22);
		contentPane.add(numSalary);
		
		JLabel lbll = new JLabel("\uFF08\u5143\uFF09");
		lbll.setBounds(219, 245, 54, 15);
		contentPane.add(lbll);
		
		JButton btOk = new JButton("\u4FDD\u5B58");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断数据用户输入数据的有效性
				if(txtId.getText().length()==0) {
					JOptionPane.showMessageDialog(AddTeacherFrame.this, "编号信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				return;	
				}
				if(txtName.getText().length()==0) {
					JOptionPane.showMessageDialog(AddTeacherFrame.this, "姓名信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
				return;	
				}
				if(txtBirthDate.getText().length()==0)
					{JOptionPane.showMessageDialog(AddTeacherFrame.this, "出生信息不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
					return;}
				
				//信息有效则保存
				Teacher t=null;
				SimpleDateFormat sdf = new SimpleDateFormat(("yyyy-MM-dd"));
				Date birthDate=null;
				try {
					birthDate=sdf.parse(txtBirthDate.getText());
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			
				if(oldTeacher!=null) {
					t=new Teacher(oldTeacher.getId(),txtName.getText(),(radbtMale.isSelected()?radbtMale.getText():radbtFemale.getText()),
							birthDate,combProfessional.getSelectedItem().toString(),combDepartment.getSelectedItem().toString(),
							Double.valueOf(numSalary.getValue().toString()));
				}
				else
				{					t=new Teacher(txtId.getText(),txtName.getText(),(radbtMale.isSelected()?radbtMale.getText():radbtFemale.getText()),
						birthDate,combProfessional.getSelectedItem().toString(),combDepartment.getSelectedItem().toString(),
						Double.valueOf(numSalary.getValue().toString()));
			}				
				TeacherService tService=new TeacherService();
				try {				
					if(oldTeacher!=null)
					{
						if(tService.update(t))
						{JOptionPane.showMessageDialog(AddTeacherFrame.this, "教师资料修改成功！", "提示", JOptionPane.INFORMATION_MESSAGE);					
						}else
						{
							JOptionPane.showMessageDialog(AddTeacherFrame.this, "教师资料修改失败！", "提示", JOptionPane.WARNING_MESSAGE);
						}
					}else
					{
						if(tService.add(t))
						{JOptionPane.showMessageDialog(AddTeacherFrame.this, "教师资料登记成功！", "提示", JOptionPane.INFORMATION_MESSAGE);					
						}else
						{
							JOptionPane.showMessageDialog(AddTeacherFrame.this, "教师资料登记失败！", "提示", JOptionPane.WARNING_MESSAGE);
						}
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btOk.setBounds(86, 285, 62, 23);
		contentPane.add(btOk);
		
		JButton btCancel = new JButton("\u53D6\u6D88");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		btCancel.setBounds(154, 285, 62, 23);
		contentPane.add(btCancel);
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5E08\u7F16\u53F7");
		lblNewLabel_3.setBounds(54, 20, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setBounds(107, 17, 147, 21);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		//新建与编辑共用本窗体，通过判断oldTeacher成员变量是否为空，不为空则为修改资料操作
		if(this.oldTeacher!=null)
		{
			txtId.setText(oldTeacher.getId());
			txtId.setEditable(false);
			txtName.setText(oldTeacher.getName());
			if(oldTeacher.getSex().equals(radbtMale.getText())){
				radbtMale.setSelected(true);
			}
			else
			{
				radbtFemale.setSelected(true);
			}
			txtBirthDate.setText(oldTeacher.getBirth().toString());
			combProfessional.setSelectedItem(oldTeacher.getProfessionalTitle());
			combDepartment.setSelectedItem(oldTeacher.getDepartment());
			numSalary.setValue(oldTeacher.getSalary());
		}
		
      
	}
}
