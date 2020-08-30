package com.java.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.java.dao.ClassDao;
import com.java.dao.MealDao;
import com.java.dao.OrderDao;
import com.java.model.CustomerType;
import com.java.model.Meal;
import com.java.model.MealClass;
import com.java.model.Order;
import com.java.model.OrderMid;
import com.java.util.StringUtil;
import com.mysql.fabric.xmlrpc.base.Array;

import javax.swing.DefaultComboBoxModel;

public class OrderPayFrm extends JInternalFrame {
	
	private JPanel contentPane;
	private JTable mealOrderListTable;
	private List<MealClass> mealClassList;
	private List<CustomerType> customerTypeList;
	private JLabel mealPriceTextField;
	private JTextField sumAmountTextField;
	private JTextField sumMoneyTextField;
	private JTextField cashierTextField;
	private JTextField saleTextField;
	private JComboBox customerTypeComboBox;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrderPayFrm frame = new OrderPayFrm();
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
	public OrderPayFrm() {
		setTitle("订单结算");
		setIconifiable(true);
		setClosable(true);
		setBounds(120, 100, 932, 595);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 18, 752, 302);
		
		JLabel lblNewLabel = new JLabel("总数量");
		lblNewLabel.setBounds(150, 362, 45, 18);
		
		sumAmountTextField = new JTextField();
		sumAmountTextField.setEditable(false);
		sumAmountTextField.setBounds(228, 359, 64, 24);
		sumAmountTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("总金额");
		lblNewLabel_1.setBounds(389, 365, 45, 18);
		
		sumMoneyTextField = new JTextField();
		sumMoneyTextField.setEditable(false);
		sumMoneyTextField.setBounds(448, 362, 86, 24);
		sumMoneyTextField.setColumns(10);
		
		cashierTextField = new JTextField();
		cashierTextField.setBounds(639, 433, 86, 24);
		cashierTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("收银员");
		lblNewLabel_2.setBounds(575, 436, 72, 18);
		
		JLabel lblNewLabel_3 = new JLabel("客户类型");
		lblNewLabel_3.setBounds(242, 436, 72, 18);
		
		customerTypeComboBox = new JComboBox();
		customerTypeComboBox.setBounds(347, 433, 160, 24);
		
