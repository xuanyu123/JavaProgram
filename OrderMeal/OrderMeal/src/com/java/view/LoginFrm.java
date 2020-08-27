package com.java.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.java.dao.AdminDao;
import com.java.model.Admin;
import com.java.model.UserType;
import com.java.util.StringUtil;
import javax.swing.JPasswordField;

public class LoginFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JComboBox userTypeComboBox;
	private JPasswordField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrm frame = new LoginFrm();
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
	public LoginFrm() {
		setTitle("餐厅点餐系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("餐厅点餐系统欢迎您");
		label.setBounds(129, 11, 319, 53);
		label.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/OrderMeal.png")));
		label.setFont(new Font("宋体", Font.BOLD, 20));
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setBounds(103, 109, 80, 18);
		label_1.setFont(new Font("宋体", Font.PLAIN, 15));
		label_1.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/userName.png")));
		
		JLabel label_2 = new JLabel("密  码：");
		label_2.setBounds(103, 162, 81, 18);
		label_2.setFont(new Font("宋体", Font.PLAIN, 15));
		label_2.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/password.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(207, 103, 190, 30);
		userNameTextField.setColumns(10);
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setBounds(210, 210, 131, 27);
		userTypeComboBox.setFont(new Font("宋体", Font.PLAIN, 15));
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.ORDCUSTOMER, UserType.VIPCUSTOMER, UserType.EMPLOYEE}));
		
		JButton loginButton = new JButton("登陆");
		loginButton.setBounds(74, 266, 95, 30);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("宋体", Font.PLAIN, 15));
		loginButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/login.png")));
		
		JButton resetButton = new JButton("重置");
		resetButton.setBounds(210, 266, 85, 30);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("宋体", Font.PLAIN, 15));
		resetButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/reset.png")));
		
		JButton registerButton = new JButton("注册用户");
		registerButton.setBounds(329, 266, 119, 30);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				registerAct(ae);
			}
		});
		registerButton.setFont(new Font("宋体", Font.PLAIN, 15));
		registerButton.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/register.png")));
		
		JLabel label_3 = new JLabel("用户类型：");
		label_3.setBounds(103, 214, 95, 18);
		label_3.setFont(new Font("宋体", Font.PLAIN, 15));
		label_3.setIcon(new ImageIcon(LoginFrm.class.getResource("/images/new_user.png")));
		contentPane.setLayout(null);
		contentPane.add(label);
		contentPane.add(label_2);
		contentPane.add(label_1);
		contentPane.add(loginButton);
		contentPane.add(label_3);
		contentPane.add(resetButton);
		contentPane.add(registerButton);
		contentPane.add(userTypeComboBox);
		contentPane.add(userNameTextField);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(207, 159, 190, 30);
		contentPane.add(passwordTextField);
	}

	protected void registerAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())) {
			//系统管理员登陆
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+admin.getName() + "登录本系统！");
			this.dispose();
			new MainFrm(selectedItem, admin).setVisible(true);
		}else if("VIP客户".equals(selectedItem.getName())) {
			//VIP客户登陆
		}else if("员工".equals(selectedItem.getName())) {
			//员工登陆
		}else {
			//普通客户登陆
		}
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
		
	}
}
