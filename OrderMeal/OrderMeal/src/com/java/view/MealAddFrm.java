package com.java.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.java.dao.ClassDao;
import com.java.dao.MealDao;
import com.java.model.Meal;
import com.java.model.MealClass;
import com.java.util.StringUtil;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MealAddFrm extends JInternalFrame {
	private JTextField mealNameTextField;
	private JTextField mealPriceTextField;
	private JTextArea mealInfoTextArea;
	private JComboBox mealClassComboBox;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MealAddFrm frame = new MealAddFrm();
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
	public MealAddFrm() {
		setIconifiable(true);
		setClosable(true);
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 17));
		setTitle("添加菜品");
		
		setBounds(300, 130, 560, 488);
		
		JLabel lblNewLabel = new JLabel("菜品名称：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon(MealAddFrm.class.getResource("/images/order3.png")));
		
		mealNameTextField = new JTextField();
		mealNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("所属类别：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNewLabel_1.setIcon(new ImageIcon(MealAddFrm.class.getResource("/images/classlist.png")));
		
		JLabel lblNewLabel_2 = new JLabel("菜品价格：");
		lblNewLabel_2.setIcon(new ImageIcon(MealAddFrm.class.getResource("/images/mealPrice.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 17));
		
		mealClassComboBox = new JComboBox();
		
		mealPriceTextField = new JTextField();
		mealPriceTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("菜品描述：");
		lblNewLabel_3.setIcon(new ImageIcon(MealAddFrm.class.getResource("/images/mealInfo.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JButton submitMealButton = new JButton("提交");
		submitMealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addMealAct(ae);
			}
		});
		submitMealButton.setIcon(new ImageIcon(MealAddFrm.class.getResource("/images/confirm.png")));
		submitMealButton.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JButton deleteMealButton = new JButton("重置");
		deleteMealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		deleteMealButton.setIcon(new ImageIcon(MealAddFrm.class.getResource("/images/reset.png")));
		deleteMealButton.setFont(new Font("宋体", Font.PLAIN, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(149)
					.addComponent(submitMealButton)
					.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
					.addComponent(deleteMealButton)
					.addGap(102))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane)
						.addComponent(mealPriceTextField)
						.addComponent(mealClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(mealNameTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
					.addContainerGap(80, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(mealNameTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(mealClassComboBox, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(mealPriceTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitMealButton)
						.addComponent(deleteMealButton))
					.addContainerGap())
		);
		
		mealInfoTextArea = new JTextArea();
		scrollPane.setViewportView(mealInfoTextArea);
		mealInfoTextArea.setWrapStyleWord(true);
		mealInfoTextArea.setLineWrap(true);
		getContentPane().setLayout(groupLayout);
		setMealClassInfo();
	}

	// 添加菜品信息
	protected void addMealAct(ActionEvent ae) {
		String mealName = mealNameTextField.getText().toString();
		String mealInfo = mealInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(mealName)){
			JOptionPane.showMessageDialog(this, "菜品名称不能为空！");
			return;
		}
		MealClass mc = (MealClass)mealClassComboBox.getSelectedItem();
		String priceString = mealPriceTextField.getText().toString();
		Float price = Float.parseFloat(priceString);
		Meal meal = new Meal();
		meal.setMealName(mealName);
		meal.setClassId(mc.getId());
		meal.setPrice(price);
		meal.setMealInfo(mealInfo);
		
		MealDao mealDao = new MealDao();
		if(mealDao.addMeal(meal)){
			JOptionPane.showMessageDialog(this, "添加成功");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败");
		}
		resetValue(ae);
	}

	// 重置
	protected void resetValue(ActionEvent ae) {
		mealNameTextField.setText("");
		mealPriceTextField.setText("");
		mealInfoTextArea.setText("");
		mealClassComboBox.setSelectedIndex(0);
	}
	
	// 显示菜品类别
	private void setMealClassInfo() {
		ClassDao classDao = new ClassDao();
		List<MealClass> classList = classDao.getClassList(new MealClass());
		for (MealClass mClass : classList) {
			mealClassComboBox.addItem(mClass);
		}
		classDao.closeDao();
	}
}