		JButton btnNewButton = new JButton("确认订单");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				closeThis();
				PayOrderFrm payOrderFrm = new PayOrderFrm();
				payOrderFrm.setVisible(true);
				MainFrm.desktopPane.add(payOrderFrm);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitOrder(e);
			}
		});
		btnNewButton.setBounds(205, 497, 113, 27);
		mealOrderListTable = new JTable();
		mealOrderListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});

		mealOrderListTable.setFont(new Font("宋体", Font.PLAIN, 16));
		mealOrderListTable.setRowHeight(22);
		mealOrderListTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"菜品名称","所属类别","单价","数量","总价"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(mealOrderListTable);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_3);
		contentPane.add(customerTypeComboBox);
		contentPane.add(btnNewButton);
		contentPane.add(lblNewLabel_2);
		contentPane.add(cashierTextField);
		contentPane.add(lblNewLabel);
		contentPane.add(sumAmountTextField);
		contentPane.add(lblNewLabel_1);
		contentPane.add(sumMoneyTextField);
		contentPane.add(scrollPane);
		
		JLabel label_1 = new JLabel("元");
		label_1.setBounds(548, 365, 37, 18);
		contentPane.add(label_1);
		
		JButton btnNewButton_1 = new JButton("返回菜单");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				closeThis();
				OrderMealFrm orderMealFrm = new OrderMealFrm();
				orderMealFrm.setVisible(true);
				MainFrm.desktopPane.add(orderMealFrm);
			}
		});
		btnNewButton_1.setBounds(607, 497, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("打折");
		label.setBounds(639, 365, 72, 18);
		contentPane.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("折");
		lblNewLabel_4.setBounds(790, 365, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		saleTextField = new JTextField();
		saleTextField.setBounds(686, 362, 86, 24);
		contentPane.add(saleTextField);
		saleTextField.setColumns(10);
		setMealClassInfo();
		setTable(new OrderMid());
		setCustomerType();
		setPayInfo();
	}

	// 提交订单
	protected void submitOrder(ActionEvent e) {
		Order order = new Order();
		OrderMid orderMid = new OrderMid();
		OrderDao orderDao = new OrderDao();
		
		// 获取本次订单中菜品的id编号
		List<OrderMid> mealOrderList = orderDao.getMealOrderList(orderMid);		
				
		// 设置随机订单编号
		int num = (int) ((Math.random() * 9 + 1) * 1000000);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
		String orderNumber = num + dateFormat.format(date);
		
		// 获取总数量
		String sumAmountString = sumAmountTextField.getText().toString();
		Integer totalAmount = Integer.parseInt(sumAmountString);
		
		// 获取总金额
		String sumMoneyString = sumMoneyTextField.getText().toString();
		Float totalMoney = Float.parseFloat(sumMoneyString);
		
		// 获取打折情况
		String saleString = saleTextField.getText().toString();
		Integer sale = 10;
		if (!StringUtil.isEmpty(saleString)) {
			sale = Integer.parseInt(saleString);
		}
		
		// 计算实际支付金额
		Float realMoney = (Float)(totalMoney * sale)/10;
		
		// 获取客户类型
		CustomerType cType = (CustomerType) customerTypeComboBox.getSelectedItem();
		
		// 获取收银员
		String cashier = cashierTextField.getText().toString();

		// 更新OrderMid表中 OrderNum 列的订单编号
		for (OrderMid oMid : mealOrderList) {
			orderDao.updateOrderNum(orderNumber, oMid.getId());
		}
		
		// 将订单信息插入Order表中
		if(StringUtil.isEmpty(cashier)){
			JOptionPane.showMessageDialog(this, "请填写收银员姓名！");
			return;
		}
		order.setOrderNum(orderNumber);
		order.setTotalAmount(totalAmount);
		order.setTotalMoney(totalMoney);
		order.setSale(sale);
		order.setRealMoney(realMoney);
		order.setcTypeId(cType.getId());
		order.setCashier(cashier);

		orderDao.insertOrderInfo(order);
	}

	// 设置窗口不可见
	protected void closeThis() {
		this.setVisible(false);
		
	}

	// 删除选中数据
	protected void selectedTableRow(MouseEvent e) {
		int row = mealOrderListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定要删除该条数据吗？") != JOptionPane.OK_OPTION){
			return;
		}
		OrderDao orderDao = new OrderDao();
		if(orderDao.delete(Integer.parseInt(mealOrderListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败");
		}
		orderDao.closeDao();
		setTable(new OrderMid());
		setPayInfo();
	}

	// 显示所有
	public void setTable(OrderMid orderMid) {
		DefaultTableModel dft = (DefaultTableModel) mealOrderListTable.getModel();
		dft.setRowCount(0);
		OrderDao orderDao = new OrderDao();
		List<OrderMid> mealOrderList = orderDao.getMealOrderList(orderMid);
		for (OrderMid o : mealOrderList) {
			Vector vector = new Vector();
			vector.add(o.getOrderName());
			vector.add(getClassNameById(o.getClassId()));
			vector.add(o.getOrderPrice());
			vector.add(o.getOrderAmount());
			vector.add(o.getTotalMoney());
			dft.addRow(vector);
		}
		orderDao.closeDao();
	}
	
	// 显示菜品类别
	private void setMealClassInfo() {
		ClassDao classDao = new ClassDao();
		mealClassList = classDao.getClassList(new MealClass());
		classDao.closeDao();
	}
	
	// 通过类别id获取类别名称
	private String getClassNameById(int id) {
		for (MealClass mc : mealClassList) {
			if(mc.getId() == id) {
				return mc.getName();
			}
		}
		return "";
	}
	
	// 显示结算数量、金额等信息
	private void setPayInfo() {
		OrderDao orderDao = new OrderDao();
		OrderMid orderMid = new OrderMid();
		Integer sumAmount = orderDao.getSumAmount();
		String sAmount = sumAmount.toString();
		Integer totalMoney = orderDao.getTotalMoney();
		String tMoney = totalMoney.toString();		
		sumAmountTextField.setText(sAmount);
		sumMoneyTextField.setText(tMoney);
	}
	
	
	// 显示客户类别
	private void setCustomerType() {
		OrderDao orderDao = new OrderDao();
		customerTypeList = orderDao.getCustomerType(new CustomerType());
		for (CustomerType customerType : customerTypeList) {
			customerTypeComboBox.addItem(customerType);
		}
		orderDao.closeDao();
	}
}
