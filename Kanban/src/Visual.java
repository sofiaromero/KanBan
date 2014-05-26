import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Visual extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private JTextField textFieldCategory;
	private JTextField textFieldDescription;
	private JTextField textFieldOwner;
	private JTextField textFieldDueDate;
	private JLabel lblCategory;
	private JComboBox comboBoxState;
	private JComboBox comboBoxPriority;
	private JLabel lblDescription;
	private JLabel lblState;
	private JLabel lblPriority;
	private JLabel lblOwner;
	private JLabel lblDueDate;
	private JLabel lblBackpack;
	private JButton btnAddToBackpack;
	private JButton btnCancel;
	
	private class TaskAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source instanceof JButton){
				if (btnAddToBackpack == source){
					try{
						verify();
						if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Do you want to add this task?", "Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE)){
							if (save()){
								JOptionPane.showMessageDialog(null,"Task added successfully!");
								clean();
							}
						}
					} catch (EmptyComponentException ex){
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
					} catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		}
	}
	
	private boolean save(){
		Task task = new Task();
  		task.setTitle(textFieldTitle.getText());
  		task.setDescription(textFieldDescription.getText());
  		//task.setState(comboBoxState.getItemAt(comboBoxState.getSelectedIndex()));
  		task.setCategory((textFieldCategory.getText()));
  		//task.setPriority(Short.parseShort(textFieldPriority.getText()));
  		task.setOwner(textFieldOwner.getText());
  		SimpleDateFormat formatter = new SimpleDateFormat(
  				"EEE MMM d HH:mm:ss zzz yyyy");
  		//task.setDueDate(formatter.parse(textFieldDueDate.getText()));
		task.setDueDate(textFieldDueDate.getText());
  		task.setCreateDate(new Date());
  
  		return Program.dashboard.add(task);
  	}
	
	private void isEmpty(String message, JTextField text) throws EmptyComponentException{
			if("".equals(text.getText().trim())){
				throw new EmptyComponentException(message,text);
			}
	}
	
	private void verify() throws Exception{
		isEmpty("Title is empty...", textFieldTitle);
		isEmpty("Description is empty...", textFieldDescription);
		isEmpty("Category is empty...",textFieldCategory);
		isEmpty("Owner field is empty", textFieldOwner);
		isEmpty("Due date field is empty", textFieldDueDate);
	}
	
 	private void clean() {
  		textFieldTitle.setText("");
  		textFieldDescription.setText("");
  		textFieldCategory.setText("");
  		textFieldOwner.setText("");
  		textFieldDueDate.setText(new Date().toString());
  	}
	
	
	public Visual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 98, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblBackpack = new JLabel("BACKPACK");
		lblBackpack.setFont(new Font("Buxton Sketch", Font.BOLD, 26));
		GridBagConstraints gbc_lblBackpack = new GridBagConstraints();
		gbc_lblBackpack.gridwidth = 4;
		gbc_lblBackpack.insets = new Insets(0, 0, 5, 5);
		gbc_lblBackpack.gridx = 1;
		gbc_lblBackpack.gridy = 0;
		contentPane.add(lblBackpack, gbc_lblBackpack);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		contentPane.add(lblTitle, gbc_lblTitle);

		textFieldTitle = new JTextField();
		textFieldTitle.setText("");
		GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
		gbc_textFieldTitle.gridwidth = 4;
		gbc_textFieldTitle.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitle.gridx = 1;
		gbc_textFieldTitle.gridy = 1;
		contentPane.add(textFieldTitle, gbc_textFieldTitle);
		textFieldTitle.setColumns(10);
		
		lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 2;
		contentPane.add(lblCategory, gbc_lblCategory);

		textFieldCategory = new JTextField();
		textFieldCategory.setText("");
		GridBagConstraints gbc_textFieldCategory = new GridBagConstraints();
		gbc_textFieldCategory.gridwidth = 4;
		gbc_textFieldCategory.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCategory.gridx = 1;
		gbc_textFieldCategory.gridy = 2;
		contentPane.add(textFieldCategory, gbc_textFieldCategory);
		textFieldCategory.setColumns(10);
		
		lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 3;
		contentPane.add(lblDescription, gbc_lblDescription);

		textFieldDescription = new JTextField();
		textFieldDescription.setText("");
		GridBagConstraints gbc_textFieldDescription = new GridBagConstraints();
		gbc_textFieldDescription.gridwidth = 4;
		gbc_textFieldDescription.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescription.gridx = 1;
		gbc_textFieldDescription.gridy = 3;
		contentPane.add(textFieldDescription, gbc_textFieldDescription);
		textFieldDescription.setColumns(10);
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 4;
		contentPane.add(lblState, gbc_lblState);
		
		comboBoxState = new JComboBox();
		comboBoxState.setModel(new DefaultComboBoxModel(new String[] {"...", "TO DO", "IN PROGRESS", "DONE"}));
		GridBagConstraints gbc_comboBoxState = new GridBagConstraints();
		gbc_comboBoxState.gridwidth = 4;
		gbc_comboBoxState.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxState.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxState.gridx = 1;
		gbc_comboBoxState.gridy = 4;
		contentPane.add(comboBoxState, gbc_comboBoxState);
		
		lblPriority = new JLabel("Priority");
		lblPriority.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriority.gridx = 0;
		gbc_lblPriority.gridy = 5;
		contentPane.add(lblPriority, gbc_lblPriority);
		
		comboBoxPriority = new JComboBox();
		comboBoxPriority.setModel(new DefaultComboBoxModel(new String[] {"...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_comboBoxPriority = new GridBagConstraints();
		gbc_comboBoxPriority.gridwidth = 4;
		gbc_comboBoxPriority.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPriority.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxPriority.gridx = 1;
		gbc_comboBoxPriority.gridy = 5;
		contentPane.add(comboBoxPriority, gbc_comboBoxPriority);
		
		lblOwner = new JLabel("Owner");
		lblOwner.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblOwner = new GridBagConstraints();
		gbc_lblOwner.insets = new Insets(0, 0, 5, 5);
		gbc_lblOwner.gridx = 0;
		gbc_lblOwner.gridy = 6;
		contentPane.add(lblOwner, gbc_lblOwner);

		textFieldOwner = new JTextField();
		textFieldOwner.setText("");
		GridBagConstraints gbc_textFieldOwner = new GridBagConstraints();
		gbc_textFieldOwner.gridwidth = 4;
		gbc_textFieldOwner.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldOwner.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOwner.gridx = 1;
		gbc_textFieldOwner.gridy = 6;
		contentPane.add(textFieldOwner, gbc_textFieldOwner);
		textFieldOwner.setColumns(10);
		
		lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Helvetica LT Std", Font.PLAIN, 20));
		GridBagConstraints gbc_lblDueDate = new GridBagConstraints();
		gbc_lblDueDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDueDate.gridx = 0;
		gbc_lblDueDate.gridy = 7;
		contentPane.add(lblDueDate, gbc_lblDueDate);

		textFieldDueDate = new JTextField();
		textFieldDueDate.setText("");
		GridBagConstraints gbc_textFieldDueDate = new GridBagConstraints();
		gbc_textFieldDueDate.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDueDate.gridwidth = 4;
		gbc_textFieldDueDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDueDate.gridx = 1;
		gbc_textFieldDueDate.gridy = 7;
		contentPane.add(textFieldDueDate, gbc_textFieldDueDate);
		textFieldDueDate.setColumns(10);
		
		// btnAddToBackpack
		btnAddToBackpack = new JButton("Add to Backpack!");
		
		/*	
		btnAddToBackpack.addActionListener(new ActionListener()) {		
		}*/
			
			

				

				
								
		add(btnAddToBackpack,gbc_lblBackpack);
		btnAddToBackpack.setFont(new Font("Helvetica LT Std", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAddToBackpack = new GridBagConstraints();
		gbc_btnAddToBackpack.gridwidth = 2;
		gbc_btnAddToBackpack.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddToBackpack.gridx = 1;
		gbc_btnAddToBackpack.gridy = 8;
		contentPane.add(btnAddToBackpack, gbc_btnAddToBackpack);
		
		// btnCancel
		btnCancel = new JButton("     Cancel     ");
		btnCancel.addActionListener(new CancelAction());
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(btnCancel,gbc_lblBackpack);
		btnCancel.setFont(new Font("Helvetica LT Std", Font.PLAIN, 16));
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 8;
		contentPane.add(btnCancel, gbc_btnCancel);
	}
	
	//
	private void addListener(){
		TaskAction ta = new TaskAction();
		btnAddToBackpack.addActionListener(ta);
		btnCancel.addActionListener(ta);
	}
	
	private class ConfirmationAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Deseas agregar los datos?");
				
		}
	}
	
	private class CancelAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visual frame = new Visual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//	
}