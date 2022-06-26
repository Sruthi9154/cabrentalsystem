
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

public class vehicle extends JFrame {
	private static final long serialVersionUID = 1L;
	static vehicle frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new vehicle();
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
	public vehicle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSection = new JLabel("vehicles Information");
		lblSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnSAdd = new JButton("Add vehicle");
		btnSAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Addvehicle.main(new String[]{});
			frame.dispose();
			}
		});
		btnSAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnSUpdate = new JButton("Modify vehicle Details");
		btnSUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updatevehicle.main(new String[]{});
				frame.dispose();
			}
		});
		btnSUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnSDelete = new JButton("Delete vehicle");
		btnSDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			deletevehicle.main(new String[]{});
				frame.dispose();
			}
		});
		btnSDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnView = new JButton("View All vehicles");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewvehicle.main(new String[]{});
				
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(81, Short.MAX_VALUE)
					.addComponent(lblSection)
					.addGap(54))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(132)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnView, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSDelete, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSUpdate, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSAdd, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSection)
					.addGap(18)
					.addComponent(btnSAdd, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSUpdate, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnView, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
