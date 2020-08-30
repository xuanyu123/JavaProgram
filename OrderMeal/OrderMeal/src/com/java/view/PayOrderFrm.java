package com.java.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.java.dao.OrderDao;
import com.java.model.Order;
import com.java.model.OrderMid;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class PayOrderFrm extends JInternalFrame {
	private JTextField orderNumTextField;
	private JTextField creatTimeTextField;
	private JTextField totalMoneyTextField;
	private JTextField saleTextField;
	private JTextField realMoneyTextField;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PayOrderFrm frame = new PayOrderFrm();
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
	public PayOrderFrm() {
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 22));
		setTitle("订单详情");
		setBounds(300, 0, 644, 718);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("订单编号：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(82, 123, 116, 35);
		getContentPane().add(lblNewLabel_2);
		
		orderNumTextField = new JTextField();
		orderNumTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		orderNumTextField.setEditable(false);
		orderNumTextField.setBounds(280, 123, 260, 35);
		getContentPane().add(orderNumTextField);
		orderNumTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("创建时间：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(82, 171, 116, 35);
		getContentPane().add(lblNewLabel_3);
		
		creatTimeTextField = new JTextField();
		creatTimeTextField.setFont(new Font("宋体", Font.PLAIN, 20));
		creatTimeTextField.setEditable(false);
		creatTimeTextField.setBounds(280, 171, 260, 35);
		getContentPane().add(creatTimeTextField);
		creatTimeTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("结账单");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(274, 42, 110, 35);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("XXX餐饮有限公司");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(226, 76, 215, 35);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 229, 600, 226);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		
		
		table.setFont(new Font("宋体", Font.PLAIN, 16));
		table.setRowHeight(22);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"菜品名称","单价","数量","金额"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("消费金额：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(392, 471, 98, 18);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("折扣：");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_5.setBounds(392, 521, 98, 18);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("应收金额：");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(392, 572, 98, 18);
		getContentPane().add(lblNewLabel_6);
		
		totalMoneyTextField = new JTextField();
		totalMoneyTextField.setEditable(false);
		totalMoneyTextField.setFont(new Font("宋体", Font.PLAIN, 18));
		totalMoneyTextField.setBounds(504, 468, 86, 24);
		getContentPane().add(totalMoneyTextField);
		totalMoneyTextField.setColumns(10);
		
		saleTextField = new JTextField();
		saleTextField.setEditable(false);
		saleTextField.setFont(new Font("宋体", Font.PLAIN, 18));
		saleTextField.setBounds(504, 518, 86, 24);
		getContentPane().add(saleTextField);
		saleTextField.setColumns(10);
		
		realMoneyTextField = new JTextField();
		realMoneyTextField.setEditable(false);
		realMoneyTextField.setFont(new Font("宋体", Font.PLAIN, 18));
		realMoneyTextField.setBounds(504, 569, 86, 24);
		getContentPane().add(realMoneyTextField);
		realMoneyTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("关闭");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				closeThis();
			}
		});
		btnNewButton.setBounds(271, 634, 113, 27);
		getContentPane().add(btnNewButton);
		
		setTable(new OrderMid());
		showOrderInfo();

	}
	
	
	protected void closeThis() {
		// 销毁窗体
		this.dispose();
		OrderDao ord = new OrderDao();
		ord.deleteOrderMid();
	}

	// 显示订单编号、创建时间、消费金额、折扣、应收金额
	public void showOrderInfo() {
		// 获取本次订单中菜品的id编号
		OrderMid orderMid = new OrderMid();
		OrderDao oDao = new OrderDao();
		List<OrderMid> mealOrderList = oDao.getMealOrderList(orderMid);	
		Vector vector = null;
		for (OrderMid o : mealOrderList) {
			vector = new Vector();
			vector.add(o.getOrderNum());
		}
		// 订单编号
		String orderNumString = vector.get(0).toString();
		orderNumTextField.setText(orderNumString);

		// 创建时间
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String createTime = dateFormat.format(date);
		creatTimeTextField.setText(createTime);

		// 消费金额、折扣、应收金额
		List<Order> orderList = oDao.getOrderList(orderNumString);
		Vector vector2 = null;
		for (Order o : orderList) {
			vector2 = new Vector();
			vector2.add(o.getTotalMoney());
			vector2.add(o.getRealMoney());
		}
		Float tMoney = (Float) vector2.get(0);
		Float rMoney = (Float) vector2.get(1);
		Float sale = tMoney - rMoney;
		String saleString = String.format("%.1f", sale);
		totalMoneyTextField.setText(tMoney.toString());
		saleTextField.setText(saleString);
		realMoneyTextField.setText(rMoney.toString());
	}
	
	// 显示所有
	public void setTable(OrderMid orderMid) {
		DefaultTableModel dft = (DefaultTableModel) table.getModel();
		dft.setRowCount(0);
		OrderDao orderDao = new OrderDao();
		List<OrderMid> mealOrderList = orderDao.getMealOrderList(orderMid);
		for (OrderMid o : mealOrderList) {
			Vector vector = new Vector();
			vector.add(o.getOrderName());
			vector.add(o.getOrderPrice());
			vector.add(o.getOrderAmount());
			vector.add(o.getTotalMoney());
			dft.addRow(vector);
		}
		orderDao.closeDao();		
	}
}
