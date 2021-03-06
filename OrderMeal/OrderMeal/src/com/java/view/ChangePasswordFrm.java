package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.AdminDao;
import com.java.model.Admin;
import com.java.model.UserType;
import com.java.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class ChangePasswordFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	
	private JLabel currentUserLabel;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ChangePasswordFrm frame = new ChangePasswordFrm();
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
	public ChangePasswordFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("修改密码");
		
		// 设置窗体大小
		int windowsWedth = 533;
		int windowsHeight = 390;
		
		// 得到显示器屏幕的宽高
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//设置窗体在显示器居中显示
		this.setBounds(300, 200, windowsWedth, windowsHeight);
		
//		setBounds(100, 100, 533, 390);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("原密码：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/passwd.png")));
		lblNewLabel.setBounds(63, 82, 84, 16);
		
		JLabel lblNewLabel_1 = new JLabel("新密码：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/changpasswd.png")));
		lblNewLabel_1.setBounds(63, 128, 84, 16);
		
		JLabel lblNewLabel_2 = new JLabel("确认密码：");
		lblNewLabel_2.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/changepasswd2.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(63, 178, 94, 16);
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setBounds(159, 71, 206, 39);
		oldPasswordTextField.setColumns(10);
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		newPasswordTextField.setBounds(159, 117, 206, 39);
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		confirmPasswordTextField.setBounds(159, 167, 206, 39);
		
		JButton confirmButton = new JButton("确认");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitChange(ae);
			}
		});
		confirmButton.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/confirm.png")));
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 16));
		confirmButton.setBounds(63, 232, 117, 29);
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/reset.png")));
		resetButton.setFont(new Font("宋体", Font.PLAIN, 16));
		resetButton.setBounds(232, 232, 117, 29);
		
		JLabel lblNewLabel_3 = new JLabel("当前用户：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setIcon(new ImageIcon(ChangePasswordFrm.class.getResource("/images/currentUser.png")));
		lblNewLabel_3.setBounds(63, 33, 96, 16);
		
		currentUserLabel = new JLabel("New label");
		currentUserLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		currentUserLabel.setBounds(174, 33, 61, 16);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(193))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(currentUserLabel)
					.addContainerGap(218, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(135)
					.addComponent(confirmButton)
					.addGap(88)
					.addComponent(resetButton)
					.addContainerGap(215, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(currentUserLabel, Alignment.TRAILING)
						.addComponent(lblNewLabel_3, Alignment.TRAILING))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(confirmButton)
						.addComponent(resetButton))
					.addGap(48))
		);
		gl_contentPane.linkSize(SwingConstants.VERTICAL, new Component[] {oldPasswordTextField, newPasswordTextField, confirmPasswordTextField});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {oldPasswordTextField, newPasswordTextField, confirmPasswordTextField});
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {confirmButton, resetButton});
		
		contentPane.setLayout(gl_contentPane);
		
		
		if("系统管理员".equals(MainFrm.userType.getName())){
			Admin admin = (Admin)MainFrm.userObject;
			currentUserLabel.setText("【系统管理员】" + admin.getName());
		}
//			else if("VIP客户".equals(MainFrm.userType.getName())){
//			  = (Student)MainFrm.userObject;
//			currentUserLabel.setText("¡¾Ñ§Éú¡¿" + student.getName());
//		}else{
//			Teacher teacher = (Teacher)MainFrm.userObject;
//			currentUserLabel.setText("¡¾Ñ§Éú¡¿" + teacher.getName());
//		}
	}


	protected void submitChange(ActionEvent ae) {
		// 确认修改密码
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String confirmPassword = confirmPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请填写旧密码");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请填写新密码");
			return;
		}
		if(StringUtil.isEmpty(confirmPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码");
			return;
		}
		if(!newPassword.equals(confirmPassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致");
			return;
		}
		if("系统管理员".equals(MainFrm.userType.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.changePassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		
	}


	protected void resetValue(ActionEvent ae) {
		// 重置
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
