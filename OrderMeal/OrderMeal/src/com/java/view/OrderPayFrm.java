package com.java.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

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
import com.java.model.Meal;
import com.java.model.MealClass;
import com.java.model.OrderMid;

public class OrderPayFrm extends JInternalFrame {
	
	private JPanel contentPane;
	private JTable mealListTable;
	private List<MealClass> mealClassList;
	private JLabel mealPriceTextField;

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
		setBounds(120, 100, 800, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(70)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(204, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(207, Short.MAX_VALUE))
		);
		mealListTable = new JTable();

		mealListTable.setFont(new Font("宋体", Font.PLAIN, 16));
		mealListTable.setRowHeight(22);
		mealListTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"编号","菜品名称","所属类别","单价","数量"
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
//		setMealClassInfo();
//		setTable(new Meal());
	}

//	// 显示所有
//	public void setTable(Meal meal) {
//		DefaultTableModel dft = (DefaultTableModel) mealListTable.getModel();
//		dft.setRowCount(0);
//		MealDao mealDao = new MealDao();
//		List<Meal> mealList = mealDao.getMealList(meal);
//		for (Meal m : mealList) {
//			Vector vector = new Vector();
//			vector.add(m.getId());
//			vector.add(m.getMealName());
//			vector.add(getClassNameById(m.getClassId()));
//			vector.add(m.getPrice());
//			vector.add(m.getMealInfo());
//			dft.addRow(vector);
//		}
//		mealDao.closeDao();
//	}
	
//	// 显示菜品类别
//	private void setMealClassInfo() {
//		ClassDao classDao = new ClassDao();
//		mealClassList = classDao.getClassList(new MealClass());
//		for (MealClass mClass : mealClassList) {
//			mealClassComboBox.addItem(mClass);
//			editMealClassComboBox.addItem(mClass);
//		}
//		classDao.closeDao();
//	}
	
	// 通过类别id获取类别名称
//	private String getClassNameById(int id){
//		for (MealClass mc : mealClassList) {
//			if(mc.getId() == id)return mc.getName();
//		}
//		return "";
//	}

}
