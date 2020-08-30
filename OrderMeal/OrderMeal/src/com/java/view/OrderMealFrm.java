package com.java.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;
import javax.swing.table.DefaultTableModel;

import com.java.dao.ClassDao;
import com.java.dao.MealDao;
import com.java.dao.OrderDao;
import com.java.model.Meal;
import com.java.model.MealClass;
import com.java.model.OrderMid;
import com.java.util.StringUtil;

public class OrderMealFrm extends JInternalFrame {
	
	private JPanel contentPane;
	private JTextField mealNameTextField;
	private JTable mealListTable;
	private JTextField editMealNameTextField;
	private JTextField editMealPriceTextField;
	private JTextArea editMealInfoTextArea;
	private JComboBox mealClassComboBox;
	private JComboBox editMealClassComboBox;
	private List<MealClass> mealClassList;
	private JLabel mealPriceTextField;
	private JTextField editAmountTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					OrderMealFrm frame = new OrderMealFrm();
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
	public OrderMealFrm() {
		setTitle("点餐");
		setIconifiable(true);
		setClosable(true);
		setBounds(120, 100, 932, 573);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("菜品名称：");
		lblNewLabel.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/order3.png")));
		
		mealNameTextField = new JTextField();
		mealNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("所属类别：");
		lblNewLabel_1.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/classname.png")));
		
		mealClassComboBox = new JComboBox();
		
		JButton searchButton = new JButton("查询");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchMeal(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/search.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("菜品名称：");
		lblNewLabel_2.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/order3.png")));
		
		editMealNameTextField = new JTextField();
		editMealNameTextField.setEditable(false);
		editMealNameTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("所属类别：");
		lblNewLabel_3.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/classname.png")));
		
		editMealClassComboBox = new JComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("菜品价格：");
		lblNewLabel_4.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/mealPrice.png")));
		
		editMealPriceTextField = new JTextField();
		editMealPriceTextField.setEditable(false);
		editMealPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("菜品介绍：");
		lblNewLabel_5.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/classinfo.png")));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton btnNewButton = new JButton("重置");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetAll(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/reset.png")));
		
		JButton btnNewButton_1 = new JButton("添加到订单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOrder(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(OrderMealFrm.class.getResource("/images/classadd.png")));
		
		JButton btnNewButton_2 = new JButton("订单结算");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				closeThis();
				OrderPayFrm orderPayFrm = new OrderPayFrm();
				orderPayFrm.setVisible(true);
				MainFrm.desktopPane.add(orderPayFrm);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(OrderMealFrm.class.getResource("/images/seeOrder.png")));
		
		JLabel lblNewLabel_6 = new JLabel("数量：");
		lblNewLabel_6.setIcon(new ImageIcon(OrderMealFrm.class.getResource("/images/mealInfo.png")));
		
		editAmountTextField = new JTextField();
		editAmountTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(74)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_6)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(editAmountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editMealNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_4)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(editMealPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(48)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addGap(18)
											.addComponent(editMealClassComboBox, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel_5)
											.addGap(18)
											.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)))
									.addGap(43)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_2)
										.addComponent(btnNewButton_1))))
							.addGap(11))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mealNameTextField, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(mealClassComboBox, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton)
							.addGap(18)
							.addComponent(btnNewButton)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(mealNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(mealClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(editMealNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(editMealClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(editMealPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(editAmountTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_6)))
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(btnNewButton_2)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		editMealInfoTextArea = new JTextArea();
		editMealInfoTextArea.setEditable(false);
		editMealInfoTextArea.setWrapStyleWord(true);
		editMealInfoTextArea.setLineWrap(true);
		scrollPane_1.setViewportView(editMealInfoTextArea);
		mealListTable = new JTable();
		// 鼠标点击事件，选中行信息返回到修改栏
		mealListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});

		mealListTable.setFont(new Font("宋体", Font.PLAIN, 16));
		mealListTable.setRowHeight(22);
		mealListTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"菜品编号","菜品名称" ,"所属类别","菜品价格","菜品介绍"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		mealListTable.getColumnModel().getColumn(4).setPreferredWidth(316);
		scrollPane.setViewportView(mealListTable);
		contentPane.setLayout(groupLayout);
		setMealClassInfo();
		setTable(new Meal());
	}

	protected void closeThis() {
		this.setVisible(false);
	}

	// 将选中菜品添加到订单中
	protected void addOrder(ActionEvent e) {
		int row = mealListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要添加的数据");
			return;
		}
		
		String mealName = editMealNameTextField.getText().toString();
		String mealPrice = editMealPriceTextField.getText().toString();
		Float price = Float.parseFloat(mealPrice);
		String amountString = editAmountTextField.getText().toString();
		Integer amount = null;
		if (!StringUtil.isEmpty(amountString)) {
			amount = Integer.parseInt(amountString);
		}
		Float totalMoney = (Float) (amount * price);
		OrderMid orderMid = new OrderMid();
		orderMid.setOrderName(mealName);
		orderMid.setOrderPrice(price);
		orderMid.setOrderAmount(amount);
		orderMid.setTotalMoney(totalMoney);
		
		MealClass mc = (MealClass)editMealClassComboBox.getSelectedItem();
		orderMid.setClassId(mc.getId());

		OrderDao orderDao = new OrderDao();
		if(orderDao.addOrderMid(orderMid)){
			JOptionPane.showMessageDialog(this, "添加成功");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败");
		}
		orderDao.closeDao();
	}


	// 选中行信息返回到修改框
	protected void selectedTableRow(MouseEvent e) {
		DefaultTableModel dft = (DefaultTableModel) mealListTable.getModel();
		editMealNameTextField.setText(dft.getValueAt(mealListTable.getSelectedRow(), 1).toString());
		editMealPriceTextField.setText(dft.getValueAt(mealListTable.getSelectedRow(), 3).toString());
		editMealInfoTextArea.setText(dft.getValueAt(mealListTable.getSelectedRow(), 4).toString());
		String className = dft.getValueAt(mealListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<editMealClassComboBox.getItemCount();i++){
			MealClass mc = (MealClass)editMealClassComboBox.getItemAt(i);
			if(className.equals(mc.getName())){
				editMealClassComboBox.setSelectedIndex(i);
			}
		}
		editAmountTextField.setText("1");
	}

	// 清空查询条件，显示所有
	protected void reSetAll(ActionEvent e) {
		mealNameTextField.setText("");
		mealClassComboBox.setSelectedIndex(0);
		setTable(new Meal());
	}

	// 查询功能
	protected void searchMeal(ActionEvent ae) {
		Meal meal = new Meal();
		meal.setMealName(mealNameTextField.getText().toString());
		MealClass mc = (MealClass) mealClassComboBox.getSelectedItem();
		meal.setClassId(mc.getId());
		setTable(meal);
	}

	// 显示所有
	public void setTable(Meal meal) {
		DefaultTableModel dft = (DefaultTableModel) mealListTable.getModel();
		dft.setRowCount(0);
		MealDao mealDao = new MealDao();
		List<Meal> mealList = mealDao.getMealList(meal);
		for (Meal m : mealList) {
			Vector vector = new Vector();
			vector.add(m.getId());
			vector.add(m.getMealName());
			vector.add(getClassNameById(m.getClassId()));
			vector.add(m.getPrice());
			vector.add(m.getMealInfo());
			dft.addRow(vector);
		}
		mealDao.closeDao();
	}
	
	// 显示菜品类别
	private void setMealClassInfo() {
		ClassDao classDao = new ClassDao();
		mealClassList = classDao.getClassList(new MealClass());
		for (MealClass mClass : mealClassList) {
			mealClassComboBox.addItem(mClass);
			editMealClassComboBox.addItem(mClass);
		}
		classDao.closeDao();
	}
	
	// 通过类别id获取类别名称
	private String getClassNameById(int id){
		for (MealClass mc : mealClassList) {
			if(mc.getId() == id)return mc.getName();
		}
		return "";
	}
}
