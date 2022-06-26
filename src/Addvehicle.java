
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addvehicle extends JFrame {
	private static final long serialVersionUID = 1L;
	static Addvehicle frame;
	private JPanel contentPane;
	private JTextField TextField;
	private JTextField TextField_1;
	private JTextField TextField_2;
	private JTextField TextField_3;
	private JTextField TextField_4;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Addvehicle();
					frame.setTitle("vehicle Info.");
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
	public Addvehicle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 95, 700, 550);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        TextField = new JTextField();
        TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField.setBounds(290, 125, 326, 40);
        contentPane.add(TextField);
        TextField.setColumns(10);

        TextField_1 = new JTextField();
        TextField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_1.setBounds(290, 175, 326, 40);
        contentPane.add(TextField_1);
        TextField_1.setColumns(10);
        
        TextField_2 = new JTextField();
        TextField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_2.setBounds(290, 225, 326, 40);
        contentPane.add(TextField_2);
        TextField_2.setColumns(10);
        
        TextField_3 = new JTextField();
        TextField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_3.setBounds(290, 275, 326, 40);
        contentPane.add(TextField_3);
        TextField_3.setColumns(10);
        
        TextField_4 = new JTextField();
        TextField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        TextField_4.setBounds(290, 325, 326, 40);
        contentPane.add(TextField_4);
        TextField_4.setColumns(10);

        
        TextField.setText("");
		TextField_1.setText("");
		TextField_2.setText("");
		TextField_3.setText("");
		TextField_4.setText("");
		JLabel lblAddvehicles = new JLabel("Add vehicles");
        lblAddvehicles.setFont(new Font("Courier New", Font.BOLD, 36));
        lblAddvehicles.setForeground(Color.BLACK);
        lblAddvehicles.setBounds(150, 27, 300, 40);
        contentPane.add(lblAddvehicles);
		JLabel lblbookid = new JLabel("vehicle ID :");
        lblbookid.setFont(new Font("Big Calson", Font.PLAIN, 18));
        lblbookid.setBounds(45, 125, 326, 40);
        contentPane.add(lblbookid);
		
		JLabel lblName = new JLabel("vehicle name :");
        lblName.setFont(new Font("Freestyle Script", Font.PLAIN, 18));
        lblName.setBounds(45, 175, 326, 40);
        contentPane.add(lblName);
        
		JLabel lblAuthor = new JLabel("meter reading :");
        lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAuthor.setBounds(45, 225, 326, 40);
        contentPane.add(lblAuthor);
        
        JLabel lblName2 = new JLabel("availability:");
        lblName2.setFont(new Font("Freestyle Script", Font.PLAIN, 18));
        lblName2.setBounds(45, 275, 326, 40);
        contentPane.add(lblName2);
        
		JLabel lblAuthor3 = new JLabel("costpermile :");
        lblAuthor3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblAuthor3.setBounds(45, 325, 326, 40);
        contentPane.add(lblAuthor3);
        
		JButton btnAddvehicles = new JButton("Submit");
		btnAddvehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String vid=TextField.getText();
			String vname=TextField_1.getText();
			Float meter=Float.parseFloat(TextField_2.getText());
			String avail=TextField_3.getText();
			int cost=Integer.parseInt(TextField_4.getText());
			if(vid.equals("") || vname.equals("")|| avail.equals("") ) {
				JOptionPane.showMessageDialog(Addvehicle.this,"Unknown Error !!!\n TextField Cannot be Blank");
			}
			else {
			if(vehicledetails.checkavailability(vid)) {
				JOptionPane.showMessageDialog(Addvehicle.this,"Book with Same Book ID is present already\nInserton Failed !!!");
			}
			else {
			int i=vehicledetails.insertvehicle(vid, vname,meter,avail,cost );
			if(i>0){
				JOptionPane.showMessageDialog(Addvehicle.this,"Books added successfully!");
			}else{
				JOptionPane.showMessageDialog(Addvehicle.this,"Unknown Error !!!\nInsertion not completed");
			}
			}
			}
			}
		});
		btnAddvehicles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddvehicles.setBackground(new Color(0,0, 0));
        btnAddvehicles.setBounds(300, 400, 130, 50);
        contentPane.add(btnAddvehicles);

		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				vehicle.main(new String[]{});
				frame.dispose();
			}
			});
		  btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBack.setBackground(new Color(240, 240, 240));
	        btnBack.setBounds(450, 400, 130, 50);
	        contentPane.add(btnBack);
	}

}
