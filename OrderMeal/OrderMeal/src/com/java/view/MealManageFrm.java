package com.java.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.java.dao.ClassDao;
import com.java.dao.MealDao;
import com.java.model.Meal;
import com.java.model.MealClass;
import com.java.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MealManageFrm extends JInternalFrame {
	private JPanel contentPane;
	private JTextField mealNameTextField;
	private JTable mealListTable;
	private JTextField editMealNameTextField;
	private JTextField editMealPriceTextField;
	private JTextArea editMealInfoTextArea;
	private JComboBox mealClassComboBox;
	private JComboBox editMealClassComboBox;
	private List<MealClass> mealClassList;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MealManageFrm frame = new MealManageFrm();
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
	public MealManageFrm() {
		setTitle("菜品管理");
		setIconifiable(true);
		setClosable(true);
		setBounds(120, 100, 932, 543);
		
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
		editMealNameTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("所属类别：");
		lblNewLabel_3.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/classname.png")));
		
		editMealClassComboBox = new JComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("菜品价格：");
		lblNewLabel_4.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/mealPrice.png")));
		
		editMealPriceTextField = new JTextField();
		editMealPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("菜品介绍：");
		lblNewLabel_5.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/classinfo.png")));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton editConfirmButton = new JButton("修改");
		editConfirmButton.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/confirm.png")));
		editConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitChange(e);
			}
		});
		
		JButton editDeleteButton = new JButton("删除");
		editDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMeal(e);
			}
		});
		editDeleteButton.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/delete.png")));
		
		JButton btnNewButton = new JButton("重置");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetAll(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(MealManageFrm.class.getResource("/images/reset.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
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
							.addComponent(btnNewButton))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 757, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
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
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(editConfirmButton)
								.addComponent(editDeleteButton))
							.addPreferredGap(ComponentPlacement.RELATED, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(67))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(mealNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(mealClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(editMealNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(editMealClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editConfirmButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_4)
							.addComponent(editMealPriceTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(editDeleteButton))
					.addGap(32))
		);
		
		editMealInfoTextArea = new JTextArea();
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
				false, false, false
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
	
	// 删除选中数据
	protected void deleteMeal(ActionEvent e) {

		int row = mealListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定要删除该条数据吗？") != JOptionPane.OK_OPTION){
			return;
		}
		MealDao mealDao = new MealDao();
		if(mealDao.delete(Integer.parseInt(mealListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败");
		}
		mealDao.closeDao();
		setTable(new Meal());
		
	}

	// 修改菜品信息
	protected void submitChange(ActionEvent e) {
		int row = mealListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据");
			return;
		}
		
		String mealName = editMealNameTextField.getText().toString();
		String mealPrice = editMealPriceTextField.getText().toString();
		Float price = Float.parseFloat(mealPrice);
		String mealInfo = editMealInfoTextArea.getText().toString();
		
		if(StringUtil.isEmpty(mealName)){
			JOptionPane.showMessageDialog(this, "请填写要修改的名称");
			return;
		}
		if(StringUtil.isEmpty(mealPrice)){
			JOptionPane.showMessageDialog(this, "请填写要修改的价格");
			return;
		}
		
		Meal meal = new Meal();
		meal.setMealName(mealName);
		meal.setPrice(price);
		meal.setMealInfo(mealInfo);
		
		MealClass mc = (MealClass)editMealClassComboBox.getSelectedItem();
		meal.setClassId(mc.getId());
		meal.setId(Integer.parseInt(mealListTable.getValueAt(row, 0).toString()));

		MealDao mealDao = new MealDao();
		if(mealDao.update(meal)){
			JOptionPane.showMessageDialog(this, "修改成功");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败");
		}
		mealDao.closeDao();
		setTable(new Meal());
		
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
