

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Addcustomer extends JFrame {
	private static final long serialVersionUID = 1L;
	static Addcustomer frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Addcustomer();
					frame.setTitle("customer Info.");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Addcustomer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddcustomer = new JLabel("Add customer");
		lblAddcustomer.setForeground(Color.GRAY);
		lblAddcustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblid = new JLabel("customer id:");
		
		JLabel lblname = new JLabel("customer name :");
		
		JLabel lblcontact= new JLabel("phone number :");
		
		JLabel lbladdress = new JLabel("address :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("Submit");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String cid=textField.getText();
			String cname=textField_1.getText();
			//int phnno=Integer.parseInt(textField_2.getText());
			boolean check = Pattern.matches("[6-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]", textField_2.getText());
			if(check) {
			String phnno = textField_2.getText();
			String address=textField_3.getText();
			if(customerdetails.checkcustomer(cid)) {
				JOptionPane.showMessageDialog(Addcustomer.this,"Duplication of customer id is not allowed\nInsertion not allowed");
			}
			else {
			  int i=customerdetails.insertcustomer(cid,cname,phnno,address);
			    if(i>0){
				JOptionPane.showMessageDialog(Addcustomer.this,"Added customer successfully!");
			   }else{
				JOptionPane.showMessageDialog(Addcustomer.this,"Sorry, unable to add customer");
			   }
			}
			}
			else {
				JOptionPane.showMessageDialog(Addcustomer.this,"Format Error");
				
			}
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				customer.main(new String[]{});
				frame.dispose();
			}
			
			});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAddcustomer))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblid)
								.addComponent(lblname)
								.addComponent(lblcontact)
								.addComponent(lbladdress)
								)
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(btnAdd)
					.addGap(30)
					.addComponent(btnBack)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddcustomer)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblname)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblcontact)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbladdress)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					
	)	);
		contentPane.setLayout(gl_contentPane);
	}



}
