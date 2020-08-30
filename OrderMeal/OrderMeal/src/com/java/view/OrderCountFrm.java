package com.java.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;

import com.java.dao.OrderDao;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderCountFrm extends JInternalFrame {
	private JTextField customerSaleMoneyTextField;
	private JTextField vipSaleMoneyTextField;
	private JTextField employeeSaleMoneyTextField;
	private JTextField sumMoneyTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrderCount frame = new OrderCount();
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
	public OrderCountFrm() {
		setTitle("订单统计");
		setIconifiable(true);
		setClosable(true);
		setBounds(300, 50, 644, 520);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("普通客户销售额：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(93, 60, 179, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("VIP客户销售额：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(93, 127, 179, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("员工销售额：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(93, 206, 179, 28);
		getContentPane().add(lblNewLabel_2);
		
		customerSaleMoneyTextField = new JTextField();
		customerSaleMoneyTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		customerSaleMoneyTextField.setBounds(303, 55, 187, 38);
		getContentPane().add(customerSaleMoneyTextField);
		customerSaleMoneyTextField.setColumns(10);
		
		vipSaleMoneyTextField = new JTextField();
		vipSaleMoneyTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		vipSaleMoneyTextField.setBounds(303, 122, 187, 38);
		getContentPane().add(vipSaleMoneyTextField);
		vipSaleMoneyTextField.setColumns(10);
		
		employeeSaleMoneyTextField = new JTextField();
		employeeSaleMoneyTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		employeeSaleMoneyTextField.setBounds(303, 201, 187, 38);
		getContentPane().add(employeeSaleMoneyTextField);
		employeeSaleMoneyTextField.setColumns(10);
		
		sumMoneyTextField = new JTextField();
		sumMoneyTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		sumMoneyTextField.setBounds(303, 283, 187, 38);
		getContentPane().add(sumMoneyTextField);
		sumMoneyTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("总销售额：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(93, 288, 179, 28);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("关闭");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeThis(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(262, 396, 121, 38);
		getContentPane().add(btnNewButton);
		
		showSaleInfo();

	}
	
	protected void closeThis(MouseEvent e) {
		this.dispose();
		
	}

	public void showSaleInfo() {
		OrderDao orderDao = new OrderDao();
		List customerSale = orderDao.getCustomerSale();
		Float cMoney = (Float) customerSale.get(0);
		Float vMoney = (Float) customerSale.get(1);
		Float eMoney = (Float) customerSale.get(2);
		customerSaleMoneyTextField.setText(customerSale.get(0).toString());
		vipSaleMoneyTextField.setText(customerSale.get(1).toString());
		employeeSaleMoneyTextField.setText(customerSale.get(2).toString());
		Float sum = cMoney + vMoney + eMoney;
		sumMoneyTextField.setText(sum.toString());
	}

}
