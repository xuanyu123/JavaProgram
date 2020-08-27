package com.java.view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.java.dao.ClassDao;
import com.java.model.MealClass;
import com.java.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Component;

public class MealClassManageFrm extends JInternalFrame {

	private JPanel contentPane;
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MealClassManageFrm frame = new MealClassManageFrm();
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
	public MealClassManageFrm() {
		setIconifiable(true);
		setClosable(true);
		setTitle("菜品类别管理");
		
		setBounds(120, 100, 932, 543);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("类别名称：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon(MealClassManageFrm.class.getResource("/images/classname.png")));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("查询");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 18));
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MealClass mealClass = new MealClass();
				mealClass.setName(searchClassNameTextField.getText().toString());
				setTable(mealClass);
			}
		});
		searchButton.setIcon(new ImageIcon(MealClassManageFrm.class.getResource("/images/search.png")));
		
		JLabel lblNewLabel_1 = new JLabel("类别名称：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setIcon(new ImageIcon(MealClassManageFrm.class.getResource("/images/classname.png")));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setFont(new Font("宋体", Font.PLAIN, 18));
		editClassNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("类别介绍：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setIcon(new ImageIcon(MealClassManageFrm.class.getResource("/images/classinfo.png")));
		
		editClassInfoTextArea = new JTextArea();
		editClassInfoTextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		// 修改按钮
		JButton submitChangeButton = new JButton("修改");
		submitChangeButton.setFont(new Font("宋体", Font.PLAIN, 18));
		// 给修改按钮绑定行为事件
		submitChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitChangeAct(ae);
			}
		});
		submitChangeButton.setIcon(new ImageIcon(MealClassManageFrm.class.getResource("/images/confirm.png")));
		
		JButton submitDeleteButton = new JButton("删除");
		submitDeleteButton.setFont(new Font("宋体", Font.PLAIN, 18));
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitDeleteAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(MealClassManageFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(159, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(119)
					.addComponent(searchButton)
					.addGap(147))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(18)
									.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(18)
									.addComponent(editClassNameTextField)))
							.addPreferredGap(ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(submitDeleteButton, Alignment.TRAILING)
								.addComponent(submitChangeButton, Alignment.TRAILING))
							.addGap(69)))
					.addGap(72))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(searchButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(submitChangeButton)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(editClassInfoTextArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(submitDeleteButton)))
					.addGap(55))
		);
		
		classListTable = new JTable();
		// 添加鼠标行为监听
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setFont(new Font("宋体", Font.PLAIN, 16));
		classListTable.setRowHeight(22);
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
					"类别编号","类别名称" , "类别介绍"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(316);
		scrollPane.setViewportView(classListTable);
		contentPane.setLayout(gl_contentPane);
		setTable(new MealClass());
	}
	
	// 删除
	protected void submitDeleteAct(ActionEvent ae) {
		if(JOptionPane.showConfirmDialog(this, "您确定要删除该条数据吗？") != JOptionPane.OK_OPTION){
			return;
		}
		int index = classListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassDao classDao = new ClassDao();
		if(classDao.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败");
		}
		classDao.closeDao();
		setTable(new MealClass());
		
	}

	// 提交修改
	protected void submitChangeAct(ActionEvent ae) {
		ClassDao classDao = new ClassDao();
		int index = classListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName = editClassNameTextField.getText().toString();
		String editClassInfo = editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)){
			JOptionPane.showMessageDialog(this, "请填写要修改的名称");
			return;
		}
		if(className.equals(editClassName) && classInfo.equals(editClassInfo)){
			JOptionPane.showMessageDialog(this, "您还没有做出任何修改");
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		MealClass  mc = new MealClass();
		mc.setId(id);
		mc.setName(editClassName);
		mc.setInfo(editClassInfo);
		if(classDao.update(mc)){
			JOptionPane.showMessageDialog(this, "修改成功");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败");
		}
		classDao.closeDao();
		setTable(new MealClass());
	}
	
	// 选中当前行，返回信息到修改框
	protected void selectedTableRow(MouseEvent me) {
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
	}
	// 显示所有
	public void setTable(MealClass mealClass) {
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		dft.setRowCount(0);
		ClassDao classDao = new ClassDao();
		List<MealClass> classList = classDao.getClassList(mealClass);
		for (MealClass mClass : classList) {
			Vector vector = new Vector();
			vector.add(mClass.getId());
			vector.add(mClass.getName());
			vector.add(mClass.getInfo());
			dft.addRow(vector);
		}
		classDao.closeDao();
	}
}
