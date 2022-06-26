


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
	import java.awt.event.ActionEvent;
	import javax.swing.LayoutStyle.ComponentPlacement;

	public class Addinvoice extends JFrame {
		private static final long serialVersionUID = 1L;
		static Addinvoice frame;
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
						frame = new Addinvoice();
						frame.setTitle("invoice Info.");
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
		public Addinvoice() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 404);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			JLabel lblAddinvoice = new JLabel("Add invoice ");
			lblAddinvoice.setForeground(Color.GRAY);
			lblAddinvoice.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			JLabel lblname = new JLabel("bill id:");
			
			JLabel lblrollno = new JLabel("bill date:");
			
			JLabel lblbranch = new JLabel("totalamount :");
			
			JLabel lblcourse = new JLabel("bookid :");
			
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
				String billid=textField.getText();
				String billdate=textField_1.getText();
				int totalamount=Integer.parseInt(textField_2.getText());
				String bookid=textField_3.getText();
				if(invoicedetails.checkinvoice(billid)) {
					JOptionPane.showMessageDialog(Addinvoice.this,"Duplication of Roll Number not allowed\nInsertion not allowed");
				}
				else {
				int i=invoicedetails.insertinvoice(billid,billdate,totalamount,bookid);
				if(i>0){
					JOptionPane.showMessageDialog(Addinvoice.this,"Added Student successfully!");
				}else{
					JOptionPane.showMessageDialog(Addinvoice.this,"Sorry, unable to add Student");
				}
				}
				}
			});
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					invoice.main(new String[]{});
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
								.addComponent(lblAddinvoice))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblname)
									.addComponent(lblrollno)
									.addComponent(lblbranch)
									.addComponent(lblcourse)
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
						.addComponent(lblAddinvoice)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblname)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblrollno)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblbranch)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblcourse)
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



