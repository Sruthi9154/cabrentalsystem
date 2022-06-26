
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	static Menu frame;
	private JPanel contentPane;
	static String idd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Menu();
					frame.setTitle("cab rental system");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     public static void id(String id) {
    	idd=id;
     }
	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibrarianSection = new JLabel("CAB RENTAL SYSTEM ");
		lblLibrarianSection.setFont(new Font("COURIER NEW", Font.BOLD , 40));
		
		JButton btnBInfo = new JButton("customer Info");
		btnBInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			customer.main(new String[]{});
			frame.dispose();
			}
		});
		btnBInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnSInfo = new JButton("vehicle Info");
		btnSInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vehicle.main(new String[]{});
				frame.dispose();
			}
		});
		btnSInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnIssueBook = new JButton("booking");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				booking.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		
		JButton btnReturnBook = new JButton("invoice");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnLogout = new JButton("close");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(lblLibrarianSection)
					.addGap(54))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSInfo, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBInfo, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLibrarianSection)
					.addGap(18)
					.addComponent(btnBInfo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSInfo, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
