package com.java.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.ClassDao;
import com.java.model.MealClass;
import com.java.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MealClassAddFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField classNameTextField;
	private JTextArea classInfoTextArea;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MealClassAddFrm frame = new MealClassAddFrm();
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
	public MealClassAddFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("添加菜品类别");
		
		
		// 设置窗体大小
		int windowsWedth = 525;
		int windowsHeight = 351;
		
		// 得到显示器屏幕的宽高
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		//设置窗体在显示器居中显示
		this.setBounds(300, 200, windowsWedth, windowsHeight);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("类别名称：");
		lblNewLabel.setIcon(new ImageIcon(MealClassAddFrm.class.getResource("/images/classname.png")));
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("类别信息：");
		lblNewLabel_1.setIcon(new ImageIcon(MealClassAddFrm.class.getResource("/images/classinfo.png")));
		
		JButton submitButton = new JButton("提交");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitMealClass(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(MealClassAddFrm.class.getResource("/images/confirm.png")));
		
		JButton resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(MealClassAddFrm.class.getResource("/images/reset.png")));
		
		classInfoTextArea = new JTextArea();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(classNameTextField)
								.addComponent(classInfoTextArea, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(submitButton)
							.addGap(83)
							.addComponent(resetButton)))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(classInfoTextArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void submitMealClass(ActionEvent ae) {
		// 提交
		String className = classNameTextField.getText().toString();
		String classInfo = classInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(className)){
			JOptionPane.showMessageDialog(this, "菜品类别名称不能为空！");
			return;
		}
		MealClass mcl = new MealClass();
		mcl.setName(className);
		mcl.setInfo(classInfo);
		ClassDao classDao = new ClassDao();
		if(classDao.addClass(mcl)){
			JOptionPane.showMessageDialog(this, "菜品类别添加成功");
		}else{
			JOptionPane.showMessageDialog(this, "菜品类别添加失败");
		}
		classDao.closeDao();
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// 重置
		classNameTextField.setText("");
		classInfoTextArea.setText("");
	}
}
