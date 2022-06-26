


	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.Font;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	public class Deletecustomer extends JFrame {
		static Deletecustomer frame;
		private JPanel contentPane;
		private JTextField textField;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new Deletecustomer();
						frame.setTitle("Delete cutsomer Info.");
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
		public Deletecustomer() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 200);
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			
			setContentPane(contentPane);
			
			JLabel lblEnterId = new JLabel("Enter customer id :");
		
			textField = new JTextField();
			textField.setColumns(10);
			
			JButton btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sid=textField.getText();
					if(sid==null||sid.trim().equals("")){
						JOptionPane.showMessageDialog(Deletecustomer.this,"id. can't be blank");
					}else{
						
						int i=customerdetails.deletecustomer(sid);
						if(i>0){
							JOptionPane.showMessageDialog(Deletecustomer.this,"customer Record deleted successfully!");
						}else{
							JOptionPane.showMessageDialog(Deletecustomer.this,"Unable to delete given customer details.!");
						}
					}
				}
			});
			btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			JButton btnNewButton = new JButton("Back");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					customer.main(new String[]{});
					frame.dispose();
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(39)
						.addComponent(lblEnterId)
					 	.addGap(57)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(107, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(100)
						.addComponent(btnDelete)
						.addGap(30)
						.addComponent(btnNewButton)
						)
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.CENTER)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(19)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEnterId))
						.addGap(33)
						.addGroup(gl_contentPane.createParallelGroup()
								.addComponent(btnDelete)
								.addComponent(btnNewButton)
			)));
			contentPane.setLayout(gl_contentPane);
		}
	}

