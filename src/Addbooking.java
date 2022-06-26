

	


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

	public class Addbooking extends JFrame {
		private static final long serialVersionUID = 1L;
		static Addbooking frame;
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
						frame = new Addbooking();
						frame.setTitle("booking Info.");
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
		public Addbooking() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 404);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			JLabel lblAddbooking = new JLabel("Add booking");
			lblAddbooking.setForeground(Color.GRAY);
			lblAddbooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
			
			JLabel lblid = new JLabel("booking id:");
			
			JLabel lblname = new JLabel("customer id :");
			
			JLabel lblcontact= new JLabel("vehicle id :");
			
			JLabel lbladdress = new JLabel("noofdays :");
			
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
				String bookid=textField.getText();
				String cid=textField_1.getText();
				int noofdays=Integer.parseInt(textField_3.getText());
				String vid=textField_2.getText();
				if(bookingdetails.checkbooking(cid)) {
					JOptionPane.showMessageDialog(Addbooking.this,"Duplication of booking id is not allowed\nInsertion not allowed");
				}
				else {
				int i=bookingdetails.insertbooking(bookid,cid,vid,noofdays);
				if(i>0){
					JOptionPane.showMessageDialog(Addbooking.this,"Added booking successfully!");
				}else{
					JOptionPane.showMessageDialog(Addbooking.this,"Sorry, unable to add booking");
				}
				}
				}
			});
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e1) {
					booking.main(new String[]{});
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
								.addComponent(lblAddbooking))
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
						.addComponent(lblAddbooking)
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