
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class updatevehicle extends JFrame {
	private static final long serialVersionUID = 1L;
	static updatevehicle frame;
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
					frame = new updatevehicle();
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
	public updatevehicle() {
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
		JLabel lblupdatevehicles = new JLabel("Modify Details");
        lblupdatevehicles.setFont(new Font("Courier New", Font.BOLD, 36));
        lblupdatevehicles.setForeground(Color.BLACK);
        lblupdatevehicles.setBounds(150, 27, 400, 40);
        contentPane.add(lblupdatevehicles);
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
        
        Connection con = DB.getConnection();
        
		JButton btnupdatevehicles = new JButton("save");
		btnupdatevehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String vid=TextField.getText();
			String vname=TextField_1.getText();
			Float meter=Float.parseFloat(TextField_2.getText());
			String avail=TextField_3.getText();
			int cost=Integer.parseInt(TextField_4.getText());
			if(vehicledetails.checkavailability(vid) ) {
			try {  PreparedStatement st = con.prepareStatement("Update vehicle_details set v_name=?,meter_reading= ?,availability=?,costpermile=? where v_id=?");

            st.setString(1,vname);
            st.setString(3, avail);
            st.setFloat(2, meter);
            st.setInt(4, cost);
            st.setString(5, vid);
            st.executeUpdate();
          System.out.println("updated info for vehicle id : " + vid);
            JOptionPane.showMessageDialog(btnupdatevehicles, "Data Updated Successfully :)");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();}
			}else{
				JOptionPane.showMessageDialog(updatevehicle.this,"Unknown Error !!!\nUpdation not completed");
			}
			}
			
			
		});
		btnupdatevehicles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnupdatevehicles.setBackground(new Color(0,0, 0));
        btnupdatevehicles.setBounds(300, 400, 130, 50);
        contentPane.add(btnupdatevehicles);

		
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
	        
	        JButton btnLoad = new JButton("Load");
	        btnLoad.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  String cid = TextField.getText();
	            	Connection con = DB.getConnection();
	            	if(vehicledetails.checkavailability(cid)) {
	            	Statement st;
					try {
						PreparedStatement stmt = con.prepareStatement("select * from vehicle_details where v_id=?");
						stmt.setString(1,cid);
						ResultSet rs = stmt.executeQuery();
						while(rs.next())   
						{	TextField.setText(rs.getString(1));
				TextField_1.setText(rs.getString(2));
				TextField_2.setText(Float.toString(rs.getFloat(3)));
				TextField_3.setText(rs.getString(4));
				TextField_4.setText(Integer.toString(rs.getInt(5)));
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}}else {
					JOptionPane.showMessageDialog(updatevehicle.this,"Vehicle ID is Invalid !!!");
					TextField.setText("");
					TextField_1.setText("");
					TextField_2.setText("");
					TextField_3.setText("");
					TextField_4.setText("");
				}

	            }});
	        btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnLoad.setBackground(new Color(240, 240, 240));
	        btnLoad.setBounds(150, 400, 130, 50);
	        contentPane.add(btnLoad);
	}

}