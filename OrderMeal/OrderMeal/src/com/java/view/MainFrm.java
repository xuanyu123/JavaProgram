package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.model.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm(null, null);
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
	public MainFrm(UserType userType, Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 493);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.BLACK);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统设置");
		mnNewMenu.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		mnNewMenu.setForeground(Color.BLACK);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("修改密码");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				changePassword(ae);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/modify.png")));
		mntmNewMenuItem.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mntmNewMenuItem.setForeground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出系统");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出系统？") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		mntmNewMenuItem_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mntmNewMenuItem_1.setForeground(Color.BLACK);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("菜单管理");
		mnNewMenu_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mnNewMenu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("菜单列表");
		mntmNewMenuItem_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/search1.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("菜单维护");
		mntmNewMenuItem_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_4 = new JMenu("菜品类别");
		mnNewMenu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem menuItem = new JMenuItem("添加类别");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addMealClass(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/classadd.png")));
		mnNewMenu_4.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("类别管理");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				mealClassManage(ae);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/classlist.png")));
		mnNewMenu_4.add(menuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("订单管理");
		mnNewMenu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/cart.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("订单列表");
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/search1.png")));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("订单维护");
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("帮助");
		mnNewMenu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/help.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("关于我们");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/aboutus.png")));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected void mealClassManage(ActionEvent ae) {
		// 类别管理
		MealClassManageFrm mealClassManageFrm = new MealClassManageFrm();
		mealClassManageFrm.setVisible(true);
		desktopPane.add(mealClassManageFrm);
	}

	protected void addMealClass(ActionEvent ae) {
		// 添加菜品类别
		MealClassAddFrm mealClassAddFrm = new MealClassAddFrm();
		mealClassAddFrm.setVisible(true);
		desktopPane.add(mealClassAddFrm);
	}

	protected void changePassword(ActionEvent ae) {
		// 修改密码
		ChangePasswordFrm changePasswordFrm = new ChangePasswordFrm();
		changePasswordFrm.setVisible(true);
		desktopPane.add(changePasswordFrm);
	}

	protected void aboutUs(ActionEvent ae) {
		// 关于我们
		String infoString = "【餐厅点餐系统】\n";
		infoString += "欢迎您";
		JOptionPane.showMessageDialog(this, infoString);
	}
}
